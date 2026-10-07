import java.util.*;

class Solution {
    
    Queue<int[]> q = new LinkedList<>();
    boolean[][] isVisited;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    public boolean isPossible(String[] place, int row, int col){
        
        q.offer(new int[]{row, col, 0});    
        isVisited[row][col] = true;
        
        while (!q.isEmpty()){
            int[] node = q.poll();
            // System.out.println("row: " + node[0] + " col: " + node[1]);
            if (node[2] == 2){
                continue;
            }
            
            for (int i = 0; i < 4; i++){
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];
                
                if (0 <= nx && nx < 5 && 0 <= ny && ny < 5){
                    if (place[nx].charAt(ny) == 'O' && !isVisited[nx][ny]){
                        q.offer(new int[]{nx, ny, node[2]+1});
                        isVisited[nx][ny] = true;
                    }
                    if (place[nx].charAt(ny) == 'P' && !isVisited[nx][ny]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public List<Integer> solution(String[][] places) {
        List<Integer> answer = new ArrayList<>();
        
        for (String[] place : places){
    
            boolean flag = true;
            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 5; j++){
                    if (place[i].charAt(j) == 'P'){
                        q = new LinkedList<>();
                        isVisited = new boolean[5][5];
                        if (!isPossible(place, i, j)){
                            flag = false;
                        }
                    }
                }
            }
            if (flag){
                answer.add(1);
            } else {
                answer.add(0);
            }
            // System.out.println("다음");
        }
        return answer;
    }
}