import java.util.*;

class Solution {
    static int[] arr;
    static int[] num;
    static boolean[] isUsed;
    static Set<Integer> set = new HashSet<>();
    
    public boolean isPrimeNum(int num){
        if (num <=1 ){
            return false;
        }
        
        for (int i = 2; i < num; i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
    
    public void bruteForce(int count, int max, int length){
        if (count == max){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < max; i++){
                sb.append(String.valueOf(num[i]));
            }
            set.add(Integer.parseInt(sb.toString()));
            return;
        }
        
        for (int i = 0; i < length; i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                num[count] = arr[i];
                bruteForce(count+1, max, length);
                isUsed[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        int answer = 0;
        arr = new int[numbers.length()];
        
        for (int i = 0; i < numbers.length(); i++){
            arr[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }
        
        for (int i = 1; i <= numbers.length(); i++){
            isUsed = new boolean[numbers.length()];
            num = new int[i];
            bruteForce(0, i, numbers.length());
        }
        
        for (int i : set){
            if(isPrimeNum(i)){
                answer++;
            }
        }
        return answer;
    }
}