import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			// N 입력, N*N 배열 생성
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			
			int top = 0; int bottom = N-1; 
			int left = 0; int right = N-1;
			int num = 1;
			// top <= bottom이고 left <= right라면 계속
			while (top <= bottom && left <= right) {
				// map[top][left -> right]까지 num++하면서 저장
				// top+=1;
				for (int col = left; col <= right; col++) {
					map[top][col] = num++;
				}
				top+=1;
				// map[top->bottom][right]까지 num++하면 저장
				// right-=1;
				for (int row = top; row <= bottom; row++) {
					map[row][right] = num++;
				}
				right-=1;
				// 만약 left <= right라면 실행
				// map[bottom][right->left]까지 num++저장
				// bottom-=1;
				if (left <= right) {
					for (int col = right; col >= left; col--) {
						map[bottom][col] = num++;
					}
					bottom-=1;
				}
				// 만약 top <= bottom라면 실행
				// map[bottom->top][left]까지 num++저장
				// left+=1;
				if (top <= bottom) {
					for (int row = bottom; row >= top; row--) {
						map[row][left] = num++;
					}
					left+=1;
				}
			}
			
			// 출력
			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}