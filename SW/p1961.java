import java.io.*;
import java.util.StringTokenizer;

public class p1961 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            // N 입력받고 N*N 행렬 생성
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];

            // 값을 입력 받아 행렬 채우기
            for (int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 정답 배열 N*3 생성
            String[][] answer = new String[N][3];
            StringBuilder sb = new StringBuilder();
            // answer[][0]은 90도, answer[][1]은 180도, answer[][2]는 270도
            // ansCol = 0 ~ 3까지 반복
            for (int ansCol = 0; ansCol < 3; ansCol++) {
                // ansCol==0이라면
                if (ansCol == 0) {
                    // col = 0 ~ N까지
                    for (int col = 0; col < N; col++) {
                        // row = N부터 0까지 모든 수를 더해서
                        for (int row = N - 1; row >= 0; row--) {
                            sb.append(arr[row][col]);
                        }
                        // answer[col][ansCol]에 넣기
                        answer[col][ansCol] = sb.toString();
                        sb.setLength(0);
                    }
                }
                // ansCol==1이라면 180도
                else if (ansCol == 1) {
                    // row = N ~ 0까지
                    for (int row = N - 1; row >= 0; row--) {
                        // col = N부터 0까지 모든 수를 더해서
                        for (int col = N - 1; col >= 0; col--) {
                            sb.append(arr[row][col]);
                        }
                        // answer[N-row][ansCol]에 넣기
                        answer[N - row - 1][ansCol] = sb.toString();
                        sb.setLength(0);
                    }
                }
                // ansCol==2라면 270도
                else {
                    // col = N ~ 0까지
                    for (int col = N - 1; col >= 0; col--) {
                        // row는 0부터 N까지 모든 수를 더해서
                        for (int row = 0; row < N; row++) {
                            sb.append(arr[row][col]);
                        }
                        // answer[N-col][ansCol]에 넣기
                        answer[N - col - 1][ansCol] = sb.toString();
                        sb.setLength(0);
                    }
                }
            }
            System.out.println("#" + test_case + " ");
            for (int i = 0; i < N; i++){
                for (int j = 0; j < 3; j++){
                    System.out.print(answer[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}