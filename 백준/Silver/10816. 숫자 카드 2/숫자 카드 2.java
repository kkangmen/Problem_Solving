import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. HashMap 준비
        Map<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        // 2. StringTokenizer로 입력받아 Map에 바로 저장 (정렬 필요 없음)
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cardNum = Integer.parseInt(st.nextToken());
            map.put(cardNum, map.getOrDefault(cardNum, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int checkNum = Integer.parseInt(st.nextToken());
            // 3. Map에서 O(1)으로 바로 개수 조회
            sb.append(map.getOrDefault(checkNum, 0)).append(" ");
        }

        System.out.println(sb.toString());
    }
}