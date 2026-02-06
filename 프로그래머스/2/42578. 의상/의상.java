import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] clotheList : clothes){
            String kind = clotheList[1];
            
            map.put(kind, map.getOrDefault(kind, 0) + 1);
        }
        
        int mult = 1;
        for (String s : map.keySet()){
            int num = map.get(s);
            mult *= num+1;
        }
        
        mult -= 1;
        return mult;
    }
}