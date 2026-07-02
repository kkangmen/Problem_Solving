import java.util.*;

class Solution {
    
    class Point {
        int idx;
        int cost;
        Point(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
    
    Map<Integer, List<Point>> graph = new HashMap();
    int[] distance;
    Queue<Point> pq = new PriorityQueue<>((o1, o2) -> {
        return o1.cost - o2.cost;
    });
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        // 초기화
        for (int i = 0; i <= N; i++){
            graph.put(i, new ArrayList<>());
        }
        distance = new int[N+1];
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int[] i : road){
            graph.get(i[0]).add(new Point(i[1], i[2]));
            graph.get(i[1]).add(new Point(i[0], i[2]));
        }
        
        // 다익스트라 시작
        distance[1] = 0;
        pq.offer(new Point(1, 0));
        
        while (!pq.isEmpty()){
            Point curP = pq.poll();
            for (int i = 0; i < graph.get(curP.idx).size(); i++){
                Point nxtP = graph.get(curP.idx).get(i);
                
                if (distance[nxtP.idx] > distance[curP.idx] + nxtP.cost){
                    distance[nxtP.idx] = distance[curP.idx] + nxtP.cost;
                    pq.offer(nxtP);
                }
            }
        }
        
        // 검증
        for (int i = 1; i < N+1; i++){
            if (distance[i] <= K){
                answer++;
            }
        }
        return answer;
    }
}