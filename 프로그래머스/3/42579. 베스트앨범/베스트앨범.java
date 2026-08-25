import java.util.*;

class Solution {
    
    public class Info {
        String genre;
        int play;
        Info(String genre, int play){
            this.genre = genre;
            this.play = play;
        }
    }
    
    List<Info> list = new LinkedList<>();
    
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new LinkedList<>();
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        for (String s : map.keySet()){
            list.add(new Info(s, map.get(s)));
        }
        
        Collections.sort(list, (o1, o2) -> {
            return o2.play - o1.play;
        });
        
        for (int i = 0; i < list.size(); i++){
            String s = list.get(i).genre;
            List<int[]> compare = new LinkedList<>();
            
            for (int j = 0; j < genres.length; j++){
                if (s.equals(genres[j])){
                    compare.add(new int[]{plays[j], j});
                }
            }
            
            Collections.sort(compare, (o1, o2) -> {
                if (o2[0] == o1[0]){
                    return o1[1] - o2[1];
                }
                return o2[0]- o1[0];
            });
            
            int index = 0;
            while (index < 2 && index != compare.size()){
                answer.add(compare.get(index)[1]);
                index++;
            }
        }
        return answer;
    }
}