import java.io.*;
import java.util.StringTokenizer;

public class p1210 {

    static int[][] map;

    static int goUp(int x, int y){
        // 만약 행이 0이 되면 그때의 y좌표를 반환한다.
        if (x == 0){
            return y;
        }
        // 왼쪽에 1, 다리가 존재하면 이동 (1이 나오면 지속)
        if (y > 0 && map[x][y-1] == 1){
            while (0 < y && map[x][y-1] == 1){
                y--;
            }
        }
        // 오른쪽에 1, 다리가 존재하면 이동
        else if (y < 99 && map[x][y+1] == 1){
            while (y < 99 && map[x][y+1] == 1){
                y++;
            }
        }
        // 계속 위로 이동한다.
        return goUp(x-1, y);
    }

    public static void main(String[] args) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {

            int tc = Integer.parseInt(br.readLine());
            int answer = 0;
            // 100*100 배열을 생성하고 값 입력
            map = new int[100][100];
            for (int i = 0; i < 100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 맨 아래 행에서 2가 나오면 위로 올라간다.
            for (int j = 0; j < 100; j++){
                if (map[99][j] == 2){
                    answer = goUp(99, j);
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}