class Solution {
    public String solution(String s) {
        String answer = "";
                
        String[] nums = s.split(" ");
        
        int max, min;
        max = min = Integer.parseInt(nums[0]);
        
        for (String num : nums){
            max = Math.max(max, Integer.parseInt(num));
            min = Math.min(min, Integer.parseInt(num));
        }
        
        answer += min + " " + max;
        return answer;
    }
}