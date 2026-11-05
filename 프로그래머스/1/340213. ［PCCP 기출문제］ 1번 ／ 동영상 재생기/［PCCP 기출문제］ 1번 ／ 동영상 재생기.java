import java.util.*;

class Solution {
    public int toMin(String s){
        return Integer.parseInt(s.split(":")[0]) * 60 + Integer.parseInt(s.split(":")[1]);
    }
    
    public int checkSection(int currentTime, int op_start, int op_end){
        if (op_start <= currentTime && currentTime <= op_end){
            return op_end;
        }
        return currentTime;
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int video_len_int = toMin(video_len);
        int pos_int = toMin(pos);
        int op_start_int = toMin(op_start);
        int op_end_int = toMin(op_end);
        
        pos_int = checkSection(pos_int, op_start_int, op_end_int);
        System.out.println("current time: " + pos_int);
        for (String s : commands){
            switch(s){
                case "next":
                    if (pos_int <= video_len_int - 10){
                        pos_int += 10;
                    }
                    else {
                        pos_int = video_len_int;
                    }
                    pos_int = checkSection(pos_int, op_start_int, op_end_int);
                    System.out.println("current time: " + pos_int);
                    break;
                case "prev":
                    if (pos_int >= 10){
                        pos_int -= 10;
                    }
                    else {
                        pos_int = 0;
                    }
                    pos_int = checkSection(pos_int, op_start_int, op_end_int);
                    System.out.println("current time: " + pos_int);
                    break;
            }
        }
        
        System.out.println(pos_int/60);
        System.out.println(pos_int%60);
        
        String answer = String.format("%02d:%02d", pos_int/60, pos_int%60);
        return answer;
    }
}