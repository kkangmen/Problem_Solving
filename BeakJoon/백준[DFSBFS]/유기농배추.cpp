#include <iostream>
#include <string>
#include <vector>
using namespace std;

int graph[51][51];
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};
int ts, n, m, k;
void dfs(int x, int y)
{
    graph[x][y] = 0;
    for (int i = 0; i < 4; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (0 <= nx && nx < n && 0 <= ny && ny < m && graph[nx][ny])
        {
            dfs(nx, ny);
        }
    }
}
void reset()
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            graph[i][j] = 0;
        }
    }
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> ts;
    while (ts--)
    {
        reset();
        cin >> m >> n >> k;
        for (int i = 0; i < k; i++)
        {
            int a, b;
            cin >> a >> b;
            graph[b][a] = 1;
        }

        int cnt = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (graph[i][j])
                {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        cout << cnt << '\n';
    }
    return 0;
}