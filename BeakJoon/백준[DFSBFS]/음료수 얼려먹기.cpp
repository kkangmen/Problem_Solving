#include <iostream>
#include <string>
#include <vector>
using namespace std;

int n, m;
char graph[1000][1000];
int cnt = 0;
bool isvisited[1000][1000];
int dx[4] = {0, -1, 0, 1};
int dy[4] = {1, 0, -1, 0};

void dfs(int x, int y)
{
    isvisited[x][y] = true;
    for (int i = 0; i < 4; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (0 <= nx && nx < n && 0 <= ny && ny < m)
        {
            if (isvisited[nx][ny] == false && graph[nx][ny] == '0')
            {
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

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (graph[i][j] == '0' && isvisited[i][j] == false)
            {
                cnt++;
                dfs(i, j);
            }
        }
    }
    cout << cnt << '\n';
    return 0;
}