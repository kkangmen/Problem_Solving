import java.util.*;
import java.io.*;

public class Main {
    static int n, m, r;
    static List<List<Integer>> graph = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] isVisited;
    static int[] visitedOrderArray;
    static int visitedOrder;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        isVisited = new boolean[n+1];
        visitedOrderArray = new int[n+1];
        visitedOrder = 1;

        for (int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i <= n; i++){
            Collections.sort(graph.get(i));
        }

        bfs(r);
        br.close();
    }

    public static void bfs(int start){
        queue.offer(start);

        while (!queue.isEmpty()){
            int x = queue.poll();
            isVisited[x] = true;
            visitedOrderArray[x] = visitedOrder;
            visitedOrder++;

            for (int i = 0; i < graph.get(x).size(); i++){
                int y = graph.get(x).get(i);
                if (!isVisited[y]) {
                    queue.offer(y);
                    isVisited[y] = true;
                }
            }
        }
    }
//    public static void dfs(int start){
//        isVisited[start] = true;
//        visitedOrderArray[start] = visitedOrder;
//        visitedOrder++;
//
//        for (int i = 0; i <graph.get(start).size(); i++){
//            int y = graph.get(start).get(i);
//            if (!isVisited[y]){
//                dfs(y);
//            }
//        }
//    }

    public static void main(String[] args) throws IOException {
        solution();

        for (int i = 1; i <= n; i++){
            bw.write(String.valueOf(visitedOrderArray[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}