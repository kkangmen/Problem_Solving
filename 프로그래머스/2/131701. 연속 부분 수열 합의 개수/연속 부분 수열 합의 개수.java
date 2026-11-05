import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        
        for (int length = 1; length < elements.length+1; length++){
            
            for (int index = 0; index < elements.length; index++){
                int sum = 0;
                
                // length = 3, index = 3
                for (int i = index; i < index + length; i++){
                    // i = 3, 4, 5
                    if (i >= elements.length){
                        sum += elements[i-elements.length];
                    }
                    else {
                        sum += elements[i];
                    }
                }
                // System.out.println(sum);
                set.add(sum);
            }
        }
        
        return set.size();
    }
}