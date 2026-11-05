import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int answerTime = 0;
        // n = 운행 횟수, t = 운행 간격, m = 최대 크루 수
        // 09시부터 n회, t분 간격 도착
        
        // 분단위로 통일
        List<Integer> crewList = new ArrayList<>();
        for (String s : timetable){
            int hour = Integer.parseInt(s.split(":")[0]);
            int min = Integer.parseInt(s.split(":")[1]);
            crewList.add(hour*60+min);
        }
        Collections.sort(crewList);
        
        int arrivalTime = 60*9;
        int crewIdx = 0;
        int maxCrew = m;
        int lastBoardTime = 0;
        
        // 운행 횟수만큼 반복
        for (int i = 0; i < n; i++){
            int curCrew = 0;
            
            // 해당 시간 전에 온 사람들을 최대 m명 태운다.
            while (crewIdx < crewList.size()){
                if (crewList.get(crewIdx) <= arrivalTime && curCrew < maxCrew){
                    lastBoardTime = crewList.get(crewIdx);
                    crewIdx++;
                    curCrew++;
                } else {
                    break;
                }
            }
            
            // 만약 마지막 운행이었다면
            if (i == n-1){
                // 자리가 남아있다면 해당 버스 시각이 정답
                if (curCrew < maxCrew){
                    answerTime = arrivalTime;
                }
                // 자리가 남아있지 않다면 마지막 탄 사람 - 1분이 정답
                else {
                    answerTime = lastBoardTime-1;
                }
            }
            
            // 다음 도착 시간 갱신
            arrivalTime += t;
        }
        
        int answerHour = answerTime/60;
        int answerMin = answerTime%60;
        
        
        return String.format("%02d:%02d", answerHour, answerMin);
    }
}