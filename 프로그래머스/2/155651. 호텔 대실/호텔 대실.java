import java.util.*;

class Solution {
    boolean[] isChecked;
    
    public int timeConvert(String time){
        String[] arr = time.split(":");
        int hour = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[1]);
        return hour*60 + min;
    }
    
    public void bfs(int index, String[][] book_time){
        isChecked[index] = true;
        int endTime = timeConvert(book_time[index][1]);
        
        for (int i = index+1; i < book_time.length; i++){
            int nxtStartTime = timeConvert(book_time[i][0]);
            
            if ((endTime + 10 <= nxtStartTime) && (!isChecked[i])){
                endTime = timeConvert(book_time[i][1]);
                isChecked[i] = true;
            }
        }
    }
    public int solution(String[][] book_time) {
        int answer = 0;
        
        Arrays.sort(book_time, (o1, o2) -> {
           return o1[0].compareTo(o2[0]); 
        });
        isChecked = new boolean[book_time.length];
        
        for (int i = 0; i < isChecked.length; i++){
            if (!isChecked[i]){
                bfs(i, book_time);
                answer++;
            }
        }
        return answer;
    }
}