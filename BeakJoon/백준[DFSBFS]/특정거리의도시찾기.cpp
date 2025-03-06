#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int n, m, k, x;
vector<int> graph[300001];
bool isvisited[300001];
int val[300001];
vector<int> ans;

void bfs(int x)
{
    queue<int> q;
    q.push(x);
    isvisited[x] = true;
    while (!q.empty())
    {
        x = q.front();
        q.pop();
        for (int i = 0; i < graph[x].size(); i++)
        {
            int y = graph[x][i];
            if (isvisited[y] == false)
            {
                isvisited[y] = true;
                q.push(y);
                val[y] = val[x] + 1;
            }
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m >> k >> x;
    for (int i = 0; i < m; i++)
    {
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
    }

    bfs(x);

    for (int i = 1; i <= n; i++)
    {
        if (val[i] == k)
        {
            ans.push_back(i);
        }
    }

    sort(ans.begin(), ans.end());

    if (ans.size() == 0)
    {
        cout << -1 << '\n';
        return 0;
    }
    for (int i = 0; i < ans.size(); i++)
    {
        cout << ans[i] << '\n';
    }
    return 0;
}