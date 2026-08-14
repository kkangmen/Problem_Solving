import java.util.*;

class Solution {
    
    Queue<Integer> pq = new PriorityQueue<>();
    
    public int convertToTime(String s){
        int hour = Integer.parseInt(s.split(":")[0]);
        int min = Integer.parseInt(s.split(":")[1]);
        
        return min + hour*60;
    }
    public int solution(String[][] book_time) {
        int answer = 0;
        
        Arrays.sort(book_time, (s1, s2) -> {
            return s1[0].compareTo(s2[0]);
        });
        
        for (String[] s : book_time){
            int startTime = convertToTime(s[0]);  
            int endTime = convertToTime(s[1]) + 10;
            
            if (pq.isEmpty()){
                pq.offer(endTime);
            } else {
                // 다음 시작 시간이 pq에 있는 끝나는 시각 + 10분 보다 작거나 같으면 불가
                if (startTime < pq.peek()){
                    pq.offer(endTime);
                } else {
                    pq.poll();
                    pq.offer(endTime);
                }
            }
        }
        return pq.size();
    }
}