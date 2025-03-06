#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int ts;
int l, r, c;
char graph[31][31][31];
int val[31][31][31];
bool isvisited[31][31][31];
int dx[6] = {0, 1, 0, -1, 0, 0};
int dy[6] = {1, 0, -1, 0, 0, 0};
int dz[6] = {0, 0, 0, 0, 1, -1};
void bfs(int x, int y, int z)
{
    queue<pair<pair<int, int>, int>> q;
    q.push(make_pair(make_pair(x, y), z));
    isvisited[x][y][z] = true;
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
            if (0 < nx && nx <= r && 0 < ny && ny <= c && 0 < nz && nz <= l)
            {
                if ((graph[nx][ny][nz] == '.' || graph[nx][ny][nz] == 'E') && isvisited[nx][ny][nz] == false)
                {
                    q.push(make_pair(make_pair(nx, ny), nz));
                    isvisited[nx][ny][nz] = true;
                    val[nx][ny][nz] = val[x][y][z] + 1;
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

    while (true)
    {
        // l = 층, r = 행, c = 열
        cin >> l >> r >> c;
        if (l == 0 && r == 0 && c == 0)
        {
            break;
        }
        fill(&val[0][0][0], &val[31][31][31], 0);
        fill(&isvisited[0][0][0], &isvisited[31][31][31], false);
        for (int i = 1; i <= l; i++)
        {
            for (int j = 1; j <= r; j++)
            {
                string s;
                cin >> s;
                for (int k = 1; k <= c; k++)
                {
                    graph[j][k][i] = s[k - 1];
                }
            }
        }

        for (int i = 1; i <= l; i++)
        {
            for (int j = 1; j <= r; j++)
            {
                for (int k = 1; k <= c; k++)
                {
                    if (graph[j][k][i] == 'S')
                    {
                        bfs(j, k, i);
                    }
                }
            }
        }

        for (int i = 1; i <= l; i++)
        {
            for (int j = 1; j <= r; j++)
            {
                for (int k = 1; k <= c; k++)
                {
                    if (graph[j][k][i] == 'E')
                    {
                        int ans = val[j][k][i];
                        if (ans == 0)
                        {
                            cout << "Trapped!" << '\n';
                        }
                        else
                        {
                            cout << "Escaped in " << ans << " minute(s)." << '\n';
                        }
                    }
                }
            }
        }
    }
    return 0;
}