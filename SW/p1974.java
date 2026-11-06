import java.io.*;
import java.util.StringTokenizer;

public class p1974 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            int answer = 1;

            // 9*9 배열 선언
            int[][] puzzle = new int[9][9];

            // 배열에 값 채워 넣기
            for (int i = 0; i < 9; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++){
                    puzzle[i][j] = Integer.parseInt(st.nextToken());
                }
            }

//            for (int i = 0; i < 9; i++){
//                for (int j = 0; j < 9; j++){
//                    System.out.print(puzzle[i][j] + " ");
//                }
//                System.out.println();
//            }
            // isUsed 배열 선언
            boolean[] isUsed;

            // 각 행을 검증 (0~9)
            for (int row = 0; row < 9; row++) {
                // isUsed 배열 초기화
                isUsed = new boolean[10];
                for (int col = 0; col < 9; col++) {
                    // 만약 isUsed=true라면 answer=0
                    if (isUsed[puzzle[row][col]]) {
                        answer = 0;
                        break;
                    }
                    isUsed[puzzle[row][col]] = true;
                }
                if (answer == 0){
                    break;
                }
            }

            // 각 열을 검증 (0~9(
            for (int col = 0; col < 9; col++) {
                // isUsed 배열 초기화
                isUsed = new boolean[10];
                for (int row = 0; row < 9; row++) {
                    // 만약 isUsed=true라면 answer=0
                    if (isUsed[puzzle[row][col]]) {
                        answer = 0;
                        break;
                    }
                    isUsed[puzzle[row][col]] = true;
                }
                if (answer == 0){
                    break;
                }
            }

            // 각 칸을 검증 (i+=3)
            for (int row = 0; row < 9; row+=3) {
                // (j+=3)
                for (int col = 0; col < 9; col += 3) {
                    // isUsed 배열 초기화
                    isUsed = new boolean[10];
                    // isUsed[i][j] true라면
                    for (int i = row; i < row+3; i++){
                        for (int j = col; j < col+3; j++){
                            if (isUsed[puzzle[i][j]]){
                                answer = 0;
                                break;
                            }
                            isUsed[puzzle[i][j]] = true;
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}