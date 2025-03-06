#include <iostream>
#include <cstring>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int l, w;
char graph[50][50];
int val[50][50];
int dist[50][50];
int dx[4] = {0, -1, 0, 1};
int dy[4] = {1, 0, -1, 0};
int ans = 0;

void cntAns()
{
    int num = 0;
    for (int i = 0; i < l; i++)
    {
        for (int j = 0; j < w; j++)
        {
            if (num < dist[i][j])
            {
                num = dist[i][j];
            }
        }
    }
    ans = max(ans, num);
}

void bfs(int row, int col)
{
    queue<pair<int, int>> q;
    q.push(make_pair(row, col));
    dist[row][col] = 0;
    while (!q.empty())
    {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < l && 0 <= ny && ny < w)
            {
                if (graph[nx][ny] == 'L' && dist[nx][ny] == -1)
                {
                    q.push(make_pair(nx, ny));
                    dist[nx][ny] = dist[x][y] + 1;
                }
            }
        }
    }
    cntAns();
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> l >> w;
    for (int i = 0; i < l; i++)
    {
        string s;
        cin >> s;
        for (int j = 0; j < w; j++)
        {
            graph[i][j] = s[j];
        }
    }

    for (int i = 0; i < l; i++)
    {
        for (int j = 0; j < w; j++)
        {
            if (graph[i][j] == 'L')
            {
                memset(dist, -1, sizeof(dist));
                bfs(i, j);
            }
        }
    }

    cout << ans << '\n';
    return 0;
}