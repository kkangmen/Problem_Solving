import java.util.*;

class Solution {
    public List<Long> solution(long[] numbers) {
        List<Long> answer = new LinkedList<>();
        
        for (long l : numbers){
            if (l % 2 == 0){
                answer.add(l+1);
            } else {
                String binaryNum = "0" + Long.toString(l, 2);
                
                for (int i = binaryNum.length()-1; i > 0; i--){
                    if (binaryNum.charAt(i) == '1' && binaryNum.charAt(i-1) == '0'){
                        binaryNum = binaryNum.substring(0, i-1) + "10" + binaryNum.substring(i+1);
                        answer.add(Long.parseLong(binaryNum, 2));
                        break;
                    }
                }
            }
        }
        return answer;
    }
}