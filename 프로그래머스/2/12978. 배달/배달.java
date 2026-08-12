import java.util.*;

class Solution {
    
    class Node {
        int dest;
        int cost;
        Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }
    
    Map<Integer, List<Node>> graph = new HashMap<>();
    int[] distance;
    Queue<Node> pq = new PriorityQueue<>((n1, n2) -> {
        return n1.cost - n2.cost;
    });
    
    public void dijkstra(){
        while (!pq.isEmpty()){
            Node curNode = pq.poll();
            int curNodeNum = curNode.dest;
            
            for (int i = 0; i < graph.get(curNodeNum).size(); i++){
                Node nxtNode = graph.get(curNodeNum).get(i);
                
                if (distance[nxtNode.dest] > distance[curNodeNum] + nxtNode.cost){
                    distance[nxtNode.dest] = distance[curNodeNum] + nxtNode.cost;
                    pq.offer(nxtNode);
                }
            }
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        // 초기화
        for (int i = 0; i <= N; i++){
            graph.put(i, new LinkedList<>());
        }

        for (int[] row : road){
            graph.get(row[0]).add(new Node(row[1], row[2]));
            graph.get(row[1]).add(new Node(row[0], row[2]));
        }
        
        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        // 다익스트라 시작
        distance[1] = 0;
        pq.offer(new Node(1, 0));
        
        dijkstra();
        
        for (int i = 1; i <= N; i++){
            if (distance[i] <= K){
                answer++;
            }
        }
        return answer;
    }
}