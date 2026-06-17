import java.util.*;

class Solution {
    
    List<Set<Integer>> dp = new ArrayList<>();
    
    public int solution(int N, int number) {
        int answer = 0;
        
        for (int i = 0; i < 8; i++){
            dp.add(new HashSet<>());
        }
        
        // 초기화
        dp.get(0).add(N);
        
        for (int i = 1; i < 8; i++){
            Set<Integer> curSet = dp.get(i);
            
            for (int j = 0; j < i; j++){
                Set<Integer> set1 = dp.get(j);
                Set<Integer> set2 = dp.get(i-1-j);
                
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
            curSet.add(Integer.parseInt(String.valueOf(N).repeat(i+1)));
        }
        
        for (Set set: dp){
            if (set.contains(number)){
                return dp.indexOf(set)+1;
            }
        }
        return -1;
    }
}