import java.io.*;
import java.util.StringTokenizer;

public class p3499 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            // N 입력, N 크기의 배열 생성
            int N = Integer.parseInt(br.readLine());
            String[] arr = new String[N];
            String[] answer = new String[N];
            // 배열에 문자 넣기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++){
                arr[i] = st.nextToken();
            }

            // 배열 크기가 짝수라면
            if (N % 2 == 0) {
                for (int i = 0; i < N/2; i++) {
                    // i를 넣고
                    answer[i*2] = arr[i];
                    // i+n/2를 넣는다.
                    answer[i*2+1] = arr[i + N / 2];
                }
            }

            // 배열 크기가 홀수라면
            else {
                for (int i = 0; i < N/2; i++){
                    answer[i*2] = arr[i];
                    answer[i*2+1] = arr[i+N/2+1];
                }
                answer[N-1] = arr[N/2];
            }

            System.out.print("#" + test_case + " ");
            for (int i = 0; i < N; i++){
                System.out.print(answer[i] + " ");
            }
            System.out.println();
        }
    }
}