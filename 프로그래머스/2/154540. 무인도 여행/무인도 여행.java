import java.util.*;

class Solution {
    
    String[][] graph;
    Queue<int[]> q = new LinkedList<>();
    boolean[][] isVisited;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    public int bfs(int x, int y){
        int sum = 0;
        q.offer(new int[]{x, y});
        isVisited[x][y] = true;
        
        while (!q.isEmpty()){
            int[] node = q.poll();
            sum += Integer.parseInt(graph[node[0]][node[1]]);
            
            for (int i = 0; i < 4; i++){
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];
                
                if (0 <= nx && nx < graph.length && 0 <= ny && ny < graph[0].length
                   && !isVisited[nx][ny] && !graph[nx][ny].equals("X")){
                    q.offer(new int[]{nx, ny});
                    isVisited[nx][ny] = true;
                }
            }
        }
        return sum;
    }
    
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        
        int row = maps.length;
        int col = maps[0].length();
        // init
        isVisited = new boolean[row][col];
        graph = new String[row][col];
        for (int i = 0; i < row; i++){
            String map = maps[i];
            for (int j = 0; j < col; j++){
                graph[i][j] = String.valueOf(map.charAt(j));
            }
        }
        
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (!isVisited[i][j] && !graph[i][j].equals("X")){
                    answer.add(bfs(i, j));
                }
            }
        }
        
        if (answer.size() == 0){
            answer.add(-1);
            return answer.stream().mapToInt(i -> i).toArray();
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}