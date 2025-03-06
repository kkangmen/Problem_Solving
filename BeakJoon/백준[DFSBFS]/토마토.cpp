#include <iostream>
#include <string>
#include <vector>
#include <queue>
using namespace std;

int m, n, h;
int graph[100][100][100];
int d[100][100][100];
queue<pair<pair<int, int>, int>> q;
int dx[6] = {0, 0, 1, -1, 0, 0};
int dy[6] = {1, -1, 0, 0, 0, 0};
int dz[6] = {0, 0, 0, 0, 1, -1};
void bfs()
{
    while (!q.empty())
    {
        int x = q.front().first.first;
        int y = q.front().first.second;
        int z = q.front().second;
        q.pop();
        for (int i = 0; i < 6; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int nz = z + dz[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < m && 0 <= nz && nz < h)
            {
                if (graph[nx][ny][nz] == 0)
                {
                    graph[nx][ny][nz] = 1;
                    q.push(make_pair(make_pair(nx, ny), nz));
                    d[nx][ny][nz] = d[x][y][z] + 1;
                }
            }
        }
    }
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> m >> n >> h;
    for (int z = 0; z < h; z++)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                cin >> graph[i][j][z];
                d[i][j][z] = -1;
                if (graph[i][j][z] == 1)
                {
                    d[i][j][z] = 0;
                    q.push(make_pair(make_pair(i, j), z));
                }
            }
        }
    }

    bfs();

    int ans = 0;
    for (int z = 0; z < h; z++)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (graph[i][j][z] == 0)
                {
                    cout << -1 << '\n';
                    return 0;
                }
                else
                {
                    ans = max(ans, d[i][j][z]);
                }
            }
        }
    }
    cout << ans << '\n';

    return 0;
}