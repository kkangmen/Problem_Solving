import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    boolean[] isUsed;
    
    public boolean isPrime(int number){
        if (number == 1 || number == 0){
            return false;
        }
        
        int sqrtNum = (int) Math.sqrt(number);
        for (int i = 2; i <= sqrtNum; i++){
            if (number % i == 0){
                return false;
            }
        }
        
        return true;
    }
    
    public void bTracking(String curNum, String numbers, int index, int maxLength){
        if (curNum.length() == maxLength){
            // System.out.println(curNum);
            if (isPrime(Integer.valueOf(curNum))){
                // System.out.println(curNum);
                set.add(Integer.valueOf(curNum));
            }
            return;
        }    
        
        for (int i = 0; i < numbers.length(); i++){
            if (!isUsed[i]){
                isUsed[i] = true;
                bTracking(curNum + String.valueOf(numbers.charAt(i)), numbers, i+1, maxLength);
                isUsed[i] = false;    
            }
            
        }
    }
    
    public int solution(String numbers) {
        isUsed = new boolean[numbers.length()];
        
        for (int i = 1; i <= numbers.length(); i++){
            bTracking("", numbers, 0, i);
        }
        return set.size();
    }
}