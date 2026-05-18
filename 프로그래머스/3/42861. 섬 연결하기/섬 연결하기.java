import java.util.*;

class Solution {
    
    class Node {
        int start;
        int end;
        int cost;
        Node (int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    
    int[] parent;
    PriorityQueue<Node> pq = new PriorityQueue<>((Node p1, Node p2) -> {
        return Integer.compare(p1.cost, p2.cost);
    });
    
    // union 합치기
    public void union(int mother, int baby){
        mother = findParent(mother);
        baby = findParent(baby);
        
        if (mother < baby){
            parent[baby] = mother;
        } else {
            parent[mother] = baby;
        }
    }
    
    // 부모 찾기
    public int findParent(int nodeNum){
        if (parent[nodeNum] == nodeNum){
            return nodeNum;
        }
        return findParent(parent[nodeNum]);
    }
    
    public int getMinimumCost(int answer){
        while(!pq.isEmpty()){
            Node node = pq.poll();
            
            // 부모가 다르면 간선 추가.
            if (findParent(node.start) != findParent(node.end)){
                answer += node.cost;
                union(node.start, node.end);
            }
        }
        return answer;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        for (int[] cost: costs){
            pq.add(new Node(cost[0], cost[1], cost[2]));
        }
        
        answer = getMinimumCost(answer);
        return answer;
    }
}