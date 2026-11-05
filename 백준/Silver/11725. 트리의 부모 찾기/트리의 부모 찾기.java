import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static HashMap<Integer, List<Integer>> map = new HashMap<>();
    static int[] parentList;
    static boolean[] isVisited;
    static Queue<Integer> q = new LinkedList<>();

    public static void bfs(int start){
        q.offer(start);
        isVisited[start] = true;

        while(!q.isEmpty()){
            Integer node = q.poll();
            for (int i = 0; i < map.get(node).size(); i++){
                Integer newNode = map.get(node).get(i);
                if (!isVisited[newNode]){
                    q.offer(newNode);
                    isVisited[newNode] = true;
                    parentList[newNode] = node;
                }
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parentList = new int[N+1];
        isVisited = new boolean[N+1];

        for (int i = 1; i <= N; i++){
            map.put(i, new LinkedList<>());
        }

        for (int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
            map.get(b).add(a);
        }

        bfs(1);

        for (int i = 2; i <= N; i++){
            System.out.println(parentList[i]);
        }
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}