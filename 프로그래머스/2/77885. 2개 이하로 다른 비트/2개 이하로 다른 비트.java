import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++){
            // 짝수면 +1
            if (numbers[i] % 2 == 0){
                answer[i] = numbers[i] + 1;
            } else {
                String binaryNum = Long.toString(numbers[i], 2);
                binaryNum = "0" + binaryNum;
                
                for (int j= binaryNum.length()-1; j>= 0; j--){
                    if (binaryNum.charAt(j) == '0'){
                        binaryNum = binaryNum.substring(0, j) + "10" + binaryNum.substring(j+2, binaryNum.length());
                        answer[i] = Long.parseLong(binaryNum, 2);
                        break;
                    }
                }
            }
        }
        return answer;
    }
}