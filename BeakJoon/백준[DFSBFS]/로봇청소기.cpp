#include <iostream>
#include <string>
#include <vector>
using namespace std;

int n, m, r, c, d;
int graph[51][51];
bool isvisited[51][51];
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};
int cnt = 1;

void dfs(int x, int y, int dir)
{
    for (int i = 0; i < 4; i++)
    {
        d = (dir + 3 - i) % 4;
        int nx = x + dx[d];
        int ny = y + dy[d];
        if (graph[nx][ny] == 0 && isvisited[nx][ny] == false)
        {
            isvisited[nx][ny] = true;
            cnt++;
            dfs(nx, ny, d);
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m;
    cin >> r >> c >> d;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> graph[i][j];
        }
    }

    dfs(r, c, d);
    return 0;
}