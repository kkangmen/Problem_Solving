import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        
        List<Integer> numberList = new LinkedList<>();
        for (int i : numbers){
            numberList.add(i);
        }
    
        Collections.sort(numberList, (o1, o2) -> {
           String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            
            return (s2+s1).compareTo(s1+s2);
        });
        
        if (numberList.get(0) == 0){
            return "0";
        }
        
        for (int i : numberList){
            answer.append(String.valueOf(i));
        }
        return answer.toString();
    }
}