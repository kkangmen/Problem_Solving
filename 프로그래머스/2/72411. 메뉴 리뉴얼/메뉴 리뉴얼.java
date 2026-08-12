import java.util.*;

class Solution {
    
    Map<String, Integer> map;
    
    public void dfs(String order, String curMenu, int idx, int max){
        if (curMenu.length() == max){
            map.put(curMenu, map.getOrDefault(curMenu, 0) + 1);
            return;
        }
        
        for (int i = idx+1; i < order.length(); i++){
            dfs(order, curMenu + order.charAt(i), i, max);
        }
    }
    
    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new LinkedList<>();
        
        // 정렬
        for (int i = 0; i < orders.length; i++){
            char[] charArray = orders[i].toCharArray();
            Arrays.sort(charArray);
            orders[i] = String.valueOf(charArray);
        }
        
        for (int menuCnt : course){
            map = new HashMap<>();
            
            for (String order : orders){
                dfs(order, "", -1, menuCnt);
            }
            
            // 최대 갯수 구하기
            int max = 2;
            for (String s : map.keySet()){
                if (map.get(s) > max){
                    max = map.get(s);
                }
            }
            
            for (String s: map.keySet()){
                if (map.get(s) == max){
                    answer.add(s);
                }
            }
        }
        
        Collections.sort(answer);
        return answer;
    }
}