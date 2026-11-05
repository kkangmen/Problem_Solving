import java.util.*;

class Solution {
    
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    char[][] grid;
    
    public List<int[]> bfs(char request, int row, int col){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[row][col];
        List<int[]> removedList = new ArrayList<>();
        
        q.offer(new int[]{0,0});
        isVisited[0][0] = true;
        
        while (!q.isEmpty()){
            int[] node = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];
                if (0 <= nx && nx < row && 0 <= ny && ny < col
                   && !isVisited[nx][ny]){
                   if (grid[nx][ny] == '.'){
                    q.offer(new int[]{nx, ny});
                    isVisited[nx][ny] = true;
                   } else if (grid[nx][ny] == request){
                        removedList.add(new int[]{nx, ny});
                       isVisited[nx][ny] = true;
                    }
                }
            }
        }
        return removedList;
    }
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int row = storage.length;
        int col = storage[0].length();
        
        // 격자판에 1 패딩을 적용한다.
        grid = new char[row+2][col+2];
        for (int i = 0; i < row+2; i++){
            Arrays.fill(grid[i], '.');
        }
        for (int i = 0; i < storage.length; i++){
            for (int j = 0; j < storage[i].length(); j++){
                grid[i+1][j+1] = storage[i].charAt(j);
            }
        }
        
        // 각 명령마다
        for (int r = 0; r < requests.length; r++){
            String request = requests[r];
            // System.out.println(r + "번째");
            // 만약 길이가 1이면
            if (request.length() == 1){
                // (0,0)부터 시작하는 bfs를 통해 인접한 노드의 
                // 단어와 일치하면 해당 노드를 리스트에 담아
                // .으로 바꾼다.
                List<int[]> removeList = new ArrayList<>();
                removeList = bfs(request.charAt(0), row+2, col+2);
                
                for (int[] node : removeList){
                    // System.out.println("지워할 위치=" + " x:" + node[0] + " y: " + node[1]);
                    grid[node[0]][node[1]] = '.';
                }
            }
        
            // 만약 길이가 2이면
            else {
                // 2중 반복문을 통해 해당 문자를 .으로 바꾼다.
                for (int i = 0; i < row+2; i++){
                    for (int j = 0; j < col+2; j++){
                        if (grid[i][j] == request.charAt(0)){
                            grid[i][j] = '.';
                        }
                    }
                }
            }
        }
        
        for (int i = 1; i < row+1; i++){
            for (int j = 1; j < col+1; j++){
                if (grid[i][j] != '.'){
                    answer++;
                }
            }
        }
        return answer;
    }
}
// 시간복잡도 100 * 50*50