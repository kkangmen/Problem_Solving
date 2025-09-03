import java.io.*;
import java.util.*;

public class Main {
    static int[][] distance;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        distance = new int[n+1][n+1];
        // init
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                if (i == j){
                    distance[i][j] = 0;
                }
                else {
                    distance[i][j] = 10000000;
                }
            }
        }

        for (int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            distance[a][b] = Math.min(distance[a][b], c);
        }

        for (int k = 1; k <= n; k++){
            for (int i = 1; i <= n; i++){
                for (int j = 1; j <=n; j++){
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                if (distance[i][j] == 10000000){
                    bw.write(0 + " ");
                    continue;
                }
                bw.write(distance[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}