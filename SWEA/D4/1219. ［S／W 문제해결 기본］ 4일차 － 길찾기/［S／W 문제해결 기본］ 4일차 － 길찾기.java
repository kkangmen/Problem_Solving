import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int[] info1;
    static int[] info2;

    public static boolean bfs(){
        // 큐 선언하고, 배열1,2의 인덱스 0의 값을 넣음
        Queue<Integer> q = new LinkedList<>();
        q.offer(info1[0]); q.offer(info2[0]);

        // 큐가 빌때까지
        while (!q.isEmpty()) {
            // 추출하고
            int node = q.poll();

            // 만약 99라면 true 반환
            if (node == 99) {
                return true;
            }

            // 다음 정점들을 넣는다.
            if (info1[node] != -1) {
                q.offer(info1[node]);
            }
            if (info2[node] != -1) {
                q.offer(info2[node]);
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {

            // tc 번호와 길의 총 개수 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tc = Integer.parseInt(st.nextToken());
            int edges = Integer.parseInt(st.nextToken());

            // size[100] 배열 2개 선언, 값 넣기
            info1 = new int[100];
            info2 = new int[100];
            Arrays.fill(info1, -1); Arrays.fill(info2, -1);
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < edges; i++){
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                if (info1[start] == -1){
                    info1[start] = end;
                } else {
                    info2[start] = end;
                }
            }

            // bfs 시작
            if (bfs()){
                System.out.println("#" + test_case + " " + 1);
            } else {
                System.out.println("#" + test_case + " " + 0);
            }
        }
    }
}