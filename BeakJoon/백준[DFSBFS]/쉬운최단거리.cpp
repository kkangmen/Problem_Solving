#include <iostream>
#include <cstring>
#include <vector>
#include <queue>
using namespace std;

int n, m;
int graph[1000][1000];
int val[1000][1000];
int row, col;
int dx[4] = {0, -1, 0, 1};
int dy[4] = {1, 0, -1, 0};

void bfs(int row, int col)
{
    val[row][col] = 0;
    queue<pair<int, int>> q;
    q.push(make_pair(row, col));
    while (!q.empty())
    {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < m)
            {
                if (val[nx][ny] == -1 && graph[nx][ny] == 1)
                {
                    q.push(make_pair(nx, ny));
                    val[nx][ny] = val[x][y] + 1;
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

    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> graph[i][j];
        }
    }

    memset(val, -1, sizeof(val));
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (graph[i][j] == 2)
            {
                row = i;
                col = j;
            }
            if (graph[i][j] == 0)
            {
                val[i][j] = 0;
            }
        }
    }

    bfs(row, col);

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cout << val[i][j] << ' ';
        }
        cout << '\n';
    }
    return 0;
}