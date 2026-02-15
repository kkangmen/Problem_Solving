import java.util.*;

class Solution {
    public static int[][] graph;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public Queue<Point> queue = new LinkedList<>();
    
    public class Point {
        private int x;
        private int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public void bfs(int x, int y, int[][] maps){
        queue.offer(new Point(x, y));
        graph[x][y] = 1;
        
        while (!queue.isEmpty()){
            Point p = queue.poll();
            int cx = p.x;
            int cy = p.y;
            for (int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
            
                if (0 <= nx && nx < graph.length && 0 <= ny && ny < graph[0].length){
                    if (maps[nx][ny] == 1 && graph[nx][ny] == 0){
                        queue.offer(new Point(nx, ny));
                        graph[nx][ny] = graph[cx][cy] + 1;
                    }
                }
            }
        }
        
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        graph = new int[maps.length][maps[0].length];
        
        bfs(0, 0, maps);
        
        if (graph[maps.length-1][maps[0].length-1] == 0){
            return -1;
        }
        
        answer = graph[maps.length-1][maps[0].length-1];
        
        // for (int i = 0; i < maps.length; i++){
        //     for (int j = 0; j < maps[0].length; j++){
        //         System.out.print(graph[i][j]);
        //     }
        //     System.out.println();
        // }
        return answer;
    }
}