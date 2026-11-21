import java.util.*;
import java.io.*;

class Solution {
	static int[] arr;
	static int N;
	static int K;
	static int answer;
	public static void bTracking(int idx, int sum) {
		// idx가 N이 되면 중단
		if (idx == N) {
			// 그떄의 합이 K라면 answer++
			if (sum == K) {
				answer++;
			}
			// return
			return;
		}
		// 현재 idx를 포함
		bTracking(idx+1, sum + arr[idx]);
		bTracking(idx+1, sum);
	}
	public static void main(String[] args) throws Exception {
		// T 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		// tc동안 반복
		for (int test_case = 1; test_case <= T; test_case++) {
			answer = 0;
			// N과 K 입력, N 크기 배열 생성 및 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			// 백트래킹 
			bTracking(0, 0);
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}