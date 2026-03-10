import java.io.*;
import java.util.*;
    
public class Main {
    static int N, M;
    static int[][] map;
    static int[][] copyMap;
    static int[] direction;
    static List<CCTV> cctvList = new ArrayList<>();
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int answer = Integer.MAX_VALUE;

    public static class CCTV {
        private int num;
        private int x;
        private int y;

        public CCTV (int num, int x, int y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    public static void watch(CCTV cctv, int d){
        Queue<CCTV> q = new LinkedList<>();

        q.add(cctv);

        while(!q.isEmpty()){
            int nx = q.peek().x + dx[d];
            int ny = q.poll().y + dy[d];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M || copyMap[nx][ny] == 6){
                break;
            }

            if (copyMap[nx][ny] == 0){
                copyMap[nx][ny] = -1;
            }
            q.add(new CCTV(cctv.num, nx, ny));
        }
    }

    public static void decideDirection(){
        for (int i = 0; i < direction.length; i++){
            CCTV cctv = cctvList.get(i);

            if (cctv.num == 1){
                // 상으로만
                if (direction[i] == 0){
                    watch(cctv, 0);
                }
                // 우로만
                if (direction[i] == 1){
                    watch(cctv, 1);
                }
                // 하로만
                if (direction[i] == 2){
                    watch(cctv, 2);
                }
                // 좌로만
                if (direction[i] == 3){
                    watch(cctv, 3);
                }
            }
            if (cctv.num == 2){
                // 상하
                if (direction[i] == 0 || direction[i] == 2){
                    watch(cctv, 0);
                    watch(cctv, 2);
                }
                // 좌우
                else {
                    watch(cctv, 1);
                    watch(cctv, 3);
                }
            }
            if (cctv.num == 3){
                // 상우
                if (direction[i] == 0){
                    watch(cctv, 0);
                    watch(cctv, 1);
                }
                // 우하
                if (direction[i] == 1){
                    watch(cctv, 1);
                    watch(cctv, 2);
                }
                // 하좌
                if (direction[i] == 2){
                    watch(cctv, 2);
                    watch(cctv, 3);
                }
                // 좌상
                if (direction[i] == 3){
                    watch(cctv, 3);
                    watch(cctv, 0);
                }
            }
            if (cctv.num == 4){
                // 상우하
                if (direction[i] == 0){
                    watch(cctv, 0);
                    watch(cctv, 1);
                    watch(cctv, 2);
                }
                // 우하좌
                if (direction[i] == 1){
                    watch(cctv, 1);
                    watch(cctv, 2);
                    watch(cctv, 3);
                }
                // 하좌상
                if (direction[i] == 2){
                    watch(cctv, 2);
                    watch(cctv, 3);
                    watch(cctv, 0);
                }
                // 좌상우
                if (direction[i] == 3){
                    watch(cctv, 3);
                    watch(cctv, 0);
                    watch(cctv, 1);
                }
            }
            if (cctv.num == 5){
                watch(cctv, 0);
                watch(cctv, 1);
                watch(cctv, 2);
                watch(cctv, 3);
            }
        }
    }

    public static void getBlindSpot(){
        int cnt = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0;j < M; j++){
                if (copyMap[i][j] == 0){
                    cnt++;
                }
            }
        }
        answer = Math.min(answer, cnt);
    }

    public static void bTracking(int count){
        if (count == cctvList.size()){
            copyMap = new int[N][M];
            for (int i = 0; i < map.length; i++){
                System.arraycopy(map[i], 0, copyMap[i], 0, map[i].length);
            }
            // 존재하는 CCTV들의 상,하,좌,우가 정해진 상태
            decideDirection();
            getBlindSpot();
            return;
        }

        for (int i = 0; i < 4; i++){
            direction[count] = i; // 상,하,좌,우
            bTracking(count + 1);
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6){
                    cctvList.add(new CCTV(map[i][j], i, j));
                }
            }
        }

        direction = new int[cctvList.size()];
        bTracking(0);

        System.out.println(answer);
        br.close();
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}