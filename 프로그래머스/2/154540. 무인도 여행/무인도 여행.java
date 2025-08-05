import java.util.*;

class Location {
    int x;
    int y;
    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int[][] graph;
    static boolean[][] isVisited;
    static Queue<Location> queue = new LinkedList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public int bfs(int x, int y){
        int sum = 0;
        queue.offer(new Location(x, y));
        isVisited[x][y] = true;
        
        while (!queue.isEmpty()){
            Location l = queue.poll();
            sum += graph[l.x][l.y];
            
            for (int i = 0; i < 4; i++){
                int nx = l.x + dx[i];
                int ny = l.y + dy[i];
                if (0 <= nx && nx < graph.length && 0 <= ny && ny < graph[0].length){
                    if (graph[nx][ny] != 0 && !isVisited[nx][ny]){
                        queue.offer(new Location(nx, ny));
                        isVisited[nx][ny] = true;
                    }
                }
            }
        }
        
        return sum;
    }
    
    public int[] solution(String[] maps) {
        List<Integer> answer = new LinkedList<>();
        
        graph = new int[maps.length][maps[0].length()];
        isVisited = new boolean[maps.length][maps[0].length()];
        
        for (int i = 0; i < maps.length; i++){
            String isLand = maps[i];
            for (int j = 0; j < isLand.length(); j++){
                if (isLand.charAt(j) == 'X'){
                    graph[i][j] = 0;
                }
                else {
                    graph[i][j] = (int)(isLand.charAt(j) - '0');
                }
            }
        }
        
        for (int i = 0; i < maps.length; i++){
            for (int j = 0; j < maps[0].length(); j++){
                if (graph[i][j] != 0 && !isVisited[i][j]){
                    answer.add(bfs(i, j));
                }
                else {
                    isVisited[i][j] = true;
                }
            }
        }
        
        if(answer.isEmpty()){
            answer.add(-1);
        }
        else {
            Collections.sort(answer);
        }
        
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}