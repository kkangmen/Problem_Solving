import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        
        int[][] arr = new int[2][10];
        
        for (char c : X.toCharArray()){
            arr[0][c-'0']++;
        }
        
        for (char c : Y.toCharArray()){
            arr[1][c-'0']++;
        }
        
        for (int i = 9; i >= 0; i--){
            int min = Math.min(arr[0][i], arr[1][i]);
            while (min-- > 0){
                sb.append(i);
            }
        }
        
        if (sb.length() == 0){
            return "-1";
        }
        else if (sb.charAt(0) == '0'){
            return "0";
        }
        
        return sb.toString();
    }
}