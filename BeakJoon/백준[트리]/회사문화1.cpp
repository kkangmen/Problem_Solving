#include <iostream>
#include <string>
#include <vector>
using namespace std;

int n, m, k, w;
vector<int> graph[100001];
int val[100001];
bool isvisited[100001];
int ans[100001];
void dfs(int x, int before)
{
    isvisited[x] = true;
    ans[x] = ans[before] + val[x];
    for (int i = 0; i < graph[x].size(); i++)
    {
        int y = graph[x][i];
        if (isvisited[y] == false && y != -1)
        {
            dfs(y, x);
        }
    }
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m;
    for (int i = 1; i <= n; i++)
    {
        int x;
        cin >> x;
        graph[i].push_back(x);
        graph[x].push_back(i);
    }

    for (int i = 0; i < m; i++)
    {
        cin >> k >> w;
        val[k] += w;
    }

    dfs(1, 0);

    for (int i = 1; i <= n; i++)
    {
        cout << ans[i] << ' ';
    }
    return 0;
}
