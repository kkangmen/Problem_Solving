import java.io.*;
import java.util.*;

public class Main {

    public static class Node{
        int idx;
        int cost;
        Node (int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }

    static HashMap<Integer, List<Node>> graph = new HashMap<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
    static int[] distance;

    public static void solution() throws IOException {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();
        int start = sc.nextInt();

        for (int i = 0; i <= V; i++){
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph.get(u).add(new Node(v, w));
        }

        // init
        distance = new int[V+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.offer(new Node(start, 0));

        // djikstra
        while (!pq.isEmpty()){
            Node curNode = pq.poll();

            for (int i = 0; i < graph.get(curNode.idx).size(); i++){
                Node nxtNode = graph.get(curNode.idx).get(i);

                if (distance[nxtNode.idx] > curNode.cost + nxtNode.cost){
                    distance[nxtNode.idx] = curNode.cost + nxtNode.cost;
                    pq.offer(new Node(nxtNode.idx, distance[nxtNode.idx]));
                }
            }
        }

        // print
        for (int i = 1; i <= V; i++){
            if (distance[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }
            else {
                System.out.println(distance[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}