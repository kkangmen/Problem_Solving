import java.util.*;

class Solution {
    public List<Long> solution(int x, int n) {
        List<Long> answer = new LinkedList<>();
        int count = 0;
        long num = x;
        while (true){
            if (count == n){
                break;
            }
            answer.add(num);
            num += x;
            count++;
        }
        
        return answer;
    }
}