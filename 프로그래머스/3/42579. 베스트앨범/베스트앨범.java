import java.util.*;

class idxCount {
    int idx;
    int count;
    public idxCount(int idx, int count){
        this.idx = idx;
        this.count = count;
    }
}

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new LinkedList<>();
        Map<String, PriorityQueue<idxCount>> genreMap = new HashMap<>();
        Map<String, Integer> totalPlayMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            totalPlayMap.put(genre, totalPlayMap.getOrDefault(genre, 0) + play);
            
            genreMap.putIfAbsent(genre, new PriorityQueue<>((o1, o2) -> {
                if (o1.count == o2.count){
                    return Integer.compare(o1.idx, o2.idx);
                }
                return Integer.compare(o2.count, o1.count);
            }));
            
            genreMap.get(genre).add(new idxCount(i, play));
        }
        
        List<String> list = new LinkedList<>(totalPlayMap.keySet());
        
        Collections.sort(list, (String o1, String o2) -> {
           return Integer.compare(totalPlayMap.get(o2), totalPlayMap.get(o1)); 
        });
        
        for (String s : list){
            int count = 0;
            while (count < 2 && !genreMap.get(s).isEmpty()){
                answer.add(genreMap.get(s).poll().idx);
                count++;
            }
        }
        
        // print
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        return answer;
    }
}