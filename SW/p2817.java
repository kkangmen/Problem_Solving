import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2817 {

    static int[] arr;
    static boolean[] isUsed;
    static int answer = 0;
    static int N;
    static int K;

    public static int calculate(){
        int sum = 0;
        for (int i = 0; i < N; i++){
            if(isUsed[i]){
                sum += arr[i];
            }
        }
        return sum;
    }

    public static void bTracking(int idx){
        if (idx == N){
            int sum = calculate();
            if (sum == K){
                answer+=1;
            }
            return;
        }

        isUsed[idx] = true;
        bTracking(idx+1);

        isUsed[idx] = false;
        bTracking(idx+1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            answer = 0;
            // N, K 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // N 크기 배열 생성 및 대입
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 백트래킹
            isUsed = new boolean[N];

            bTracking(0);

            System.out.println("#" + test_case + " " + answer);
        }
    }
}

// 1 1 2 2