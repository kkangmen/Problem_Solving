import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[] isUsed;
    static int[] cityOrder;
    static int answer = Integer.MAX_VALUE;

    public static void caclutate(){
        int distance = 0;
        boolean flag = true;
        for (int i = 0; i < N; i++){

            if (i == N-1) {
                if (map[cityOrder[i]][cityOrder[0]] == 0){
                    flag = false;
                }
                distance += map[cityOrder[i]][cityOrder[0]];
            }
            else {
                if (map[cityOrder[i]][cityOrder[i+1]] == 0){
                    flag = false;
                }
                distance += map[cityOrder[i]][cityOrder[i+1]];
            }
        }
//        if (flag) System.out.println(distance);
        if (flag) answer = Math.min(answer, distance);
    }

    public static void bruteForce(int count){
        if (count == N){
//            for (int i : cityOrder){
//                System.out.print(i + " ");
//            }
//            System.out.println();
            caclutate();
            return;
        }

        for (int i = 0; i < N; i++){
            if (!isUsed[i]){
                isUsed[i] = true;
                cityOrder[count] = i;
                bruteForce(count+1);
                isUsed[i] = false;
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        isUsed = new boolean[N];
        cityOrder = new int[N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bruteForce(0);
        System.out.println(answer);
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}