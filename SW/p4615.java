import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p4615 {

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            // N과 M 입력, N*N 배열 생성
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N];

            // 배열 초기 배치
            map[N/2-1][N/2-1] = map[N/2][N/2] = 2;
            map[N/2][N/2-1] = map[N/2-1][N/2] = 1;

            // M번 동안
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken()) - 1;
                int x = Integer.parseInt(st.nextToken()) - 1;
                int color = Integer.parseInt(st.nextToken());

                // 해당 위치에 돌을 놓고
                map[x][y] = color;
                // 8방향을 탐색
                for (int j = 0; j < 8; j++) {
                    int nx = x;
                    int ny = y;

                    List<int[]> changeList = new ArrayList<>();
                    // 해당 위치에서 맵 밖으로 나갈때까지
                    while (0 <= nx + dx[j] && nx + dx[j] < N
                            && 0 <= ny + dy[j] && ny + dy[j] < N) {
                        nx += dx[j];
                        ny += dy[j];
                        if (map[nx][ny] == 0){
                            break;
                        }
                        // 만약 같은 돌이 나오면 중단,
                        // 지나온 위치를 전부 해당 색의 돌로 변경
                        if (map[nx][ny] == color) {
                            for (int[] node : changeList) {
                                map[node[0]][node[1]] = color;
                            }
                            break;
                        }

                        // 계속 이동하면서 자신과 다른 색의 돌이면 리스트에 추가
                        if (map[nx][ny] != color && map[nx][ny] != 0) {
                            changeList.add(new int[]{nx, ny});
                        }
                    }

                }
//                // 맵 출력
//                System.out.println("m: " + m);
//                for (int i = 0; i < N; i++){
//                    for (int j = 0; j < N; j++){
//                        System.out.print(map[i][j] + " ");
//                    }
//                    System.out.println();
//                }
            }

            int[] answerCnt = new int[2];
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    if (map[i][j] == 1){
                        answerCnt[0]+=1;
                    }else if (map[i][j] == 2) {
                        answerCnt[1]+=1;
                    }
                }
            }
            System.out.println("#" + test_case + " " + answerCnt[0] + " " + answerCnt[1]);
        }
    }
}