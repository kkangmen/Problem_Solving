#include <iostream>
#include <string>
#include <vector>
using namespace std;

int n;
int graph[100][100];
int d[100][100];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
void dfs(int x, int y)
{
    d[x][y] = -1;
    for (int i = 0; i < 4; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (0 <= nx && nx < n && 0 <= ny && ny < n)
        {

            if (d[nx][ny] == 0)
            {
                d[nx][ny] = -1;
                dfs(nx, ny);
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
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> graph[i][j];
        }
    }

    int ans = 0;
    for (int i = 0; i <= 100; i++)
    {
        for (int j = 0; j < n; j++)
        {
            for (int k = 0; k < n; k++)
            {
                d[j][k] = 0;
                if (graph[j][k] <= i)
                {
                    d[j][k] = -1;
                }
            }
        }

        int cnt = 0;
        for (int j = 0; j < n; j++)
        {
            for (int k = 0; k < n; k++)
            {
                if (d[j][k] == 0)
                {
                    cnt++;
                    dfs(j, k);
                }
            }
        }
        // cout << "i= " << i << "cnt = " << cnt << '\n';
        ans = max(ans, cnt);
    }
    cout << ans << '\n';
    return 0;
}