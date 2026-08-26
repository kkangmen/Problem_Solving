import java.util.*;

class Solution {
    int[] answer = new int[2];
    
    public boolean allSame(int row, int col, int len, int[][] arr){
        boolean flag = true;
        for (int i = row; i < row+len; i++){
            for (int j = col; j < col+len; j++){
                if (arr[row][col] != arr[i][j]){
                    flag = false;
                }
            }
        }
        return flag;
    }
    
    public void dAQ(int row, int col, int len, int[][] arr){
        if (allSame(row, col, len, arr)){
            if (arr[row][col] == 0){
                answer[0]++;
            } else {
                answer[1]++;
            }
            return;   
        }
        
        dAQ(row, col, len/2, arr);
        dAQ(row, col+len/2, len/2, arr);
        dAQ(row+len/2, col, len/2, arr);
        dAQ(row+len/2, col+len/2, len/2, arr);
    }
    
    public int[] solution(int[][] arr) {
        
        dAQ(0, 0, arr.length, arr);
        return answer;
    }
}