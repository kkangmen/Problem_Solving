#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int n;
vector<int> graph[10001];
int time[10001];
int indegree[10001];
int dp[10001];

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

    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        cin >> time[i] >> indegree[i];
        dp[i] = time[i];
        for (int j = 0; j < indegree[i]; j++)
        {
            int preTask;
            cin >> preTask;
            graph[preTask].push_back(i);
        }
    }
    topoSort();

    cout << *max_element(dp + 1, dp + n + 1) << '\n';
    // for (int i = 1; i <= n; i++)
    // {
    //     cout << dp[i] << ' ';
    // }
    return 0;
}
