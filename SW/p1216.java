import java.io.*;

public class p1216 {
    static char[][] map = new char[100][100];

    // 행 r의 [s, s+len) 구간이 회문인지
    static boolean rowPal(int r, int s, int len) {
        for (int i = 0; i < len / 2; i++)
            if (map[r][s + i] != map[r][s + len - 1 - i]) return false;
        return true;
    }

    // 열 c의 [s, s+len) 구간이 회문인지
    static boolean colPal(int c, int s, int len) {
        for (int i = 0; i < len / 2; i++)
            if (map[s + i][c] != map[s + len - 1 - i][c]) return false;
        return true;
    }

    static boolean exists(int len) {
        for (int a = 0; a < 100; a++)
            for (int s = 0; s <= 100 - len; s++)
                if (rowPal(a, s, len) || colPal(a, s, len)) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        for (int test_case = 1; test_case <= 10; test_case++) {
            int tc = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < 100; i++) {
                String line = br.readLine();
                for (int j = 0; j < 100; j++) map[i][j] = line.charAt(j);
            }

            int answer = 1;
            for (int len = 100; len >= 1; len--) {
                if (exists(len)) { answer = len; break; }
            }
            out.append('#').append(tc).append(' ').append(answer).append('\n');
        }
        System.out.print(out);
    }
}