import java.io.*;
import java.util.StringTokenizer;

public class p1210 {

    static int[][] graph;
    static boolean flag;

    public static int dfs(int row, int col){

        // 종료 조건 = 행이 0이면 해당 열 리턴
        if (row == 0){
            return col;
        }
        // 좌 우에 1이 있다면 이동
        if (col - 1 >= 0 && graph[row][col-1] == 1){
            while (col-1 >= 0 && graph[row][col-1] == 1){
                col--;
            }
        }
        else if (col + 1 < 100 && graph[row][col+1] == 1){
            while (col+1 < 100 && graph[row][col+1] == 1){
                col++;
            }
        }
        // 위로 이동ㅇ
        return dfs(row-1, col);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {

            // 테스트 케이스 번호 입력
            int num = Integer.parseInt(br.readLine());
            // 100x100 만큼 입력 받아 graph에 저장
            graph = new int[100][100];
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 마지막 행을 순회하면서
            int answer = 0;
            for (int col = 0; col < 100; col++) {
                // 만약 해당 값이 2라면 탐색 시작
                if (graph[99][col] == 2){
                    answer = dfs(99, col);
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}