import java.util.*;

class Solution {
    
    Queue<Integer> endTime = new LinkedList<>();
    
    public int solution(int[] players, int m, int k) {
        int cumulServerCnt = 0;
        int curServerCnt = 0;
        for (int i = 0; i < players.length; i++){
            // System.out.println("i = " + i);
            // 서버 시간이 다되었다면
            while (!endTime.isEmpty() && endTime.peek() == i){
                endTime.poll();
                curServerCnt -= 1;
            }
            
            // 서버가 더 필요할 경우
            int needServerCnt = players[i]/m;
            if (needServerCnt > curServerCnt){
                // 증설 횟수만큼 서버 추가
                int plusServer = (needServerCnt - curServerCnt);
                for (int count = 0; count < plusServer; count++){
                    endTime.offer(i+k);
                }
                
                // 우선 누적 증설횟수 더해줌.
                cumulServerCnt += plusServer;
                
                curServerCnt = needServerCnt;
            }
            // System.out.println("증설된 서버의 수 = "+  curServerCnt);
            // System.out.println("증설 횟수 = "+ cumulServerCnt);
        }
        
        return cumulServerCnt;
    }
}