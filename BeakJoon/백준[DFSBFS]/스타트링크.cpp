#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <string.h>
using namespace std;

int graph[1000001];
bool isvisited[1000001];
int f, s, g, u, d;

void bfs(int x)
{
    int dx[2] = {u, -d};
    graph[x] = 0;
    queue<int> q;
    q.push(x);
    isvisited[x] = true;
    while (!q.empty())
    {
        x = q.front();
        q.pop();
        for (int i = 0; i < 2; i++)
        {
            int nx = x + dx[i];
            if (0 < nx && nx <= f)
            {
                if (isvisited[nx] == false)
                {
                    isvisited[nx] = true;
                    q.push(nx);
                    graph[nx] = graph[x] + 1;
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

    cin >> f >> s >> g >> u >> d;

    memset(graph, -1, 1000000);
    if ((u == 0 && f > s) || (d == 0 && f < s))
    {
        cout << "use the stairs" << '\n';
        return 0;
    }
    bfs(s);

    if (graph[g] == -1)
    {
        cout << "use the stairs" << '\n';
        return 0;
    }

    // for (int i = 0; i < f; i++)
    // {
    //     cout << graph[i] << ' ';
    // }
    // cout << '\n';
    cout << graph[g] << '\n';
    return 0;
}