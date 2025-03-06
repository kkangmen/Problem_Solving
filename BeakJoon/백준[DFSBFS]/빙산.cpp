#include <iostream>
#include <cstring>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int n, m;
int graph[300][300];
int graph2[300][300];
bool isvisited[300][300];
int dx[4] = {0, -1, 0, 1};
int dy[4] = {1, 0, -1, 0};

void melt()
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            int x = graph[i][j];
            if (x != 0)
            {
                for (int k = 0; k < 4; k++)
                {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m)
                    {
                        if (graph[nx][ny] == 0 && graph2[i][j] > 0)
                        {
                            graph2[i][j]--;
                        }
                    }
                }
            }
        }
    }
    // copy(&graph2[0][0], &graph2[0][0] + 9000, &graph[0][0]);
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            graph[i][j] = graph2[i][j];
        }
    }
}

void bfs(int x, int y)
{
    queue<pair<int, int>> q;
    q.push(make_pair(x, y));
    isvisited[x][y] = true;
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
                if (isvisited[nx][ny] == false && graph[nx][ny] != 0)
                {
                    q.push(make_pair(nx, ny));
                    isvisited[nx][ny] = true;
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
    copy(&graph[0][0], &graph[0][0] + 9000, &graph2[0][0]);

    int year = 0;
    while (true)
    {
        int cnt = 0;
        for (int j = 0; j < n; j++)
        {
            for (int k = 0; k < m; k++)
            {
                if (isvisited[j][k] == false && graph[j][k] != 0)
                {
                    cnt++;
                    bfs(j, k);
                }
            }
        }
        if (cnt >= 2)
        {
            cout << year << '\n';
            return 0;
        }
        if (cnt == 0)
        {
            cout << 0 << '\n';
            return 0;
        }
        memset(isvisited, false, sizeof(isvisited));
        melt();
        // // test
        // for (int i = 0; i < n; i++)
        // {
        //     for (int j = 0; j < m; j++)
        //     {
        //         cout << graph[i][j] << ' ';
        //     }
        //     cout << '\n';
        // }
        // cout << '\n';
        year++;
    }
    // for (int i = 0; i < n; i++)
    // {
    //     for (int j = 0; j < m; j++)
    //     {
    //         cout << graph[i][j] << ' ';
    //     }
    //     cout << '\n';
    // }
    return 0;
}