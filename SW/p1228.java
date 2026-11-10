import java.io.*;
import java.util.StringTokenizer;

public class p1228 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {

            // N (원본 암호문 길이) 입력
            int N = Integer.parseInt(br.readLine());
            // 10 크기 배열 생성, 원본 암호문 값 삽입
            int[] arr = new int[10];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            // T (명령어 개수) 입력
            int T = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            // T만큼 반복하여
            for (int i = 0; i < T; i++) {
                // I 추출
                String command = st.nextToken();
                // x의 위치
                int startIdx = Integer.parseInt(st.nextToken());
                // y개
                int Y = Integer.parseInt(st.nextToken());
                // Y만큼 nextToken하고
                int[] number = new int[Y];
                for (int j = 0; j < Y; j++){
                    number[j] = Integer.parseInt(st.nextToken());
                }
                // 만약 시작 위치가 10보다 크면 의미 없다.
                if (startIdx >= 10){
                    continue;
                }

                // 새로운 크기 10 배열을 생성하여
                int idx = 0;
                int arrIdx = 0;
                int numIdx = 0;
                int[] answer = new int[10];
                while (idx < 10){
                    if (startIdx <= idx && idx < startIdx+Y){
//                        System.out.println("number에서 추출: " + numIdx);
                        answer[idx] = number[numIdx++];
                    } else {
                        answer[idx] = arr[arrIdx++];
                    }
                    idx++;
                }

                arr = answer;
                // 출력
//                for (int j = 0; j < 10; j++){
//                    System.out.print(answer[j] + " ");
//                }
//                System.out.println();
            }

            System.out.print("#" + test_case + " ");
            for (int i = 0; i < 10; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}