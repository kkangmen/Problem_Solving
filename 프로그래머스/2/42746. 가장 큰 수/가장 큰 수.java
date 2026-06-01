import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        
        List<String> numberList = new ArrayList<>();
        
        for (int i : numbers){
            numberList.add(String.valueOf(i));
        }
        
        Collections.sort(numberList, (String s1, String s2) -> {
           return Integer.parseInt(s2+s1) - Integer.parseInt(s1+s2); 
        });
        
        for (int i = 0; i < numberList.size(); i++){
            if (numberList.get(0).equals("0")){
                return "0";
            }
            sb.append(numberList.get(i));
        }
        
        
        return sb.toString();
    }
}