import java.util.*;

class Solution {
        
    public int convertTime(String time){
        int hour = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]);
        
        return hour*60 + min;
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        
        Queue<Integer> pq = new PriorityQueue<>();
        
        Arrays.sort(book_time, (s1, s2) -> {
            return s1[0].compareTo(s2[0]);
        });
            
        for (String[] s : book_time){
            int startTime = convertTime(s[0]);
            int endTime = convertTime(s[1]);
            
            if (!pq.isEmpty() && pq.peek() <= startTime){
                pq.poll();
            }
            
            pq.offer(endTime+10);
        }
        
        return pq.size();
    }
}