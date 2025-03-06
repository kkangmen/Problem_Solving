#include <iostream>
#include <string>
#include <vector>
#include <queue>
using namespace std;

int n, m;
vector<int> graph[100001];
bool isvisited[100001];

void bfs(int start)
{
    queue<int> q;
    q.push(start);
    isvisited[start] = true;
    while (!q.empty())
    {
        start = q.front();
        q.pop();
        for (int i = 0; i < graph[start].size(); i++)
        {
            int x = graph[start][i];
            if (isvisited[x] == false)
            {
                q.push(x);
                isvisited[x] = true;
            }
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
        int u, v;
        cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    int cnt = 0;
    for (int i = 1; i <= n; i++)
    {
        if (isvisited[i] == false)
        {
            cnt++;
            bfs(i);
        }
    }

    // 연산의 총 횟수 = 추가해야 하는 간선 수 + 제거해야하는 간선 수
    // 추가해야 하는 간선 수 = cnt - 1
    // 제거해야 하는 간선 수 = m + (cnt - 1) - (n - 1)
    cout << (cnt - 1) + (m + (cnt - 1) - (n - 1)) << '\n';
    return 0;
}