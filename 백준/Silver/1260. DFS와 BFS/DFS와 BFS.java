import java.util.*;
import java.io.*;

public class Main {
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] isVisited;
    static Queue<Integer> q = new LinkedList<>();

    public static void dfs(int start){
        isVisited[start] = true;
        System.out.print(start + " ");

        for (int i = 0; i < graph.get(start).size(); i++){
            int x = graph.get(start).get(i);
            if (!isVisited[x]){
                dfs(x);
            }
        }
    }

    public static void bfs(int start){
        q.offer(start);
        isVisited[start] = true;
        System.out.print(start + " ");

        while (!q.isEmpty()){
            int x = q.poll();
            for (int i = 0; i < graph.get(x).size(); i++){
                int y = graph.get(x).get(i);
                if(!isVisited[y]){
                    q.offer(y);
                    System.out.print(y + " ");
                    isVisited[y] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

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
            Collections.sort(graph.get(i));
        }

        dfs(V);
        isVisited = new boolean[N+1];
        System.out.println();
        bfs(V);
    }
}
