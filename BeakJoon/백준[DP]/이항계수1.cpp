#include <iostream>

using namespace std;

int dp[11][11];

int main(){
	int n, k;
	cin >> n >> k;

	for (int i = 1; i <= n; i++){
		for (int j = 0; j <= i; j++){
			if (j == 0 || i == j){
				dp[i][j] = 1;
			}
			else {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
	}

	cout << dp[n][k] << '\n';
	return 0;
}