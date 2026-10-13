import java.util.*;

class Solution {
    
    Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
        if (o1[1] == o2[1]){
            return o1[0] - o2[0];
        }
        return o1[1] - o2[1];
    });
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        
        int curTime = 0;
        int latency = 0;
        int jobIdx = 0;
        int completed = 0;
        
        while (completed < jobs.length){
            
            // jobs중에 curTime 이하를 pq에 삽입
            while (jobIdx < jobs.length && jobs[jobIdx][0] <= curTime){
                pq.offer(jobs[jobIdx]);
                jobIdx++;
            }
            
            // 만약 pq가 비었다면 curTIme 뒤로 미룸
            if (pq.isEmpty()){
                curTime = jobs[jobIdx][0];
                continue;
            }
            
            // 일 처리
            int[] job = pq.poll();
            curTime += job[1];
            latency += curTime - job[0];
            completed++;
            // System.out.println(latency);
            
        }
        
        return latency/jobs.length;
    }
}