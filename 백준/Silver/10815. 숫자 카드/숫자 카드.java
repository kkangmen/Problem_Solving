import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] card;
        card = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(card);

        int M = Integer.parseInt(br.readLine());
        int[] check;
        check = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < M; i++){
            int left = 0;
            int right = N-1;
            int num = check[i];
            boolean hasValue = false;

            // 이분 탐색
            while (left <= right){
                int mid = (left+right)/2;
                if (num < card[mid]){
                    right = mid - 1;
                }
                else if (num > card[mid]){
                    left = mid + 1;
                }
                else {
                    hasValue = true;
                    break;
                }
            }

            if (hasValue){
                System.out.print(1 + " ");
            }
            else {
                System.out.print(0 + " ");
            }
        }
    }
}
