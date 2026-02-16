import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        List<String[]> list = new ArrayList<>();
        
        s = s.substring(1, s.length()-1);
        
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if (ch == '{'){
                start = i;
            }
            if (ch == '}'){
                end = i;
                String[] temp = s.substring(start+1, end).split(",");
                list.add(temp);
            }
        }
        List<Integer> answer = new ArrayList<>();
        
        Collections.sort(list, (a, b) -> {
            return a.length - b.length;
        });
        
        String[] tempArr = list.get(list.size()-1);
        Map<String, Integer> map = new HashMap<>();
        for (String k : tempArr){
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        
        for (String[] arr : list){
            for (String ele : arr){
                if (map.get(ele) == 1){
                    answer.add(Integer.parseInt(ele));
                    map.put(ele, map.getOrDefault(ele, 0) - 1);
                }
            }
        }

        return answer;
    }
}