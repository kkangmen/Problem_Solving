#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int n, m;
vector<pair<int, int>> graph[101];
int indegree[101];
int cnt[101];
vector<int> basic;

void topoSort()
{
    queue<int> q;
    q.push(n);
    cnt[n] = 1;
    while (!q.empty())
    {
        int x = q.front();
        q.pop();
        if (graph[x].size() == 0)
        {
            basic.push_back(x);
        }
        for (int i = 0; i < graph[x].size(); i++)
        {
            int nxt = graph[x][i].first;
            int val = graph[x][i].second;
            cnt[nxt] += cnt[x] * val;
            indegree[nxt]--;
            if (indegree[nxt] == 0)
            {
                q.push(nxt);
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
    for (int i = 0; i < m; i++)
    {
        int x, y, k;
        cin >> x >> y >> k;
        graph[x].push_back({y, k});
        indegree[y]++;
    }

    topoSort();
    sort(basic.begin(), basic.end());

    for (auto k : basic)
    {
        cout << k << ' ' << cnt[k] << '\n';
    }
    return 0;
}