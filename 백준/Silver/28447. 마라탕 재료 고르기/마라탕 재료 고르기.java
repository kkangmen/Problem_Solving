import java.util.*;
import java.io.*;

public class Main {
    static int N, K, res = Integer.MIN_VALUE;
    static boolean[] visited;
    static int[][] C;

    public static void combination(int idx, int depth){
        if (depth == K){
            res = Math.max(res, sumCombination(0, 0, new int[2]));
            return;
        }

        for (int i = idx; i < N; i++){
            if (!visited[i]){
                visited[i] = true;
                combination(i+1, depth+1);
                visited[i] = false;
            }
        }
    }

    public static int sumCombination(int idx, int depth, int[] select){
        if (depth == 2){
            return C[select[0]][select[1]];
        }

        int sum = 0;
        for (int i = idx; i < N; i++){
            if(visited[i]){
                select[depth] = i;
                sum += sumCombination(i+1, depth+1, select);
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        C = new int[N][N];
        for (int i = 0; i < N; i++){
            C[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        if (K == 1){
            res = 0;
        }
        else {
            visited = new boolean[N];
            combination(0, 0);
        }

        System.out.println(res);
    }
}
