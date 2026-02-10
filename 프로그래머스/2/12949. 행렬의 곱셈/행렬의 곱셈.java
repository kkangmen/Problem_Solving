import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for (int i = 0; i < arr1.length; i++){
            int[] row = arr1[i];
            
            for (int j = 0; j < arr2[0].length; j++){
                int[] col = new int[arr2.length];
                for (int k = 0; k < arr2.length; k++){
                    col[k] = arr2[k][j];
                }
                
                // row[1, 4]
                // col[3, 3]
                for (int p = 0; p < row.length; p++){
                    answer[i][j] += row[p]*col[p];
                }
            }
            
            
        }
        return answer;
    }
}

// [1 4]  [3 3]
// [3 2]  [3 3]
// [4 1]
// 3 x 2  2 x 2 => 3 x 2

// [0][0]*[0][0] + [0][1] * [1][0] => [0][0]
// [0][0]*[0][1] + [0][1] * [1][1] => [0][1]

// [1][0]*[0][0] + [1][1] * [1][0] => [1][0]
// [1][0]*[0][1] + [1][1] * [1][1] => [1][1]