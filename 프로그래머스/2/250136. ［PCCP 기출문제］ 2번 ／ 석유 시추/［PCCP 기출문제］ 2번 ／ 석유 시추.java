import java.util.*;

class Location {
    int x;
    int y;
    Location (int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int[] oils;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Location> queue = new LinkedList<>();
    static boolean[][] isVisited;
    
    public void bfs(int x, int y, int row, int col, int[][] land){
        int total = 1;
        isVisited[x][y] = true;
        queue.offer(new Location(x, y));
        int startCol = y;
        int endCol = y;
        
        while(!queue.isEmpty()){
            Location l = queue.poll();
            for (int i = 0; i < 4; i++){
                int nx = l.x + dx[i];
                int ny = l.y + dy[i];
                if (0 <= nx && nx < row && 0 <= ny && ny < col){
                    if (!isVisited[nx][ny] && land[nx][ny] == 1){
                        isVisited[nx][ny] = true;
                        queue.offer(new Location(nx, ny));
                        total++;
                        if (endCol < ny){
                            endCol = ny;
                        }
                    }
                }
            }
        } 
        //System.out.println("StartCol = " + startCol + " EndCol = " + endCol);
        for (int i = startCol; i <= endCol; i++){
            oils[i] += total;
        }
    }
    
    public int solution(int[][] land) {
        int row = land.length;
        int col = land[0].length;
        isVisited = new boolean[row][col];
        oils = new int[col];
        for (int i = 0; i < col; i++){
            for (int j = 0; j < row; j++){
                if (land[j][i] == 1 && !isVisited[j][i]){
                    //System.out.println("BFS Start");
                    bfs(j, i, row, col, land);
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < col; i++){
            answer = Math.max(answer, oils[i]);
        }
        
        return answer;
    }
}