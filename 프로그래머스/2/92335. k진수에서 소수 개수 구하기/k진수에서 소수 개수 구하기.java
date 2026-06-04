import java.util.*;

class Solution {
    public boolean isPrime(Long number){
        if (number == 1){
            return false;
        }
        
        for (int i = 2; i <= Math.floor(Math.sqrt(number)); i++){
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        
        String s = Integer.toString(n, k);
        
        String[] numbers = s.split("0");
        
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i].equals("")){
                continue;
            }
            if (isPrime(Long.parseLong(numbers[i]))){
                System.out.println(numbers[i]);
                answer += 1;
            }
        }
        return answer;
    }
}