#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int n, m;
int graph[8][8];
int graphCopy[8][8];
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};
int ans = 0;

void bfs()
{
    int after[8][8];
    copy(&graphCopy[0][0], &graphCopy[0][0] + 64, &after[0][0]);

    queue<pair<int, int>> q;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (after[i][j] == 2)
            {
                q.push(make_pair(i, j));
            }
        }
    }

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
                if (after[nx][ny] == 0)
                {
                    after[nx][ny] = 2;
                    q.push(make_pair(nx, ny));
                }
            }
        }
    }

    int cnt = 0;
    for (int i = 0; i < n; i++)
    
    {
        for (int j = 0; j < m; j++)
        {
            if (after[i][j] == 0)
            {
                cnt++;
            }
        }
    }

    ans = max(ans, cnt);
}

void wall(int cnt)
{
    if (cnt == 3)
    {
        bfs();
        return;
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (graphCopy[i][j] == 0)
            {
                graphCopy[i][j] = 1;
                wall(cnt + 1);
                graphCopy[i][j] = 0;
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

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (graph[i][j] == 0)
            {
                copy(&graph[0][0], &graph[0][0] + 64, &graphCopy[0][0]);
                graphCopy[i][j] = 1;
                wall(1);
                graphCopy[i][j] = 0;
            }
        }
    }

    cout << ans << '\n';

    return 0;
}