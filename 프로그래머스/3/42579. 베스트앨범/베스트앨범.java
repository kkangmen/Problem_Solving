import java.util.*;
class Solution {
    
    class Song {
        int num;
        int plays;
        Song (int num, int plays){
            this.num = num;
            this.plays = plays;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        // Map<장르, 총수록곡> 삽입
        // Map<장르, List<Song>> 삽입
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, List<Song>> songMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++){
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
            
            if (!songMap.containsKey(genres[i])){
                songMap.put(genres[i], new ArrayList<>());
            }
            
            songMap.get(genres[i]).add(new Song(i, plays[i]));
        }

        // 장르맵의 키를 장르리스트로 만들어 정렬한다.
        List<String> genreList = new ArrayList<>(genreMap.keySet());
        Collections.sort(genreList, (o1, o2) -> {
            return Integer.compare(genreMap.get(o2), genreMap.get(o1));
        });
        
        // 장르리스트 순서대로
        for (int i = 0; i < genreList.size(); i++){
            // get해와서 List를 또 정렬
            List<Song> songList = songMap.get(genreList.get(i));
            
            if (songList.size() == 1){
                answer.add(songList.get(0).num);
            }
            
            else {
                Collections.sort(songList, (o1, o2) -> {
                    return Integer.compare(o2.plays, o1.plays);
                });
                answer.add(songList.get(0).num);
                answer.add(songList.get(1).num);
            }
            // size가 1이라면 그대로 정답에 넣고
            // size가 2이상이면 맨앞 2개만 정답에 넣는다.
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}