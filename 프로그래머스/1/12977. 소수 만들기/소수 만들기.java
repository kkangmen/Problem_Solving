import java.util.*;

class Solution {
    public static boolean[] isPrime;
    
    public int solution(int[] nums) {
        int answer = 0;
        
        isPrime = new boolean[3000];
        Arrays.fill(isPrime, true);
        checkBoolean();
        
        int sum = 0;
        for (int i = 0; i < nums.length-2; i++){
            for (int j = i+1; j < nums.length-1; j++){
                for (int k = j+1; k < nums.length; k++){
                    sum = nums[i] + nums[j] + nums[k];
                    
                    if (isPrime[sum]){
                        answer++;
                    }
                    sum = 0;
                }
            }
        }
        return answer;
    }
    
    public void checkBoolean(){
        
        for (int i = 2; i < 60; i++){
            if (isPrime[i]){
                isPrime[i] = true;
                for (int j = i*i; j < 3000; j += i){
                    isPrime[j] = false;
                }
            }
        }
        return;
    }
}