import java.util.*;

class Solution {
    
    class Node {
        int startNode;
        int endNode;
        int cost;
        Node (int startNode, int endNode, int cost){
            this.startNode = startNode;
            this.endNode = endNode;
            this.cost = cost;
        }
    }
    
    // 수정 2: static 제거 (테스트 케이스 간 간섭 방지)
    PriorityQueue<Node> pq = new PriorityQueue<>((Node o1, Node o2) -> {
        return Integer.compare(o1.cost, o2.cost);
    });
    
    // 수정 2: static 제거
    int[] parent;
    
    public int findParent(int nodeNum){
        if (parent[nodeNum] == nodeNum){
            return nodeNum;
        }
        // 수정 3: 경로 압축(Path Compression) 적용
        return parent[nodeNum] = findParent(parent[nodeNum]);
    }
    
    public boolean union(int node1, int node2){
        // 수정 1: 각 노드의 최상위 부모(root)를 먼저 찾습니다.
        int root1 = findParent(node1);
        int root2 = findParent(node2);
        
        // 부모가 같다면 이미 연결된 상태
        if (root1 == root2){
            return true;
        }
        
        // 수정 1: 노드 자신이 아닌, '루트 노드'끼리 연결합니다.
        if (root1 < root2){
            parent[root2] = root1;
        } else {
            parent[root1] = root2;
        }
        return false;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // 만약을 대비해 pq 초기화 (인스턴스 변수라도 확실히 비워주는 것이 좋습니다)
        pq.clear();
        
        // 부모 노드 초기화
        parent = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        // pq에 값 넣기
        for (int[] nodeInfo : costs){
            pq.offer(new Node(nodeInfo[0], nodeInfo[1], nodeInfo[2]));
        }
        
        while (!pq.isEmpty()){
            Node info = pq.poll();
            
            // 부모 노드가 다르면 간선 추가
            if (!union(info.startNode, info.endNode)){
                answer += info.cost;
            }
        }
        
        return answer;
    }
}