import java.util.*;

class Solution {
    
    String[][] map;
    int[][] distance;
    int[] dx = {0, 1, 0 ,-1};
    int[] dy = {1, 0, -1, 0};
    int startX, startY = 0;
    int goalX, goalY = 0;
    int answer = 0;
    Queue<int[]> q = new LinkedList<>();
    
    public void bfs(int x, int y){
        q.offer(new int[]{x, y});
        distance[x][y] = 0;
        
        while (!q.isEmpty()){
            int[] locate = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = locate[0];
                int ny = locate[1];
                while (true){
                    nx += dx[i];
                    ny += dy[i];
                    if ((0 <= nx && nx < map.length && 0 <= ny && ny < map[0].length) &&
                       (!map[nx][ny].equals("D"))){
                        continue;
                    } else {
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                }
                if (distance[nx][ny] == -1){
                    q.offer(new int[]{nx, ny});
                    distance[nx][ny] = distance[locate[0]][locate[1]] + 1;
                }
            }   
        }
    }
    
    public int solution(String[] board) {
        // init
        int row = board.length;
        int col = board[0].length();
        map = new String[row][col];
        distance = new int[row][col];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length(); j++){
                map[i][j] = String.valueOf(board[i].charAt(j));
                if (map[i][j].equals("R")){
                    startX = i;
                    startY = j;
                }
                if (map[i][j].equals("G")){
                    goalX = i;
                    goalY = j;
                }
            }
        }
        for (int i = 0; i < row; i++){
            Arrays.fill(distance[i], -1);
        }

        // dfs
        bfs(startX, startY);
        
        // for (int i = 0; i < distance.length; i++){
        //     for (int j = 0; j < distance[0].length; j++){
        //         System.out.print(distance[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return distance[goalX][goalY];
    }
}