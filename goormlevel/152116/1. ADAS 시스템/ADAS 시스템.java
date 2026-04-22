import java.io.*;
import java.util.*;

class Main {
    static int w, h;
    static String[][] map;
    static boolean[][] isVisited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int dangerScore = 0;
    static PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> {
        if (o1.priority == o2.priority){
            if (o1.x == o2.x){
                return Integer.compare(o1.y, o2.y);
            }
            return Integer.compare(o1.x, o2.x);
        }
        return Integer.compare(o1.priority, o2.priority);
    });

    public static class Point {
        int x;
        int y;
        int priority;
        Point (int x, int y, int priority){
            this.x = x;
            this.y = y;
            this.priority = priority;
        }
    }

    public static int countDangerPlace(Point p){
        int[] rotateX = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] rotateY = {0, 1, 1, 1, 0, -1, -1, -1};
        int pCount = 0;

        for (int i = 0; i < 8; i++){
            int newRotateX = p.x + rotateX[i];
            int newRotateY = p.y + rotateY[i];

//            System.out.println("Check Rotate");
//            System.out.println("newRotateX = " + newRotateX + " newRotateY = " + newRotateY);

            if (0 <= newRotateX && newRotateX < w && 0 <= newRotateY && newRotateY < h) {
                if (map[newRotateX][newRotateY].equals("P")) {
//                    System.out.println("P found");
                    pCount += 1;
                }
            }
        }

        if (p.priority == 1){
            return pCount - 3;
        }
        return pCount;
    }

    public static void bfs(Point start){
        isVisited[start.x][start.y] = true;
        pq.offer(new Point(start.x, start.y, 0));

        while(!pq.isEmpty()){
            Point p = pq.poll();
//            System.out.println("location x = " + p.x + " y = " + p.y);
            // 위험 점수 계산
            if (p.priority != 0){
                dangerScore += countDangerPlace(p);
//                System.out.println("dangerScore = " + dangerScore);
            }

            // 종료 조건
            if (map[p.x][p.y].equals("E")){
								if (dangerScore < 0){
									dangerScore = 0;
								}
                System.out.println(dangerScore);
                return;
            }

            for (int i = 0; i < 4; i++){
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;

                if (0 <= nx && nx < w && 0 <= ny && ny < h){
                    if(!isVisited[nx][ny]){
                        if(map[nx][ny].equals("0")){
                            pq.offer(new Point(nx, ny, 2));
                        }
                        else if(map[nx][ny].equals("P")){
                            pq.offer(new Point(nx, ny, 1));
                        }
                        else{
                            pq.offer(new Point(nx, ny, 0));
                        }
                        isVisited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Point start = null;
        String[] input = br.readLine().split(" ");
        w = Integer.parseInt(input[0]);
        h = Integer.parseInt(input[1]);

        map = new String[w][h];
        isVisited = new boolean[w][h];

        for (int i = 0; i < w; i++){
            String row = br.readLine();
            for (int j = 0; j < h; j++){
                map[i][j] = String.valueOf(row.charAt(j));
                if (map[i][j].equals("S")){
                    start = new Point(i, j, 0);
                }
            }
        }

        bfs(start);
    }
}
