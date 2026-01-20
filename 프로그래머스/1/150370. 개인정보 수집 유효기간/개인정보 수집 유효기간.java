import java.util.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> termMap = new HashMap<>();
        
        for (String s : terms){
            String termType = s.split(" ")[0];
            int month = Integer.parseInt(s.split(" ")[1]);
            
            termMap.put(termType, month);
        }
        
        int todayYear = Integer.parseInt(today.split("\\.")[0]);
        int todayMonth = Integer.parseInt(today.split("\\.")[1]);
        int todayDay = Integer.parseInt(today.split("\\.")[2]);
        // System.out.println("today" + " " + todayYear + " " + todayMonth + " " + todayDay);
        
        for (int i = 0; i < privacies.length; i++){
            String s = privacies[i];
            
            int pastYear = Integer.parseInt(s.split("\\.")[0]);
            int pastMonth = Integer.parseInt(s.split("\\.")[1]);
            String pastDayAndType = s.split("\\.")[2];
            int pastDay = Integer.parseInt(pastDayAndType.split(" ")[0]);
            String termType = pastDayAndType.split(" ")[1];
            
            
            int expireMonth = termMap.get(termType);
            int tempMonth = pastMonth + expireMonth;
            while (tempMonth > 12){
                pastYear++;
                tempMonth -= 12;
            }
            if (pastDay == 1){
                tempMonth -= 1;
                pastDay = 28;
            }
            else {
                pastDay -= 1;
            }
            
            // System.out.println(pastYear + " " + tempMonth + " " + pastDay);

            if (todayYear > pastYear){
                answer.add(i+1);
            }
            else {
                if (todayYear == pastYear && todayMonth > tempMonth){
                    answer.add(i+1);
                }
                else{
                    if (todayYear == pastYear && todayMonth == tempMonth && todayDay > pastDay){
                        answer.add(i+1);
                    }
                }
            }
        }
        
        // for (int i = 0; i < answer.size(); i++){
        //     System.out.println(answer.get(i));
        // }
        return answer;
    }
}