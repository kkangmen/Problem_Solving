import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        
        int[][] triangle = new int[n][n];
        
        int number = 1;
        int row = -1;
        int col = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n-i; j++){
                if (i%3 == 0){
                    row++;
                } else if (i%3 == 1){
                    col++;
                } else {
                    row--;
                    col--;
                }
                
                triangle[row][col] = number++;
            }
        }
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (triangle[i][j] != 0){
                    answer.add(triangle[i][j]);
                }
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}