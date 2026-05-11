import java.util.*;

class Solution {
    
    public static List<Set<Integer>> dp = new ArrayList<>();
    public int solution(int N, int number) {
        
        for (int i = 0; i < 9; i++){
            dp.add(new HashSet<>());
        }
        
        dp.get(1).add(N);
        
        for (int i = 2; i < 9; i++){
            
            Set<Integer> now = dp.get(i);
            
            for (int j = 1; j < i; j++){
                Set<Integer> set1 = dp.get(j);
                Set<Integer> set2 = dp.get(i-j);
                
                for (int num1 : set1){
                    for (int num2 : set2){
                        now.add(num1 + num2);
                        now.add(num1 - num2);
                        now.add(num1 * num2);
                        
                        if (num1 != 0 && num2 != 0){
                            now.add(num1/num2);
                        }
                    }
                }
            }
            now.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }
        
        for (Set<Integer> sub: dp){
            if (sub.contains(number)){
                return dp.indexOf(sub);
            }
        }
        
        return -1;
    }
}