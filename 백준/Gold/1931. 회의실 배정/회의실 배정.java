import java.util.*;
import java.io.*;

public class Main {
    static List<Pair> list = new ArrayList<>();

    public static class Pair {
        int start;
        int end;
        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new Pair(a,b));
        }

        Collections.sort(list, (a, b) -> {
            if (a.end == b.end){
                return Integer.compare(a.start, b.start);
            }
            else {
                return Integer.compare(a.end, b.end);
            }
        });

        int endTime = list.get(0).end;
        int answer = 1;
        for (int i = 1; i < list.size(); i++){
            Pair p = list.get(i);
            if (endTime <= p.start){
                answer++;
                endTime = p.end;
            }
        }
        System.out.println(answer);
    }
}
