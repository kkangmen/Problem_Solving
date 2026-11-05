import java.util.*;
import java.io.*;

public class Main {
    static int n, m, r;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] isVisited ;
    static int[] visitedOrderArray;
    static int visitedOrder = 1;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<Integer> queue = new LinkedList<>();

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        isVisited = new boolean[n+1];
        visitedOrderArray = new int[n+1];

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
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        bfs(r);
        br.close();
    }

    public static void bfs(int start) throws IOException {
        isVisited[start] = true;
        queue.add(start);
        visitedOrderArray[start] = visitedOrder;
        visitedOrder++;

        while (!queue.isEmpty()){
            int x = queue.poll();
            for (int i = 0; i < graph.get(x).size(); i++){
                int y = graph.get(x).get(i);
                if (!isVisited[y]){
                    isVisited[y] = true;
                    queue.add(y);
                    visitedOrderArray[y] = visitedOrder;
                    visitedOrder++;
                }
            }
        }
    }
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