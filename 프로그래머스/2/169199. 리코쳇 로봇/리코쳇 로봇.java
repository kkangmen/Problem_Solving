import java.util.*;

class Solution {
    
    String[][] map;
    int[][] distance;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int[] start;
    int[] end;
    int row = 0; int col = 0;
    Queue<int[]> q = new LinkedList<>();
    
    public void bfs(){
        q.offer(start);
        distance[start[0]][start[1]] = 1;
        
        while (!q.isEmpty()){
            int[] curPoint = q.poll();
            
            for (int i = 0; i < 4; i++){
                int nx = curPoint[0];
                int ny = curPoint[1];
                // 다음 이동할 칸이 벽에 닿거나, D가 나올때까지 이동
                while ((0 <= nx+dx[i] && nx+dx[i] < row && 0 <= ny+dy[i] && ny+dy[i] < col) 
                    && (!map[nx+dx[i]][ny+dy[i]].equals("D"))){
                    nx += dx[i];
                    ny += dy[i];
                }
                
                if (distance[nx][ny] == 0){
                    distance[nx][ny] = distance[curPoint[0]][curPoint[1]] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
    
    public int solution(String[] board) {
        int answer = 0;
        
        // 초기화
        row = board.length;
        col = board[0].length();
        map = new String[row][col];
        distance = new int[row][col];
        
        for (int i = 0; i < board.length; i++){
            String s = board[i];
            for (int j = 0; j < s.length(); j++){
                map[i][j] = String.valueOf(s.charAt(j));
                if (map[i][j].equals("R")){
                    start = new int[]{i, j};
                }
                if (map[i][j].equals("G")){
                    end = new int[]{i, j};
                }
            }
        }
        
        bfs();
        
        if (distance[end[0]][end[1]] == 0){
            return -1;
        }
        return distance[end[0]][end[1]]-1;
    }
}