#include <iostream>
#include <cstring>
#include <vector>
#include <algorithm>
using namespace std;

int n;
char graph[101][101];
bool isvisited[101][101];
int dx[4] = {0, -1, 0, 1};
int dy[4] = {1, 0, -1, 0};
void dfs(int x, int y, char c)
{
    isvisited[x][y] = true;
    for (int i = 0; i < 4; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (0 < nx && nx <= n && 0 < ny && ny <= n)
        {
            if (isvisited[nx][ny] == false && graph[nx][ny] == c)
            {
                dfs(nx, ny, c);
            }
        }
    }
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        string s;
        cin >> s;
        for (int j = 1; j <= n; j++)
        {
            graph[i][j] = s[j - 1];
        }
    }

    int cnt = 0;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            if (isvisited[i][j] == false)
            {
                cnt++;
                dfs(i, j, graph[i][j]);
            }
        }
    }
    cout << cnt << ' ';
    fill(&isvisited[0][0], &isvisited[101][101], false);
    // for (int i = 1; i <= n; i++)
    // {
    //     for (int j = 1; j <= n; j++)
    //     {
    //         cout << isvisited[i][j];
    //     }
    //     cout << '\n';
    // }
    cnt = 0;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            // isvisited[i][j] = false;
            if (graph[i][j] == 'G')
            {
                graph[i][j] = 'R';
            }
        }
    }

    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            if (isvisited[i][j] == false)
            {
                cnt++;
                dfs(i, j, graph[i][j]);
            }
        }
    }
    cout << cnt << '\n';
    return 0;
}