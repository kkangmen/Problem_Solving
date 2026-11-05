import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        
        List<Set<Integer>> list = new LinkedList<>();
        
        for (int i = 0; i < 8; i++){
            list.add(new HashSet<>());
        }
        
        list.get(0).add(N);
        for (int i = 1; i < 8; i++){
            Set<Integer> curSet = list.get(i);
            
            for (int j = 0; j < i; j++){
                Set<Integer> set1 = list.get(j);
                Set<Integer> set2 = list.get(i-j-1);
                
                for (int num1 : set1){
                    for (int num2 : set2){
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
        
        for (int i = 0; i < 8; i++){
            Set<Integer> set = list.get(i);
            for (int j : set){
                if (j == number){
                    return i+1;
                }
            }
        }
        return -1;
    }
}