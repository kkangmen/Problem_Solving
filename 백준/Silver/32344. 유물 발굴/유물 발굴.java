import java.util.*;
import java.io.*;

public class Main {
    public static class Point {
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        Map<Integer, List<Point>> map = new HashMap<>();
        Map<Integer, Long> sumMap = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (!map.containsKey(a)){
                map.put(a, new LinkedList<>());
            }
            map.get(a).add(new Point(b, c));
        }

        for (int i : map.keySet()){
            List<Integer> listX = new LinkedList<>();
            List<Integer> listY = new LinkedList<>();

            for (int j = 0; j < map.get(i).size(); j++){
                Point p = map.get(i).get(j);
                listX.add(p.x);
                listY.add(p.y);
            }

            Collections.sort(listX);
            Collections.sort(listY);

            if (listX.size() == 1 && listY.size() == 1){
                sumMap.put(i, 1L);
            }
            else {
                long size = (long)(listX.get(listX.size() - 1) - listX.get(0) + 1) * (listY.get(listY.size() - 1) - listY.get(0) + 1);
                sumMap.put(i, size);
            }
        }

        long max = 0;
        int idx = 0;
        for (int i : sumMap.keySet()){
            if (sumMap.get(i) > max){
                idx = i;
                max = sumMap.get(i);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(idx + " " + max + "\n");
        bw.flush();
        bw.close();
    }
}
