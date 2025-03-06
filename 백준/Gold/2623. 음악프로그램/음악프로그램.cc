#include <iostream>
#include <cstring>
#include <vector>
#include <queue>
using namespace std;

int n, m;
vector<int> graph[1001];
int indegree[1001];
vector<int> ans;

bool topoSort()
{
    queue<int> q;
    for (int i = 1; i <= n; i++)
    {
        if (indegree[i] == 0)
        {
            q.push(i);
        }
    }

    while (!q.empty())
    {
        int x = q.front();
        q.pop();
        ans.push_back(x);
        for (int i = 0; i < graph[x].size(); i++)
        {
            int y = graph[x][i];
            indegree[y]--;
            if (indegree[y] == 0)
            {
                q.push(y);
            }
        }
    }

    if (ans.size() == n)
    {
        return true;
    }
    else
    {
        return false;
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m;
    for (int i = 0; i < m; i++)
    {
        vector<int> num;
        int x;
        cin >> x;
        for (int j = 0; j < x; j++)
        {
            int y;
            cin >> y;
            num.push_back(y);
        }

        for (int j = 0; j < x - 1; j++)
        {
            graph[num[j]].push_back(num[j + 1]);
            indegree[num[j + 1]]++;
        }
    }

    if (topoSort())
    {
        for (int i = 0; i < n; i++)
        {
            cout << ans[i] << '\n';
            // cout << indegree[i] << ' ';
        }
    }
    else
    {
        cout << 0 << '\n';
    }
    return 0;
}