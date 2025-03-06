#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int graph[500][500];
bool isvisited[500][500];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
int n, m;
int cnt = 0;
int ans = 0;
int bfs(int row, int col)
{
    queue<pair<int, int>> q;
    q.push(make_pair(row, col));
    isvisited[row][col] = true;
    cnt++;
    int width = 0;
    while (!q.empty())
    {
        int x = q.front().first;
        int y = q.front().second;
        width++;
        q.pop();
        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < m)
            {
                if (graph[nx][ny] == 1 && isvisited[nx][ny] == false)
                {
                    q.push(make_pair(nx, ny));
                    isvisited[nx][ny] = true;
                }
            }
        }
    }
    return width;
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> graph[i][j];
        }
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (isvisited[i][j] == false && graph[i][j] == 1)
            {
                ans = max(bfs(i, j), ans);
            }
        }
    }

    cout << cnt << '\n';
    cout << ans << '\n';
    return 0;
}