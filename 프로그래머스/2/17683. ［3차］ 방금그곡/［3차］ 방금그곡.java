import java.util.*;

class Solution {
    
    public int time(String clock){
        String[] arr = clock.split(":");
        
        return Integer.parseInt(arr[0])*60 + Integer.parseInt(arr[1]);
    }
    
    public String convert(String sound){
        return sound.replace("C#", "c")
            .replace("D#", "d")
            .replace("F#", "f")
            .replace("G#", "g")
            .replace("A#", "a");
    }
    
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        
        int candidate = 0;
        
        // m의 C# 같은거는 소문자 c로 바꾼다.
        m = convert(m);
        
        // 각 음악 정보마다
        for (int i = 0; i < musicinfos.length; i++){
            String musicInfo = musicinfos[i];
            
            // 해당 음악을 title, melody, latency로 나눈다.
            // 이때 melody의 C# 같은거는 소문자 c로 바꾼다.
            String[] arr = musicInfo.split(",");
            String title = arr[2];
            String melody = convert(arr[3]);
            int latency = time(arr[1]) - time(arr[0]);
            
            // latency 만큼 melody를 반복해서 늘린다.
            int quot = latency / melody.length();
            int remain = latency % melody.length();
            String totalMelody = melody.repeat(quot) + melody.substring(0, remain);
            
            // melody.contains(m)이고 기존 latency보다 길다면 최신화한다.
            if (totalMelody.contains(m) && candidate < latency){
                answer = title;
                candidate = latency;
            }
        }
        
        if (candidate == 0){
            return "(None)";
        }
        return answer;
    }
}