#include <iostream>
#include <string>
#include <vector>
using namespace std;

int n;
int a, b;
int m;
vector<int> graph[100];
bool isvisited[100];
int ans = 0;
int dfs(int start, int goal, int cnt)
{
    cout << "1. dfs" << start << goal << cnt << '\n';
    isvisited[start] = 1;

    if (start == goal)
    {
        ans = cnt;
        cout << "return 1" << '\n';
        return 1;
    }

    for (int i = 0; i < graph[start].size(); i++)
    {
        int y = graph[start][i];
        if (isvisited[y] == false)
        {
            if (dfs(y, goal, cnt + 1))
            {
                cout << "dfs(y, goal, cnt): " << y << goal << cnt << '\n';
                cout << "return 1" << '\n';
                return 1;
            }
        }
    }
    return 1;
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    cin >> a >> b;
    cin >> m;
    for (int i = 0; i < m; i++)
    {
        int x, y;
        cin >> x >> y;
        graph[x].push_back(y);
        graph[y].push_back(x);
    }

    if (dfs(a, b, 0))
    {
        cout << ans << '\n';
    }
    else
    {
        cout << -1 << '\n';
    }
    return 0;
}
