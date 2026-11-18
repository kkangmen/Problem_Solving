import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static int[] arr1 = new int[9];
    static int[] arr2 = new int[9];
    static boolean[] isUsed = new boolean[9];
    static int win;
    static int lose;

    public static void bTracking(int idx, int gyuSum, int inSum){
        // 만약 idx가 9가 된다면
        if (idx == 9) {
            // 비교
            if (gyuSum > inSum){
                win++;
            }else if (gyuSum < inSum){
                lose++;
            }
            return;
        }

        for (int i = 0; i < 9; i++){
            if (!isUsed[i]){
                isUsed[i] = true;
                // 만약 규영이 카드가 크면 듀 커두애 적힌 수의 합 +
                if (arr1[idx] > arr2[i]){
                    bTracking(idx+1, gyuSum+arr1[idx]+arr2[i], inSum);
                } else if (arr1[idx] < arr2[i]){
                    bTracking(idx+1, gyuSum, inSum+arr1[idx]+arr2[i]);
                }
                isUsed[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            boolean[] hasCard = new boolean[19];
            win = 0; lose = 0;
            // 아홉 개의 정수를 배열에 담는다.
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++){
                arr1[i] = Integer.parseInt(st.nextToken());
                hasCard[arr1[i]] = true;
            }
            // 1부터 18까지 위 배열에 없는 수를 담는다.
            int idx = 0;
            for (int i = 1; i <= 18; i++){
                if (!hasCard[i]){
                    arr2[idx++] = i;
                }
            }

            // 백트래킹 시작
            bTracking(0, 0, 0);

            System.out.println("#" + test_case + " " + win + " " + lose);
        }
    }
}