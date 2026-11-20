import java.util.*;
import java.io.*;

class Solution {
	
	static int N;
	static int M;
	static int[][] map;
	static int[][] time;
	static int[][] tunnel = {
			{},
			{0, 1, 2, 3}, // 상, 하, 좌, 우
			{0, 1},
			{2, 3},
			{0, 3},
			{1, 3},
			{1, 2},
			{0, 2}
	};
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[] opposite = {1, 0, 3, 2};
	public static void bfs(int x, int y) {
		// 큐 선언, 시작접 삽입, time=1;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		time[x][y] = 1;
		// 큐가 빌때까지
		while (!q.isEmpty()) {
			// 큐 poll
			int[] curNode = q.poll();
			int kind = map[curNode[0]][curNode[1]];
			for (int i = 0; i < tunnel[kind].length; i++) {
				// 해당 지점과 연결이 되고, time이 0이면 방문 및 노드 추가
				// 해당 지점과 연결이 되는지 확인하는 방법은 현재 노드가 갈 수 있는 방향
				// 다음 노드에서 갈 수 있는 방향이 반대가 되어 일치할 때 가능
				int d = tunnel[kind][i]; // 방향
				int nx = curNode[0] + dx[d];
				int ny = curNode[1] + dy[d];
				if (0 <= nx && nx < N && 0 <= ny && ny < M
						&& time[nx][ny] == 0) {
					int nxtDir = map[nx][ny]; // 다음 노드의 터널 모양
					for (int j = 0; j < tunnel[nxtDir].length; j++) {
						if (opposite[d] == tunnel[nxtDir][j]) {
							q.offer(new int[] {nx, ny});
							time[nx][ny] = time[curNode[0]][curNode[1]] + 1;
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		// 1 -> 상하좌우/ 2 -> 상하 / 3 -> 좌우 / 4 -> 상우 / 5 -> 하우 / 6 -> 하좌 / 7 -> 상좌
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// tc 입력
		int T = Integer.parseInt(br.readLine());
		// tc동안
		for (int test_case = 1; test_case <= T; test_case++) {
			// M, N, R, C, L 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			// M*N 행렬 생성, M만큼 반복하여 배열 값 입력
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// time[][] 생성
			time = new int[N][M];
			// 시작점 (C,R)에서 BFS 시작 (거리는 1)
			bfs(R, C);
			
			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (time[i][j] > 0 && time[i][j] <= L) {
						answer++;
					}
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}
}