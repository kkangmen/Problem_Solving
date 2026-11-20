import java.util.*;
import java.io.*;

class Solution {
	static int N;
	static int X;
	static int[][] map;
	
	public static boolean check(int[] arr) {
		int n = arr.length;
		boolean[] isUsed = new boolean[n];
		
		// 0부터 n-1까지 순회하면서 
		for (int i = 0; i < n-1; i++) {
			// 이웃 높이 차를 계산한다.
			int diff = arr[i+1] - arr[i];
			
			// 평지라면 continue
			if (diff == 0) continue;
			// 높이 차가 2이상이라면 false
			if (Math.abs(diff) >= 2) return false;
			
			// diff가 -1이라면, 뒤쪽 x칸 만큼 같이 같고 아직 설치 전인지 확인한다.
			if (diff == -1) {
				if (i + X >= n) return false;
				for (int j = i+1; j <= i+X; j++) {
					if (arr[j] != arr[i+1] || isUsed[j]) return false;
					isUsed[j] = true;
				}
			}
			
			// diff가 +1이라면, 앞쪽 x칸 만큼 값이 같고 아직 설치 전인지 확인다.
			if (diff == +1) {
				if (i - X + 1 < 0) return false;
				for (int j = i; j >= i-X+1; j--) {
					if (arr[j] != arr[i] || isUsed[j]) return false;
					isUsed[j] = true;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		// t 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		// tc동안
		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			// N, X 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			// N*N 배열 생성  + 값 입력
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 행을 살핀다
			for (int i = 0; i < N; i++) {
				if (check(map[i])) answer++;
				
				int[] col = new int[N];
				for (int j = 0; j < N; j++) {
					col[j] = map[j][i];
				}
				if (check(col)) answer++;
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}