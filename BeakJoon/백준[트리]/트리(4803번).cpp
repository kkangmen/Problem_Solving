#include <iostream>
#include <cstring>
#include <vector>
#include <fstream>
using namespace std;

int n, m;
vector<int> graph[501];
bool isvisited[501];
int val[501];
int caseNum = 1;
bool cycle = false;
void dfs(int x, int cnt)
{
    if (isvisited[x] == true)
    {
        if (cnt - val[x] >= 3)
        {
            cycle = true;
        }
        return;
    }
    isvisited[x] = true;
    val[x] = cnt;
    for (int i = 0; i < graph[x].size(); i++)
    {
        int y = graph[x][i];
        dfs(y, cnt + 1);
    }
    return;
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    // freopen("input.txt", "r", stdin);
    while (true)
    {
        cin >> n >> m;

        if (n == 0 && m == 0)
        {
            break;
        }
        memset(isvisited, false, sizeof(isvisited));
        memset(val, 0, sizeof(val));
        for (int i = 0; i <= 501; i++)
        {
            graph[i].clear();
        }
        for (int i = 0; i < m; i++)
        {
            int v, u;
            cin >> v >> u;
            graph[v].push_back(u);
            graph[u].push_back(v);
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++)
        {
            if (isvisited[i] == false)
            {
                cycle = false;
                dfs(i, 0);
                if (!cycle)
                {
                    cnt++;
                }
            }
        }

        if (cnt == 1)
        {
            cout << "Case " << caseNum << ": There is one tree." << '\n';
        }
        else if (cnt == 0)
        {
            cout << "Case " << caseNum << ": No trees." << '\n';
        }
        else
        {
            cout << "Case " << caseNum << ": A forest of " << cnt << " trees." << '\n';
        }
        caseNum++;
    }
    return 0;
}
