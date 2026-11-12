import java.io.*;
import java.util.StringTokenizer;

public class p5215 {

    static int N;
    static int L;
    static int[] score;
    static int[] calory;
    static int answer = 0;

    public static void bTracking(int idx, int calories, int scores){
        if (calories > L){
            return;
        }

        if (idx == N){
            // 제한 칼로리보다 낮으면 점수 최신화
            answer = Math.max(answer, scores);
            return;
        }

        bTracking(idx+1, calories, scores);
        bTracking(idx+1, calories+calory[idx], scores+score[idx]);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T  = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            answer = 0;
            // N, L 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            // N 크기의 점수 배열과 N 크기의 칼로리 배열 선언 및 입력
            score = new int[N];
            calory = new int[N];
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                calory[i] = Integer.parseInt(st.nextToken());
            }

            // 백트래킹
            bTracking(0, 0, 0);

            System.out.println("#" + test_case + " " + answer);
        }
    }
}