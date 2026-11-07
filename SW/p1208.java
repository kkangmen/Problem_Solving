import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1208 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {

            int answer = 0;
            // N (덤프횟수)
            // 100 크키 배열 생성, 값 입력, 배열 정렬
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[100];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            // 덤프 횟수마다
            for (int i = 0; i < N; i++) {

                // 만약 최고점과 최저점의 높이 차가 1 이하라면 중단
                if (arr[99] - arr[0] <= 1) {
                    break;
                }
                // 가장 큰 값 -=1, 가장 작은 값 += 1
                arr[99] -= 1;
                arr[0] += 1;

                // 정렬
                Arrays.sort(arr);
            }

            // 최고점과 최저점의 높이차가 정답
            answer = arr[99] - arr[0];
            System.out.println("#" + test_case + " " + answer);
        }
    }
}