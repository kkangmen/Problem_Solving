import java.io.*;
import java.util.*;

public class Main {
    static int V, E, K;
    static int[] distance;
    static HashMap<Integer, List<Node>> graph = new HashMap<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) ->
            Integer.compare(o1.cost, o2.cost));
    private static class Node {
        int idx;
        int cost;
        Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void djikstra(int start){
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()){
            Node curNode = pq.poll(); // 1

            for (int i = 0; i < graph.get(curNode.idx).size(); i++){
                Node nxtNode = graph.get(curNode.idx).get(i); // 2, 3

                if (distance[nxtNode.idx] > distance[curNode.idx] + nxtNode.cost){
                    distance[nxtNode.idx] = distance[curNode.idx] + nxtNode.cost;
                    pq.offer(new Node(nxtNode.idx, distance[nxtNode.idx]));
                }
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        distance = new int[V+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i <= V; i++){
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }


        djikstra(K);

        for (int i = 1; i <= V; i++){
            if (distance[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }
            else{
                System.out.println(distance[i]);
            }
        }
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}