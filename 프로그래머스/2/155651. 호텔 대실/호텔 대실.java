import java.util.*;

class Solution {
    boolean[] isChecked;
    
    public int timeConvert(String s){
        String[] time = s.split(":");
        
        int hour = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        
        return hour*60+min;
    }
    
    public void bfs(int index, String[][] book_time){
        isChecked[index] = true;
        int endTime = timeConvert(book_time[index][1]);
        for (int i = index+1; i < isChecked.length; i++){
            int startTime = timeConvert(book_time[i][0]);
            
            if (!isChecked[i] && endTime + 10 <= startTime){
                isChecked[i] = true;
                endTime = timeConvert(book_time[i][1]);
            }
        }
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        
        isChecked = new boolean[book_time.length];
        Arrays.sort(book_time, (o1, o2) -> {
           return o1[0].compareTo(o2[0]); 
        });
        
        
        for (int i = 0; i < book_time.length; i++){
            if (!isChecked[i]){
                answer++;
                bfs(i, book_time);
            }    
        }
        
        // for (String[] s : book_time){
        //     System.out.println(s[0] + " " + s[1]);
        // }
        return answer;
    }
}