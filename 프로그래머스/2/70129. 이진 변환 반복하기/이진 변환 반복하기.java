import java.util.*;

class Solution {
    public String toBinary(int num){
        StringBuilder sb = new StringBuilder();
        
        while (num > 0){
            sb.append(String.valueOf(num % 2));
            num /= 2;
        }
        
        return sb.reverse().toString();
    }
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int countPlays = 0;
        int countZerosSum = 0;
        while (!s.equals("1")){
            int countZeros = 0;
            countPlays++;
            // System.out.print(countPlays + ": ");
            
            while (s.contains("0")){
                countZeros++;
                s = s.replaceFirst("0", "");
            }
            
            // System.out.print(countZeros + ": ");
            
            s = toBinary(s.length());
            countZerosSum += countZeros;
            // System.out.println("result= " + s);
        }
        
        answer[0] = countPlays;
        answer[1] = countZerosSum;
        return answer;
    }
}