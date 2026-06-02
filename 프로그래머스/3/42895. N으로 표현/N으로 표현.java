import java.util.*;

class Solution {
    
    static List<Set<Integer>> dp = new ArrayList<>();
    
    public int solution(int N, int number) {
        int answer = 0;
        
        for (int i = 0; i < 9; i++){
            dp.add(new HashSet<>());
        }
        
        dp.get(1).add(N);
        
        for (int i = 2; i < 9; i++){
            Set<Integer> curSet = dp.get(i);
            for (int j = 1; j < i; j++){
                Set<Integer> set1 = dp.get(j);
                Set<Integer> set2 = dp.get(i-j);
                
                for (int num1 : set1){
                    for (int num2: set2){
                        curSet.add(num1+num2);
                        curSet.add(num1-num2);
                        curSet.add(num1*num2);
                        
                        if (num1 != 0 && num2 != 0){
                            curSet.add(num1/num2);
                        }
                    }
                }
            }
            curSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }
        
        for (Set s : dp){
            if (s.contains(number)){
                return dp.indexOf(s);
            }
        }
        return -1;
    }
}