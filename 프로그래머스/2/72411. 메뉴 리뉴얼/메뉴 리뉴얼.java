import java.util.*;

class Solution {
    public void dfs(String order, String current, int index, int length, Map<String, Integer> map){
        if (current.length() == length){
            map.put(current, map.getOrDefault(current, 0) + 1);
            return;
        }
        
        for (int i = index; i < order.length(); i++){
            dfs(order, current + order.charAt(i), i + 1, length, map);
        }
    }
    
    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for (int i = 0; i < orders.length; i++){
            char[] charArray = orders[i].toCharArray();
            Arrays.sort(charArray);
            orders[i] = String.valueOf(charArray);
        }
        
        for (int len : course){
            Map<String, Integer> map = new HashMap<>();
            
            for (String order : orders){
                dfs(order, "", 0, len, map);
            }
            
            int maxCount = 0;
            for (int count : map.values()){
                maxCount = Math.max(maxCount, count);
            }
            
            if (maxCount >= 2){
                for (String s : map.keySet()){
                    if (map.get(s) == maxCount){
                        answer.add(s);
                    }
                }                
            }
        }
        
        Collections.sort(answer);
        return answer;
    }
}