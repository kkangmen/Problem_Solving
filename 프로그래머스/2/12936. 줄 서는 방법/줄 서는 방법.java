import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        long num = 1;
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            num *= i;
            arr.add(i);
        }
        
        k--;
        int index = 0;
        while (n > 0){
            num /= n;
            int arrIndex = (int)(k / num);
            k = k % num;
            n--;
            
            answer[index++] = arr.remove(arrIndex);
        }
        return answer;
    }
}