import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            int cardNum = Integer.parseInt(st.nextToken());
            map.put(cardNum, map.getOrDefault(cardNum, 0) + 1);
        }
        
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++){
            int checkNum = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(checkNum, 0)).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}