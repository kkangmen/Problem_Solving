import java.io.*;
import java.util.*;
    
public class Main {
    static int N;
    static int[] number;
    static int[] operator = new int[4];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void bruteForce(int count, int sum){
        if (count == N-1){
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        if (operator[0] > 0){
            operator[0]--;
            bruteForce(count+1, sum + number[count+1]);
            operator[0]++;
        }
        if (operator[1] > 0){
            operator[1]--;
            bruteForce(count+1, sum - number[count+1]);
            operator[1]++;
        }
        if (operator[2] > 0){
            operator[2]--;
            bruteForce(count+1, sum * number[count+1]);
            operator[2]++;
        }
        if (operator[3] > 0){
            operator[3]--;
            if (sum < 0){
                bruteForce(count+1, -(Math.abs(sum) / number[count+1]));
            }
            else {
                bruteForce(count+1, sum / number[count+1]);
            }
            operator[3]++;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        number = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        bruteForce(0, number[0]);
        System.out.println(max + "\n" + min);
        br.close();
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}