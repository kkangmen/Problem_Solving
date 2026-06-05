import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++){
            long number = numbers[i];
            
            if (number%2 == 0){
                answer[i] = number + 1;
            } else {
                String binaryNum = "0" + Long.toString(number, 2);
                int lastZeroIndex = binaryNum.lastIndexOf("0");
                
                binaryNum = binaryNum.substring(0, lastZeroIndex) + "10" + binaryNum.substring(lastZeroIndex+2);
                answer[i] = Long.parseLong(binaryNum, 2);
            }
        }
        return answer;
    }
}