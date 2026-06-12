import java.util.*;

class Solution {
    
    List<String> strNumList = new ArrayList<>();
    
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        
        for (int i : numbers){
            strNumList.add(String.valueOf(i));
        }
        
        Collections.sort(strNumList, (o1, o2) -> {
           return (o2+o1).compareTo(o1+o2);
        });
        
        if (strNumList.get(0).equals("0")){
            return "0";
        }
        
        for (String s : strNumList){        
            answer.append(s);
        }
        
        return answer.toString();
    }
}