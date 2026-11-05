import java.util.*;

class Solution {
    
    int[][] distance;
    Queue<Point> q = new LinkedList<>();
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    class Point {
        int x;
        int y;
        Point (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public void bfs(int x, int y, int[][] maps){
        distance[x][y] = 1;
        q.offer(new Point(x, y));
        
        while (!q.isEmpty()){
            Point p = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if (0 <= nx && nx < maps.length && 0 <= ny && ny < maps[0].length){
                    if (maps[nx][ny] == 1 && distance[nx][ny] == 0){
                        q.offer(new Point(nx, ny));
                        distance[nx][ny] = distance[p.x][p.y] + 1;
                    }
                }
                
            }
        }
    }
        
    public int solution(int[][] maps) {        
        // 배열 선언
        distance = new int[maps.length][maps[0].length];
        
        // bfs
        bfs(0, 0, maps);
        
        int answer = distance[maps.length-1][maps[0].length-1];
        if (answer == 0){
            return -1;
        }
        
        // 출력
        // for (int i = 0; i < maps.length; i++){
        //     for (int j = 0; j < maps[0].length; j++){
        //         System.out.print(distance[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return answer;
    }
}