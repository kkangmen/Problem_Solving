import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class p1859 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            // N과 배열 입력 받기
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int maxPrice = 0;
            long answer = 0;
            for (int i = N-1; i >= 0; i--){
                if (maxPrice < arr[i]){
                    maxPrice = arr[i];
                }else{
                    answer += maxPrice-arr[i];
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}