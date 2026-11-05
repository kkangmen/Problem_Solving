import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static String[][] map;
    static int answer = Integer.MIN_VALUE;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static boolean checkDuplicate(String str, String letter){
        if (str.contains(letter)){
            return false;
        }
        return true;
    }

    public static void dfs(int x, int y, String str){
        answer = Math.max(answer, str.length());

        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < R && 0 <= ny && ny < C){
                if (checkDuplicate(str, map[nx][ny])){
                    dfs(nx, ny, str + map[nx][ny]);
                }
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new String[R][C];

        for (int i = 0; i < R; i++){
            String row = br.readLine();

            for (int j = 0; j < C; j++){
                map[i][j] = String.valueOf(row.charAt(j));
            }
        }

        dfs(0, 0, map[0][0]);
        System.out.println(answer);
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}