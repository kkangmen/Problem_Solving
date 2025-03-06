#include <iostream>
#include <cstring>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int t, n, k;
int time[1001];
vector<int> graph[1001];
int indegree[1001];
int dp[1001];

void topoSort()
{
    queue<int> q;
    for (int i = 1; i <= n; i++)
    {
        if (indegree[i] == 0)
        {
            q.push(i);
        }
    }

    while (!q.empty())
    {
        int x = q.front();
        q.pop();
        for (int i = 0; i < graph[x].size(); i++)
        {
            int y = graph[x][i];
            indegree[y]--;
            if (indegree[y] == 0)
            {
                q.push(y);
            }
            dp[y] = max(dp[y], dp[x] + time[y]);
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> t;
    while (t--)
    {
        cin >> n >> k;

        // 초기화
        for (int i = 1; i <= n; i++)
        {
            graph[i].clear();
            indegree[i] = 0;
        }

        for (int i = 1; i <= n; i++)
        {
            cin >> time[i];
            dp[i] = time[i];
        }
        for (int i = 1; i <= k; i++)
        {
            int x, y;
            cin >> x >> y;
            graph[x].push_back(y);
            indegree[y]++;
        }

        topoSort();

        int w;
        cin >> w;
        cout << dp[w] << '\n';
        // for (int i = 1; i <= n; i++)
        // {
        //     cout << dp[i] << ' ';
        // }
    }
    return 0;
}