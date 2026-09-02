import java.util.*;

class Solution {
    
    int[] parent;
    
    public int findParent(int node){
        if (parent[node] == node){
            return node;
        }    
        return findParent(parent[node]);
    }
    
    public void union(int a, int b){
        int parent1 = findParent(a);
        int parent2 = findParent(b);
        
        parent[parent2] = parent1;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
            
        for (int[] cost : costs){
            // 부모가 다르면 간선 추가 후 통합
            if (findParent(cost[0]) != findParent(cost[1])){
                answer += cost[2];
                union(cost[0], cost[1]);
            }
        }
        
        return answer;
    }
}