import java.util.*;

class Solution {
    
    static int[] arr;
    static boolean[] isUsed;
    static int[] num;
    static Set<Integer> numberSet = new HashSet<>();
    
    public boolean isPrimeNum(int num){
        if (num == 0 || num == 1){
            return false;
        }
        
        for (int i = 2; i < num; i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
    
    public void bF(int count, int max, int[] num){
        if (count == max){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < max; i++){
                sb.append(String.valueOf(num[i]));
            }
            numberSet.add(Integer.parseInt(sb.toString())); 
            return;
        }
        
        for (int i = 0; i < arr.length; i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                num[count] = arr[i];
                bF(count + 1, max, num);
                isUsed[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        int answer = 0;
        arr = new int[numbers.length()];
        isUsed = new boolean[numbers.length()];
        
        for (int i = 0; i < numbers.length(); i++){
            arr[i] = numbers.charAt(i)-'0';
        }
        
        for (int i = 1; i <= numbers.length(); i++){
            num = new int[i];
            bF(0, i, num);
        }
        
        for (int i : numberSet){
            if (isPrimeNum(i)){
                answer += 1;
            }
        }
        return answer;
    }
}