import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] place;
        place = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long answer = N;
        for (int i = 0; i < N; i++){
            place[i] -= B;
            if (place[i] < 0){
                place[i] = 0;
            }
        }

        for (int i = 0; i < N; i++){
            if (place[i] != 0){
                answer += ((place[i]-1)/C)+1;
            }
        }

        System.out.println(answer);
        // print
//        for (int i = 0; i < N; i++){
//            System.out.print(place[i] + " ");
//        }
    }
}
