import java.io.*;
import java.util.StringTokenizer;

public class p2001 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            // N, M 입력, N*N 배열 생성
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];

            // N*N 배열 입력받기
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 누적합 배열 값 넣기
            int[][] sumMap = new int[N+1][N+1];
            // 1부터 N+1까지
            for (int i = 1; i < N+1; i++) {
                // 1부터 N+1까지
                for (int j = 1; j < N+1; j++) {
                    // [1,1]이면 arr[0][0]
                    if (i == 1 && j == 1) {
                        sumMap[i][j] = arr[0][0];
                    }
                    // sumMap[i][j] = sumMap[i-1][j] + sumMap[i][j-1] - sumMap[i-1][j-1] + arr[i][j]
                    else {
                        sumMap[i][j] = sumMap[i - 1][j] + sumMap[i][j - 1] - sumMap[i - 1][j - 1] + arr[i-1][j-1];
                    }
                }
            }
//
//            for (int i = 0; i < N+1; i++){
//                for (int j = 0; j < N+1; j++){
//                    System.out.print(sumMap[i][j] + " ");
//                }
//                System.out.println();
//            }
//             M부터 N까지 (가로)
            int answer = 0;
            for (int i = M; i < N+1; i++) {
                // M부터 N까지 (세로)
                for (int j = M; j < N+1; j++) {
                    // answer = sumMap[i-M][j] + sumMap[i][j-M] - sumMap[i-M][j-M]
//                    System.out.println("i: " + i + " j: " + j + " -> " + answer);
                    answer = Math.max(answer, sumMap[i][j] - (sumMap[i - M][j] + sumMap[i][j - M]) + sumMap[i - M][j - M]);
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}
// 1 3 3 2
// 1 2 3 1
// 2 3 1 1
// 3 4 1 2

// 0  0  0  0  0
// 0  1  4  7  9
// 0  2  7  13 16
// 0  4 12  19 23
// 0  7