import java.util.*;

class Solution {
    
    class Node {
        int dest;
        int cost;
        Node (int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }
    
    Map<Integer, List<Node>> graph = new HashMap<>();
    int[] distance;
    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
        return o1.cost - o2.cost;
    });
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        // 초기화
        distance = new int[N+1];
        for (int i = 0; i <= N; i++){
            graph.put(i, new ArrayList<>());
        }
        for (int[] i : road){
            graph.get(i[0]).add(new Node(i[1], i[2]));
            graph.get(i[1]).add(new Node(i[0], i[2]));
        }
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        // 다익스트라 시작
        distance[1] = 0;
        pq.offer(new Node(1, 0));
        
        while (!pq.isEmpty()){
            Node curNode = pq.poll();
            
            for (int i = 0; i < graph.get(curNode.dest).size(); i++){
                Node nxtNode = graph.get(curNode.dest).get(i);
                
                if (distance[nxtNode.dest] > distance[curNode.dest] + nxtNode.cost){
                    distance[nxtNode.dest] = distance[curNode.dest] + nxtNode.cost;
                    pq.offer(new Node(nxtNode.dest, distance[nxtNode.dest]));
                }
            }
        }
        
        for (int i = 1; i <= N; i++){
            if (distance[i] <= K){
                answer++;
            }
        }
        return answer;
    }
}