import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();
        Set<String> set = new HashSet<>();
        
        String[] elements = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        
        Arrays.sort(elements, (a, b) -> {
            return a.length() - b.length();
        });
            
        for (String element : elements){
            for (String elementWord : element.split(",")){
                if (set.add(elementWord)){
                    answer.add(Integer.parseInt(elementWord));
                }
            }
        }
        
        return answer;
    }
}