import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1208 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {

            // 덤프 횟수와 가로 길이 배열
            int D = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[100];
            for (int i = 0; i < 100; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 각 덤프 횟수 마다
            for (int i = 0; i < D; i++) {
                // 정렬
                Arrays.sort(arr);

                // 만약 가장 큰 - 가장 작은이 0또는 1이라면 break;
                if (arr[99] - arr[0] == 0 ||
                arr[99] - arr[0] == 1){
                    break;
                }

                // 가장 큰 거를 -1, 작은거를 +1
                arr[99] -= 1;
                arr[0] += 1;
            }

            Arrays.sort(arr);
            int answer = arr[99] - arr[0];
            System.out.println("#" + test_case + " " + answer);
        }
    }
}