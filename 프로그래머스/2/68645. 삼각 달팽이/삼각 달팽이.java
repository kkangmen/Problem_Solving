import java.util.*;

class Solution {
    public List<Integer> solution(int n) {
        List<Integer> answer = new ArrayList<>();
        
        int[][] arr = new int[n][n];
        int num = 1;
        int row = -1; int col = 0;
        
        for (int i = 1; i <= n; i++){
            for (int j = 0; j < n+1-i; j++){
                if (i % 3 == 1){
                    row++;
                } else if (i % 3 == 2){
                    col++;
                } else {
                    row--;
                    col--;
                }
                arr[row][col] = num++;
            }
        }
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (arr[i][j] != 0){
                    answer.add(arr[i][j]);
                }
            }
        }
        return answer;
    }
}