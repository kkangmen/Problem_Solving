#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int n;
vector<int> graph[1000001];
bool isvisited[1000001];
int dp[1000001][2];
// 0 = 얼리어탑터 1 = 일반인

void dfs(int x)
{
    // cout << "x: " << x << '\n';
    isvisited[x] = true;
    dp[x][0] = 1;
    for (int i = 0; i < graph[x].size(); i++)
    {
        int y = graph[x][i];
        if (isvisited[y] == true)
        {
            continue;
        }
        dfs(y);
        dp[x][0] += min(dp[y][0], dp[y][1]);
        dp[x][1] += dp[y][0];
        // cout << "val: " << dp[x][0] << ' ' << dp[x][1] << '\n';
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for (int i = 0; i < n - 1; i++)
    {
        int u, v;
        cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    dfs(1);

    cout << min(dp[1][0], dp[1][1]) << '\n';
    return 0;
}
