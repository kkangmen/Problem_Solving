import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        // nums를 map에다가 넣는다.
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // 만약 map의 크기가 n/2보다 작다면 -> map의 크기가 정답
        if (map.size() < nums.length/2){
            return map.size();
        }
        // 만약 map의 크기가 n/2보다 크거나 같다면 -> n/2가 정답
        else {
            return nums.length/2;
        }
    }
}