import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int onesCount = 0;

        if ((a+b) <= N){
            onesCount = a+b;
        }
        else {
            onesCount = 2*N - (a+b);
        }

        // onesCount개의 1을 사용해 만들 수 있는 N자리 이진수 중 가장 큰 수 만들기
        int answer = 0;
        for (int i = 0; i < onesCount; i++){
            answer += (1 << (N-1-i));
        }
        System.out.println(answer);
    }
}
