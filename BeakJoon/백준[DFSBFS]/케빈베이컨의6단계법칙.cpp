#include <iostream>
#include <cstring>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int n, m;
vector<int> graph[101];
int val[101];
bool isvisited[101];
int ans[101];
int bfs(int x)
{
    // cout << "작동" << '\n';
    queue<int> q;
    q.push(x);
    isvisited[x] = true;
    while (!q.empty())
    {
        int y = q.front();
        q.pop();
        for (int i = 0; i < graph[y].size(); i++)
        {
            int k = graph[y][i];
            if (isvisited[k] == false)
            {
                q.push(k);
                val[k] = val[y] + 1;
                isvisited[k] = true;
            }
        }
    }
    int sum = 0;
    for (int i = 1; i <= n; i++)
    {
        sum += val[i];
    }
    return sum;
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m;
    for (int i = 0; i < m; i++)
    {
        int x, y;
        cin >> x >> y;
        graph[x].push_back(y);
        graph[y].push_back(x);
    }

    // for (int i = 1; i <= n; i++)
    // {
    //     for (int j = 0; j < graph[i].size(); j++)
    //     {
    //         cout << graph[i][j] << ' ';
    //     }
    // }
    for (int i = 1; i <= n; i++)
    {
        ans[i] = bfs(i);
        memset(val, 0, sizeof(val));
        memset(isvisited, false, sizeof(isvisited));
    }

    int min = ans[1];
    int index = 1;
    for (int i = 2; i <= n; i++)
    {
        if (min > ans[i])
        {
            min = ans[i];
            index = i;
        }
    }
    cout << index << '\n';
    return 0;
}