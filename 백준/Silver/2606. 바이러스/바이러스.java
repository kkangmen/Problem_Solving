import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] isVisited;
    static int answer = 0;

    public static void bfs(int start){
        isVisited[start] = true;
        q.offer(start);

        while(!q.isEmpty()){
            Integer node = q.poll();
            for (int i = 0; i < graph.get(node).size(); i++){
                Integer newNode = graph.get(node).get(i);
                if (!isVisited[newNode]){
                    isVisited[newNode]=true;
                    q.offer(newNode);
                    answer++;
                }
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++){
            graph.put(i, new LinkedList<>());
        }

        isVisited = new boolean[N+1];
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(1);
        System.out.println(answer);
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}