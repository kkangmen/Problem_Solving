import java.util.*;

class Solution {
    
    String[][] graph;
    int[][] distance;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    Queue<int[]> queue = new LinkedList<>();
    int row = 0;
    int col = 0;
    public void bfs(int[] start){
        int x = start[0];
        int y = start[1];
        distance[x][y] = 0;
        queue.offer(start);
        
        while(!queue.isEmpty()){
            int[] curNode = queue.poll();
            
            for (int i = 0; i < 4; i++){
                int nx = curNode[0];
                int ny = curNode[1];
                
                // 장애물이 나타나거나 맵 끝까지 갈때까지
                while ((0 <= nx+dx[i] && nx+dx[i] < row &&
                      0 <= ny+dy[i] && ny+dy[i] < col) &&
                    (!graph[nx+dx[i]][ny+dy[i]].equals("D"))){
                    nx += dx[i];
                    ny += dy[i];
                }
                
                if (distance[nx][ny] == -1){
                    queue.offer(new int[]{nx, ny});
                    distance[nx][ny] = distance[curNode[0]][curNode[1]] + 1;
                }
            }
        }
    }
    
    public int solution(String[] board) {
        int answer = 0;
        int[] start = new int[2];
        int[] goal = new int[2];
        // 그래프 초기화
        row = board.length;
        col = board[0].length();
        graph = new String[row][col];
        distance = new int[row][col];
        for (int i = 0; i < board.length; i++){
            String s = board[i];
            for (int j = 0; j < s.length(); j++){
                graph[i][j] = String.valueOf(s.charAt(j));
                if (graph[i][j].equals("R")){
                    start = new int[]{i, j};
                } else if (graph[i][j].equals("G")){
                    goal = new int[]{i, j};
                }
            }
        }
        for (int i = 0; i< row; i++){
            Arrays.fill(distance[i], -1);
        }
        // bfs 시작
        bfs(start);
        
        // for (int i = 0; i < row; i++){
        //     for (int j= 0; j < col; j++){
        //         System.out.print(graph[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println(start[0] + " " +  start[1]);
        
        // for (int i = 0; i < row; i++){
        //     for (int j = 0; j < col; j++){
        //         System.out.print(distance[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return distance[goal[0]][goal[1]];
    }
}