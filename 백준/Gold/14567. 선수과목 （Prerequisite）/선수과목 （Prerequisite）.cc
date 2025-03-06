#include <iostream>
#include <cstring>
#include <vector>
#include <queue>
using namespace std;

int n, m;
vector<int> graph[1001];
int indegree[1001];
int ans[1001];

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
            ans[y] = ans[x] + 1;
        }
    }
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m;
    for (int i = 0; i < m; i++)
    {
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
        indegree[b]++;
    }

    memset(ans, 0, sizeof(ans));
    topoSort();

    for (int i = 1; i <= n; i++)
    {
        cout << ans[i] + 1 << ' ';
        // cout << indegree[i] << ' ';
    }
    return 0;
}