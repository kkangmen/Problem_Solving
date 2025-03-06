#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int n;
vector<int> graph[50];
int val[50];
bool isvisited[50];
int leafNode = 0;
int delnode;
int dfs(int x)
{
    if (graph[x].size() == 0)
    {
        leafNode++;
        return 1;
    }
    if (graph[x].size() == 1 && graph[x][0] == delnode)
    {
        leafNode++;
        return 1;
    }
    isvisited[x] = true;
    for (int i = 0; i < graph[x].size(); i++)
    {
        int y = graph[x][i];
        if (isvisited[y] == false)
        {
            dfs(y);
        }
    }
    return leafNode;
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int parnode = 0;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int v;
        cin >> v;
        if (v != -1)
        {
            graph[v].push_back(i);
        }
        else
        {
            parnode = i;
        }
    }

    cin >> delnode;
    isvisited[delnode] = true;

    if (isvisited[parnode] == false)
    {
        cout << dfs(parnode) << '\n';
    }
    else
    {
        cout << 0 << '\n';
    }

    return 0;
}