#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int m, n, k;
int graph[100][100];
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};
vector<int> v;
void bfs(int x, int y)
{
    int cnt = 0;
    queue<pair<int, int>> q;
    graph[x][y] = 1;
    q.push(make_pair(x, y));
    while (!q.empty())
    {
        x = q.front().first;
        y = q.front().second;
        q.pop();
        cnt++;
        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < m && 0 <= ny && ny < n)
            {
                if (graph[nx][ny] == 0)
                {
                    graph[nx][ny] = 1;
                    q.push(make_pair(nx, ny));
                }
            }
        }
    }
    v.push_back(cnt);
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> m >> n >> k;
    for (int i = 0; i < k; i++)
    {
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;

        for (int i = y1; i < y2; i++)
        {
            for (int j = x1; j < x2; j++)
            {
                graph[i][j] = 1;
            }
        }
    }

    int ans = 0;
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (graph[i][j] == 0)
            {
                ans++;
                bfs(i, j);
            }
        }
    }

    cout << ans << '\n';
    sort(v.begin(), v.end());
    for (int i = 0; i < v.size(); i++)
    {
        cout << v[i] << ' ';
    }

    // for (int i = 0; i < m; i++)
    // {
    //     for (int j = 0; j < n; j++)
    //     {
    //         cout << graph[i][j];
    //     }
    //     cout << '\n';
    // }
    return 0;
}