import java.util.*;

class Solution {
    
    int[] parent;
    
    public void merge(int node1, int node2){
        int a = findParent(node1);
        int b = findParent(node2);
        
        if (a < b){
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
    
    public int findParent(int node){
        if (parent[node] == node){
            return node;
        }
        return findParent(parent[node]);
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
            
        for (int[] cost : costs){
            
            // 부모가 다르면 간선 추가 및 부모 통일
            if (findParent(cost[0]) != findParent(cost[1])){
                answer += cost[2];
                merge(cost[0], cost[1]);
            }
        }
        return answer;
    }
}