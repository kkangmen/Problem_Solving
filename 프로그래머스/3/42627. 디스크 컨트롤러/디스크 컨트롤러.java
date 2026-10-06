import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        int completed = 0;
        int curtime = 0;
        int totalTime = 0;
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        
        int jobsIdx = 0;
        
        while (completed < jobs.length){
            
            // curtime보다 작은 시작시간 push
            while (jobsIdx < jobs.length && curtime >= jobs[jobsIdx][0]){
                pq.offer(new int[]{jobs[jobsIdx][0], jobs[jobsIdx][1]});
                jobsIdx++;
            }
            
            // 만약 pq가 비어있다면 curtime을 다음 job의 시작시간으로
            if (pq.isEmpty()){
                curtime = jobs[jobsIdx][0];
                continue;
            }
            
            // pq 우선순위 pop
            int[] job = pq.poll();
            // System.out.println("popped = " + job[0] + " " + job[1]);
            
            // 시간의 흐름
            curtime += job[1];
            
            // System.out.println("curtime = " + curtime + " startime = " + job[0]);
            totalTime += curtime-job[0];
            completed++;
        }
        
        return totalTime/jobs.length;
    }
}