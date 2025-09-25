import java.io.*;
import java.util.*;

public class Main {
    public static class Score{
        int text;
        int interview;
        Score(int text, int interview){
            this.text = text;
            this.interview = interview;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            List<Score> list = new ArrayList<>();

            for (int j = 0; j < N; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.add(new Score(a, b));
            }

            Collections.sort(list, (a, b)->{
                return Integer.compare(a.text, b.text);
            });

            int pivot = list.get(0).interview;
            int answer = 1;
            for (int j = 1; j < list.size(); j++){
                if (list.get(j).interview < pivot){
                    pivot = list.get(j).interview;
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}