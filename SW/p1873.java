import java.io.*;
import java.util.StringTokenizer;

public class p1873 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0}; // 순서대로 R, D, L, U
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            // 전차 출발 위치와 방향
            int x = 0; int y = 0; int dir = 0;

            // H = 높이, W = 너비 입력 및 H*W 크기 격자판 생성
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            // H개 줄에 길이가 W인 문자열 입력 (각 W는 격자판에 입력) + 전차 위치 특정
            char[][] map = new char[H][W];
            for (int i = 0; i < H; i++){
                String line = br.readLine();
                for (int j = 0; j < W; j++){
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '<'){
                        x = i; y = j; dir = 2;
                        map[i][j] = '.'; // 평지로 변환
                    } else if (map[i][j] == '^') {
                        x = i; y = j; dir = 3;
                        map[i][j] = '.';
                    } else if (map[i][j] == '>') {
                        x = i; y = j; dir = 0;
                        map[i][j] = '.';
                    } else if (map[i][j] == 'v') {
                        x = i; y = j; dir = 1;
                        map[i][j] = '.';
                    }
                }
            }

            // 사용자 입력 N
            int N = Integer.parseInt(br.readLine());
            String commands = br.readLine();
            // 각 명령어를 순회하면서
            for (char command : commands.toCharArray()) {
//                System.out.println("command: " + command);
                // 명령어가 U라면 방향을 위쪽으로 바꾸고, x-=1로 이동 (평지라면)
                if (command == 'U') {
                    dir = 3;
                    if (x - 1 >= 0 && map[x - 1][y] == '.') {
                        x-=1;
                    }
                }
                // 명령어가 D라면 방향 아래쪽, 아래로 이동 (평지라면)
                else if (command == 'D') {
                    dir = 1;
                    if (x + 1 < H && map[x + 1][y] == '.') {
                        x+=1;
                    }
                }
                // 명령어가 L 방향 왼쪽, 왼쪽 이동 (평지라면)
                else if (command == 'L') {
                    dir = 2;
                    if (y - 1 >= 0 && map[x][y - 1] == '.') {
                        y-=1;
                    }
                }
                // 명령어 R 방향 오른쪽, 오른쪽 이동 (평지라면)
                else if (command == 'R') {
                    dir = 0;
                    if (y + 1 < W && map[x][y + 1] == '.') {
                        y+=1;
                    }
                }
                // 명령어 S라면 포탄 발사
                else {
                    int bomb_x = x;
                    int bomb_y = y;
                    // 전차가 바라보는 방향으로 포탄 발사 (맵이 끝날때까지)
                    while (0 <= bomb_x+dx[dir] && bomb_x+dx[dir] < H
                            && 0 <= bomb_y+dy[dir] && bomb_y+dy[dir] < W) {
                        bomb_x += dx[dir];
                        bomb_y += dy[dir];
                        // 만약 '*'라면 '.'로 바꾼다. break;
                        if (map[bomb_x][bomb_y] == '*'){
                            map[bomb_x][bomb_y] = '.';
                            break;
                        }
                        if (map[bomb_x][bomb_y] == '#'){
                            break;
                        }
                    }
                }

//                for (int i = 0; i < H; i++){
//                    for (int j = 0; j < W; j++){
//                        if (i == x && j == y){
//                            if (dir == 0){
//                                System.out.print('>');
//                            } else if (dir == 1){
//                                System.out.print('v');
//                            } else if (dir == 2){
//                                System.out.print('<');
//                            } else {
//                                System.out.print('^');
//                            }
//                        }else {
//                            System.out.print(map[i][j]);
//                        }
//                    }
//                    System.out.println();
//                }
            }

            System.out.print("#" + test_case + " ");
            for (int i = 0; i < H; i++){
                for (int j = 0; j < W; j++){
                    if (i == x && j == y){
                        if (dir == 0){
                            System.out.print('>');
                        } else if (dir == 1){
                            System.out.print('v');
                        } else if (dir == 2){
                            System.out.print('<');
                        } else {
                            System.out.print('^');
                        }
                    }else {
                        System.out.print(map[i][j]);
                    }
                }
                System.out.println();
            }
        }
    }
}