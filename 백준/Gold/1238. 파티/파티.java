import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int idx;
        int cost;
        Node (int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }

    static HashMap<Integer, List<Node>> graph1 = new HashMap<>();
    static HashMap<Integer, List<Node>> graph2 = new HashMap<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
    static int[] distance1;
    static int[] distance2;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++){
            graph1.put(i, new ArrayList<>());
            graph2.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph1.get(x).add(new Node(y, cost));
            graph2.get(y).add(new Node(x, cost));
        }

        //init
        distance1 = new int[N+1];
        Arrays.fill(distance1, Integer.MAX_VALUE);
        distance1[X] = 0;
        pq.offer(new Node(X, 0));

        // djikstra
        while (!pq.isEmpty()){
            Node curNode = pq.poll();

            for (int i = 0; i < graph1.get(curNode.idx).size(); i++){
                Node nxtNode = graph1.get(curNode.idx).get(i);

                if (distance1[nxtNode.idx] > curNode.cost + nxtNode.cost){
                    distance1[nxtNode.idx] = curNode.cost + nxtNode.cost;
                    pq.offer(new Node(nxtNode.idx, distance1[nxtNode.idx]));
                }
            }
        }

        distance2 = new int[N+1];
        Arrays.fill(distance2, Integer.MAX_VALUE);
        distance2[X] = 0;
        pq.offer(new Node(X, 0));
        while (!pq.isEmpty()){
            Node curNode = pq.poll();

            for (int i = 0; i < graph2.get(curNode.idx).size(); i++){
                Node nxtNode = graph2.get(curNode.idx).get(i);

                if (distance2[nxtNode.idx] > curNode.cost + nxtNode.cost){
                    distance2[nxtNode.idx] = curNode.cost + nxtNode.cost;
                    pq.offer(new Node(nxtNode.idx, distance2[nxtNode.idx]));
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++){
            if (distance1[i] + distance2[i] > answer){
                answer = distance1[i] + distance2[i];
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}