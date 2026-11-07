import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class p1859 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            long answer = 0;
            // N 입력, N 크기의 배열 생성
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            // 배열 값 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 파는 날의 값 = arr[end]
            int sell = arr[N-1];
            // 배열 뒤에서 부터 탐색한다.
            for (int i = N-2; i >= 0; i--) {
                int curPrice = arr[i];

                // 해당 날이 파는 날의 값보다 작다면
                if (curPrice < sell) {
                    // answer += 파는 날의 값 - 해당 날의 값
                    answer += (sell - curPrice);
                }
                // 아니라면 -> 파는 날의 값 갱신
                else {
                    sell = curPrice;
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}