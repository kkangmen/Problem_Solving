import java.util.*;

class Solution {
    
    public void zip(int x, int y, int length, int[][] arr, int[] answer){
        boolean flag = true;
        int num = arr[x][y];
        
        // System.out.println(x + " " + y + " " + length);
        
        for (int i = x; i < x+length; i++){
            for (int j = y; j < y+length; j++){
                if (arr[i][j] != num){
                    flag = false;
                }
            }
        }
        
        if (flag){
            answer[num] += 1;
            return;
        } else {
            zip(x, y, length/2, arr, answer);
            zip(x, y+length/2, length/2, arr, answer);
            zip(x+length/2, y, length/2, arr, answer);
            zip(x+length/2, y+length/2, length/2, arr, answer);
        }
    }
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        
        zip(0, 0, arr.length, arr, answer);
        return answer;
    }
}