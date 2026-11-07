import java.io.*;
import java.util.StringTokenizer;

public class p1206 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {

            int answer = 0;
            // N 입력, 배열 생성
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            // 배열 값 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 2부터 ~ N-2까지
            for (int i = 2; i < N-2; i++) {
                int curHeight = arr[i];
                // 앞 두 건물의 높이 최댓값 구하기
                int frontHeight = Math.max(arr[i - 1], arr[i - 2]);
                // 뒤 두 건물의 높이 최댓값 구하기
                int backHeight = Math.max(arr[i + 1], arr[i + 2]);
                // 앞, 뒤 건물 최댓값 구하기
                int totalHeight = Math.max(frontHeight, backHeight);
                // answer+=현재 건물 높이 - 주변 건물 높이 최댓값 -> 0이상만 더함
                if (curHeight - totalHeight > 0) {
                    answer += curHeight - totalHeight;
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}