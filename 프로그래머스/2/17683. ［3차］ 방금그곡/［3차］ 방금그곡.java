import java.util.*;

class Solution {
    
    public String convert(String s){
        return s.replace("C#", "c")
            .replace("D#", "d")
            .replace("F#", "f")
            .replace("G#", "g")
            .replace("A#", "a");
    }
    
    public int toTime(String s){
        int hour = Integer.parseInt(s.split(":")[0]);
        int min = Integer.parseInt(s.split(":")[1]);
        
        return hour*60 + min;
    }
    
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxDuration = 0;
        
        m = convert(m);
        
        for (String musicinfo : musicinfos){
            String[] arr = musicinfo.split(",");
            int duration = toTime(arr[1]) - toTime(arr[0]);
            String title = arr[2];
            String music = convert(arr[3]);
            
            music = music.repeat(duration/music.length()) + 
                music.substring(0, duration%music.length());
            
            if (music.contains(m) && duration > maxDuration){
                answer = title;
                maxDuration = duration;
            }
        }
        return answer;
    }
}