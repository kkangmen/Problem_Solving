#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int n, m;
vector<int> graph[32001];
int indegree[32001];

void topoSort()
{
    priority_queue<int, vector<int>, greater<int>> pq;
    for (int i = 1; i <= n; i++)
    {
        if (indegree[i] == 0)
        {
            pq.push(i);
        }
    }

    while (!pq.empty())
    {
        int x = pq.top();
        pq.pop();
        cout << x << ' ';
        for (int i = 0; i < graph[x].size(); i++)
        {
            int y = graph[x][i];
            indegree[y]--;
            if (indegree[y] == 0)
            {
                pq.push(y);
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
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
        indegree[b]++;
    }

    topoSort();
    return 0;
}