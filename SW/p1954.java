import java.io.*;

public class p1954 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            // N 입력받고, 배열 NxN 배열 만들기
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];

            // num=1부터 시작.
            int num = 0;
            // top=0, bottom=N, left=0, right=N
            int top = 0, bottom = N-1, left = 0, right = N-1;

            // left <= right이고 top <= bottom라면 계속 진행
            while (left <= right && top <= bottom) {
                // arr[top][] left ~ right까지 num넣고 +=1, top--
                for (int i = left; i <= right; i++){
                    arr[top][i] = ++num;
                }
                top++; // top=1

                // arr[][right] top~bottom까지 num넣고 +=1, right--
                for (int i = top; i <= bottom; i++){
                    arr[i][right] = ++num;
                }
                right--; // right=1

                // left > right면 중단
                // arr[bottom][] right~left까지 num넣고 +=1, bottom++
                if (top <= bottom){
                    for (int i = right; i >= left; i--){
                        arr[bottom][i] = ++num;
                    }
                    bottom--; // bottom=1
                }

                // top > bottom이면 중단
                // arr[][left] bottom~top까지 num넣고 += 1, left++
                if (left <= right){
                    for (int i = bottom; i >= top; i--){
                        arr[i][left] = ++num;
                    }
                    left++; // left = 1
                }
            }

            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}