#include <iostream>
#include <string>
#include <vector>
#include <queue>
using namespace std;

int n, m;
char graph[201][201];
bool isvisited[201][201];
int dist[201][201];
int dx[4] = {0, -1, 0, 1};
int dy[4] = {1, 0, -1, 0};

void bfs(int row, int col)
{
    queue<pair<int, int>> q;
    q.push(make_pair(row, col));
    isvisited[row][col] = true;
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
                if (isvisited[nx][ny] == false && graph[nx][ny] == '1')
                {
                    q.push(make_pair(nx, ny));
                    isvisited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
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
        string s;
        cin >> s;
        for (int j = 0; j < m; j++)
        {
            graph[i][j] = s[j];
        }
    }

    bfs(0, 0);

    // for (int i = 0; i < n; i++)
    // {
    //     for (int j = 0; j < m; j++)
    //     {
    //         cout << dist[i][j];
    //     }
    //     cout << '\n';
    // }
    cout << dist[n - 1][m - 1] + 1 << '\n';
    return 0;
}

// 5 6
// 101010
// 111111
// 000001
// 111111
// 111111
