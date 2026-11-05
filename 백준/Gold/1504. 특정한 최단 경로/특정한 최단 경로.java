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

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashMap<Integer, List<Node>> graph = new HashMap<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
    static int[] distance;
    static boolean possible = true;
    static List<Integer> answerList = new LinkedList<>();

    public static int djikstra(int start, int end){
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.offer(new Node(start, 0));

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

        if (distance[end] == Integer.MAX_VALUE){
            possible = false;
            return -1;
        }
        return distance[end];
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int answer = 0;
        distance = new int[E+1];

        for (int i = 0; i <= E; i++){
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < V; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        answer += djikstra(1, u);
        answer += djikstra(u, v);
        answer += djikstra(v, E);
        answerList.add(answer);

        answer = 0;
        answer += djikstra(1, v);
        answer += djikstra(v, u);
        answer += djikstra(u, E);
        answerList.add(answer);

        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
        if (possible){
            bw.write(Math.min(answerList.get(0), answerList.get(1)) + "\n");
        }
        else{
            bw.write(-1 + "\n");
        }
        bw.flush();
        bw.close();
    }
}