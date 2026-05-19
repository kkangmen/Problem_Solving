import java.util.*;

class Solution {
    
    Queue<Integer> serverTTL = new LinkedList<>();
    
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int curServerCnt = 0;
        for (int i = 0; i < players.length; i++){
            // System.out.println("i: " + i);
            
            // 서버 만료 시간이 도달하였을 경우 제거.
            while (!serverTTL.isEmpty() && serverTTL.peek() == i){
                // System.out.println("서버 만료");
                curServerCnt -= 1;
                serverTTL.poll();
            }
            
            int needServerCnt = players[i]/m;
            // 필요 서버 수가 현재 서버 수보다 많을 경우
            if (curServerCnt < needServerCnt){
                answer += needServerCnt - curServerCnt;
                
                // 증설된 서버 수 만큼 서버 만료 시간 큐에 삽입
                for (int count = 0; count < needServerCnt-curServerCnt; count++){
                    serverTTL.offer(i+k);
                }
                
                curServerCnt += needServerCnt - curServerCnt;
                
                
            }
            // System.out.println("증설된 서버의 수: " + curServerCnt);
            // System.out.println("증설 횟수: " + answer);            
        }
        return answer;
    }
}