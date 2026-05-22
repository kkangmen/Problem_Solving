import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i <= t*t; i++){
            sb.append(Integer.toString(i, n).toUpperCase());
        }
        
        String str = sb.toString();
        // System.out.println(str);
        for (int i = p-1; i < (p-1)+(t-1)*m+1; i += m){
            answer.append(String.valueOf(str.charAt(i)));
        }
        return answer.toString();
    }
}