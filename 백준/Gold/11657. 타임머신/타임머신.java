import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int start;
        int end;
        int cost;
        Node (int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static long[] distance;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node> list = new LinkedList<>();
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Node(a, b, c));
        }

        distance = new long[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        for (int i = 0; i < N-1; i++){
            for (Node n : list){
                if (distance[n.start] != Integer.MAX_VALUE && distance[n.end] > distance[n.start] + n.cost){
                    distance[n.end] = distance[n.start] + n.cost;
                }
            }
        }

        for (Node n : list){
            if (distance[n.start] != Integer.MAX_VALUE && distance[n.end] > distance[n.start] + n.cost){
                bw.write(-1 + "\n");
                bw.flush();
                bw.close();
                br.close();
                return;
            }
        }

        for (int i = 2; i < N+1; i++){
            if (distance[i] == Integer.MAX_VALUE){
                bw.write(-1 + "\n");
            }
            else {
                bw.write(distance[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}