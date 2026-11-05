import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static HashMap<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] isVisited;
    static int answer = 0;

    private static void dfs(int node){
        isVisited[node] = true;

        for (int i = 0; i < graph.get(node).size(); i++){
            Integer nNode = graph.get(node).get(i);
            if(!isVisited[nNode]){
                dfs(nNode);
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
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

        for (int i = 1; i <= N; i++){
            if (!isVisited[i]){
                answer++;
                dfs(i);
            }
        }
        System.out.println(answer);
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}