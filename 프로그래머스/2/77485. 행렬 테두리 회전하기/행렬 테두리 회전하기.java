import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        // graph 초기화
        int[][] graph = new int[rows][columns];
        int num = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                graph[i][j] = ++num;
            }
        }
        
        // 각 queries마다
        for (int q = 0; q < queries.length; q++){
            int[] query = queries[q];
            int x1 = query[0]-1;
            int y1 = query[1]-1;
            int x2 = query[2]-1;
            int y2 = query[3]-1;
        
            int temp = graph[x1][y1];
            int min = temp;
            
            // 좌 x2-x1만큼, y1 고정, x1 -> x2
            for (int row = x1; row < x2; row++){
                graph[row][y1] = graph[row+1][y1];
                min = Math.min(min, graph[row][y1]);
            }
            // 하 y2-y1만큼, x2 고정, y1 -> y2
            for (int col = y1; col < y2; col++){
                graph[x2][col] = graph[x2][col+1];
                min = Math.min(min, graph[x2][col]);
            }
            // 우 좌만큼, y2 고정, x2 -> x1
            for (int row = x2; row > x1; row--){
                graph[row][y2] = graph[row-1][y2];
                min = Math.min(min, graph[row][y2]);
            }
            // 상 하만큼, x1 고정, y2 -> y1
            for (int col = y2; col > y1; col--){
                graph[x1][col] = graph[x1][col-1];
                min = Math.min(min, graph[x1][col]);
            }
            
            graph[x1][y1+1] = temp;
            answer[q] = min;
        }
        return answer;
    }
}