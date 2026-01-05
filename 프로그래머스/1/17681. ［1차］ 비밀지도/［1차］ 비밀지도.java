import java.util.*;

class Solution {
    public List<String> solution(int n, int[] arr1, int[] arr2) {
        List<String> answer = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++){
            int num1 = arr1[i]; // 9
            int num2 = arr2[i]; // 30
            
            String s1 = Integer.toBinaryString(num1);
            String s2 = Integer.toBinaryString(num2);
            
            while (s1.length() < n){
                s1 = "0" + s1;
            }
            while (s2.length() < n){
                s2 = "0" + s2;
            }
            
            for (int j = 0; j < n; j++){
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                
                if (c1 == '0' && c2 == '0'){
                    sb.append(" ");
                }
                else {
                    sb.append("#");
                }
            }
            
            answer.add(sb.toString());
            sb.delete(0, sb.length());
        }
        return answer;
    }
}