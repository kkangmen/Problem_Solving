import java.util.*;

class Solution {
    
    String[][] graph;
    int[][] distance;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    class Point {
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int bfs(int x, int y, String target, int targetX, int targetY){
        Queue<Point> q = new LinkedList<>();
        
        q.offer(new Point(x, y));
        distance[x][y] = 0;
        
        while (!q.isEmpty()){
            Point curP = q.poll();
            
            if (graph[curP.x][curP.y].equals(target)){
                break;
            }
            
            for (int i = 0; i < 4; i++){
                int nx = curP.x + dx[i];
                int ny = curP.y + dy[i];
                if (0 <= nx && nx < graph.length && 0 <= ny && ny < graph[0].length){
                    if (distance[nx][ny] == -1 && !graph[nx][ny].equals("X")){
                        q.offer(new Point(nx, ny));
                        distance[nx][ny] = distance[curP.x][curP.y] + 1;
                    }
                }
            }
        }
        
        return distance[targetX][targetY];
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        int startX = 0;
        int startY = 0;
        int laberX = 0;
        int laberY = 0;
        int exitX = 0;
        int exitY = 0;
        // 초기화
        graph = new String[maps.length][maps[0].length()];
        distance = new int[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++){
            for (int j = 0; j < maps[i].length(); j++){
                graph[i][j] = String.valueOf(maps[i].charAt(j));
                if (graph[i][j].equals("S")){
                    startX = i;
                    startY = j;
                }
                if (graph[i][j].equals("L")){
                    laberX = i;
                    laberY = j;
                }
                if (graph[i][j].equals("E")){
                    exitX = i;
                    exitY = j;
                }
            }
        }
        for (int i = 0; i < maps.length; i++){
            Arrays.fill(distance[i], -1);
        }
        
        // 레버 탐색
        int num = bfs(startX, startY, "L", laberX, laberY);
        if(num == -1){
            return -1;
        } else {
            answer += num;
        }
//         System.out.println(answer);
        
//         for (int i = 0; i < graph.length; i++){
//             for (int j = 0; j < graph[0].length; j++){
//                 System.out.print(distance[i][j] + " ");
//             }
//             System.out.println();
//         }
        
        // 초기화 후 레버에서부터 다시 탐색
        for (int i = 0; i < maps.length; i++){
            Arrays.fill(distance[i], -1);
        }
        
        num = bfs(laberX, laberY, "E", exitX, exitY);
        if (num == -1){
            return -1;
        } else {
            answer += num;
        }
        
        // for (int i = 0; i < graph.length; i++){
        //     for (int j = 0; j < graph[0].length; j++){
        //         System.out.print(distance[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        return answer;
    }
}