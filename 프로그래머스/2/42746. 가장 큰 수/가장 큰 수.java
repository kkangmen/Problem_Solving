import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        List<String> numberList = new LinkedList<>();
        
        for (int i : numbers){
            numberList.add(String.valueOf(i));
        }
        
        Collections.sort(numberList, (String o1, String o2) -> {
           return (o2+o1).compareTo(o1+o2);
        });
        
        if (numberList.get(0).equals("0")){
            return "0";
        }
        
        for (String s : numberList){
            sb.append(s);
        }
        return sb.toString();
    }
}