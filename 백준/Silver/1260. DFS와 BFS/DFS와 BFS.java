import java.io.*;
import java.util.*;
    
public class Main {
    static int N, M, V;
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] isVisited;
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int start){
        isVisited[start] = true;
        sb.append(start).append(" ");

        for (int i = 0; i < graph.get(start).size(); i++){
            int node = graph.get(start).get(i);
            if (!isVisited[node]){
                dfs(node);
            }
        }
    }

    public static void bfs(int start){
        isVisited[start] = true;
        q.offer(start);

        while (!q.isEmpty()){
            int node = q.poll();
            sb.append(node).append(" ");

            for (int i = 0; i < graph.get(node).size(); i++){
                int newNode = graph.get(node).get(i);
                if (!isVisited[newNode]){
                    isVisited[newNode] = true;
                    q.offer(newNode);
                }
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        isVisited = new boolean[N+1];
        for (int i = 0; i <= N; i++){
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (List<Integer> list : graph.values()){
            Collections.sort(list);
        }

        dfs(V);
        sb.append("\n");
        Arrays.fill(isVisited, false);
        bfs(V);
        System.out.println(sb.toString());
        br.close();
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}