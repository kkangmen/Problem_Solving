import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1249 {

    static int N;
    static int[][] graph;
    static int[][] distance;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        distance[0][0] = 0;

        while (!q.isEmpty()){
            int[] curNode = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = curNode[0] + dx[i];
                int ny = curNode[1] + dy[i];

                if (0 <= nx && nx < graph.length && 0 <= ny && ny < graph[0].length){
                    // 다익스트라
                    // 현재 좌표 + 다음 좌표의 값이
                    if (distance[curNode[0]][curNode[1]] + graph[nx][ny] < distance[nx][ny]){
                        distance[nx][ny] = distance[curNode[0]][curNode[1]] + graph[nx][ny];
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            // N 입력 및 graph, distance 배열 생성
            N = Integer.parseInt(br.readLine());
            graph = new int[N][N];
            distance = new int[N][N];

            for (int i = 0; i < N; i++){
                String line = br.readLine();
                for (int j = 0; j < N; j++){
                    graph[i][j] = line.charAt(j)-'0';
                }
            }

            for (int i = 0; i < N; i++){
                Arrays.fill(distance[i], Integer.MAX_VALUE);
            }
            // (0,0)부터 시작해서 bfs 시작
            bfs();

            // (n,n) 좌표 distance 값이 정답
            int answer = distance[N-1][N-1];

            System.out.println("#" + test_case + " " + answer);
        }
    }
}