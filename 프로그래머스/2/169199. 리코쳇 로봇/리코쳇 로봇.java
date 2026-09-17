import java.util.*;

class Solution {
    
    String[][] map;
    int[][] distance;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    Queue<int[]> q = new LinkedList<>();
    int[] start;
    int[] end;
    
    public void bfs(int x, int y){
        distance[x][y] = 0;
        q.offer(new int[]{x, y});
        
        while(!q.isEmpty()){
            int[] curNode = q.poll();
            
            for (int i = 0; i < 4; i++){
                int nx = curNode[0];
                int ny = curNode[1];
                // 벽에 닿거나, 맵 끝까지 이동
                while (0 <= nx+dx[i] && nx+dx[i] < map.length && 0 <= ny+dy[i] && ny+dy[i] < map[0].length 
                       && !map[nx+dx[i]][ny+dy[i]].equals("D")){
                    nx += dx[i];
                    ny += dy[i];
                }
                // 해당 지점에 방문한 적이 없다면 거리 갱신 및 추가
                if (distance[nx][ny] == -1){
                    distance[nx][ny] = distance[curNode[0]][curNode[1]] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
    
    public int solution(String[] board) {
        int answer = 0;
        
        int row = board.length;
        int col = board[0].length();
        // init
        map = new String[row][col];
        distance = new int[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                map[i][j] = String.valueOf(board[i].charAt(j));
                if (map[i][j].equals("R")){
                    start = new int[]{i, j};
                }
                if (map[i][j].equals("G")){
                    end = new int[]{i, j};
                }
            }
        }    
        for (int i = 0; i < row; i++){
            Arrays.fill(distance[i], -1);
        }
        // bfs
        bfs(start[0], start[1]);
        
        // 출력
        // for (int i = 0; i < row; i++){
        //     for (int j = 0; j < col; j++){
        //         System.out.print(distance[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return distance[end[0]][end[1]];
    }
}