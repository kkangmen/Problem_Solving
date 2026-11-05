import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> cache = new LinkedList<>();
        
        if (cacheSize == 0){
            return cities.length * 5;
        }
        
        for (String city : cities){
            city = city.toLowerCase();
            
            if (cache.contains(city)){
                cache.remove(city);
                cache.offer(city);
                answer += 1;
            }
            else {
                if (cache.size() < cacheSize){
                    cache.offer(city);
                }
                else {
                    cache.offer(city);
                    cache.poll();
                }
                answer += 5;
            }
        }
        return answer;
    }
}