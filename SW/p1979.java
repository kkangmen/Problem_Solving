import java.io.*;
import java.util.StringTokenizer;

public class p1979 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            int answer = 0;
            // N과 K 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // N*N 배열 선언하고 값 채우기
            int[][] puzzle = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++){
                    puzzle[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 먼저 각 행마다 탐색
            for (int row = 0; row < N; row++) {
                int length = 0;
                // 1일 등장하면 그때부터 0이 나올때까지의 길이를 구한다.
                for (int col = 0; col < N; col++){
                    if (puzzle[row][col]==1){
                        length++;
                    }
                    else {
                        if (length == K){
                            answer++;
                        }
                        length = 0;
                    }
                }
                if (length == K){
                    answer++;
                }
            }
            // 그 다음 각 열마다 탐색
            for (int col = 0; col < N; col++) {
                int length = 0;
                // 1일 등장하면 그때부터 0이 나올때까지의 길이를 구한다.
                for (int row = 0; row < N; row++){
                    if (puzzle[row][col]==1){
                        length++;
                    }
                    else {
                        if (length == K){
                            answer++;
                        }
                        length = 0;
                    }
                }
                if (length == K){
                    answer++;
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}