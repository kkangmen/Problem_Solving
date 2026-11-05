import java.util.*;

class Solution {
    
    Set<String> carSet = new HashSet<>();
    List<String> carList = new ArrayList<>();
    
    public int calculateTime(String time){
        int hour = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]);
        
        return hour*60 + min;
    }
    
    public List<Integer> solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        
        // Set에 집어넣기
        for (String s : records){
            String[] info = s.split(" ");
            carSet.add(info[1]);
        }
        
        // 차량 번호 오름차순으로 정렬
        for (String s : carSet){
            carList.add(s);
        }
        Collections.sort(carList);
        
        for (int i = 0; i < carList.size(); i++){
            int totalTime = 0;
            int startTime = 0;
            boolean maxFlag = false;
            
            for (String s : records){
                String[] info = s.split(" ");
                String time = info[0];
                String carNum = info[1];
                String inOrOut = info[2];
                
                if (carNum.equals(carList.get(i)) && inOrOut.equals("IN")){
                    startTime = calculateTime(time);
                    maxFlag = true;
                    continue;
                }
                
                if (carNum.equals(carList.get(i)) && inOrOut.equals("OUT")){
                    totalTime += calculateTime(time) - startTime;
                    maxFlag = false;
                }
            }
            
            if (maxFlag){
                totalTime += (23*60 + 59) - startTime;
            }
            // System.out.println("carNum: " + carList.get(i) + " totalTime: " + totalTime);
            
            
            // System.out.println(((int)Math.ceil((totalTime-fees[0])/(double)fees[2])));
            // 주차 요금 계산
            // 기본 시간 초과
            if (totalTime > fees[0]){
                answer.add(fees[1] + (int)Math.ceil((totalTime - fees[0])/(double)fees[2])*fees[3]);
            } else {
                answer.add(fees[1]);
            }
        }
        return answer;
    }
}