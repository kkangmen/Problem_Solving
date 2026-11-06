import java.io.*;

public class p2805 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            int answer = 0;
            // N 입력, N*N 배열 생성
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];

            // 배열에 값 넣기
            for (int i = 0; i < N; i++){
                String line = br.readLine();
                for (int j = 0; j < N; j++){
                    map[i][j] = line.charAt(j)-'0';
                }
            }

            int mid = N/2; // 3
            // 1 -> 3 -> 5
            for (int row = 0; row < N; row++){
                // 중심으로부터 떨어진 거리
                int dist = Math.abs(mid-row);
                for (int col = dist; col < N-dist; col++){
                    answer += map[row][col];
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}