import java.util.*;
class Solution {
    public List<Integer> solution(int n, long k) {
        List<Integer> answer = new ArrayList<>();
        
        // 20! = 시간초과 -> 백트래킹 불가
        // k--, [1,2,3,4]
        // n=4일 때, 4!/4 = 6
        // k/6 인덱스 정답에 추가하고, 배열에서 뺌.
        // k = k%6
        // n을 하나씩 줄임 3!/3 = 2
        // k/2 인덱스 정답에 추가하고, 배열에서 뺌.
        // k = k%2
        // n을 하나씩 줄임 2!/2 = 1
        // k/1 인덱스 정답 추가, 배열 뺌
        
        List<Integer> arr = new ArrayList<>();
        
        long fact = 1;
        for (int i = 1; i <= n; i++){
            arr.add(i);
            fact *= i;
        }
        k--;
        
        while (n > 0){
            fact /= n--;
            int index = (int)(k/fact);
            answer.add(arr.get(index));
            arr.remove(index);
            k %= fact;
        }
        return answer;
    }
}