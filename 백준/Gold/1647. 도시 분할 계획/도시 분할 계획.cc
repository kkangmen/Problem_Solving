#include <iostream>
#include <string>
#include <vector>
#include <tuple>
#include <algorithm>
#include <numeric>
using namespace std;

int n, m;
tuple<int, int, int> graph[1000000];
int parent[100001];
int cnt = 0;
vector<int> ans;

int getParent(int x)
{
    if (parent[x] == x)
    {
        return x;
    }
    return parent[x] = getParent(parent[x]);
}

void unionParent(int a, int b)
{
    a = getParent(a);
    b = getParent(b);
    if (a < b)
    {
        parent[b] = a;
    }
    else
    {
        parent[a] = b;
    }
}

bool findParent(int a, int b)
{
    a = getParent(a);
    b = getParent(b);
    if (a == b)
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
    for (int i = 1; i <= n; i++)
    {
        parent[i] = i;
    }
    for (int i = 0; i < m; i++)
    {
        int a, b, cost;
        cin >> a >> b >> cost;
        graph[i] = make_tuple(cost, a, b);
    }

    sort(graph, graph + m);

    for (int i = 0; i < m; i++)
    {
        if (findParent(get<1>(graph[i]), get<2>(graph[i])))
        {
            continue;
        }

        unionParent(get<1>(graph[i]), get<2>(graph[i]));
        cnt++;
        ans.push_back(get<0>(graph[i]));
        if (cnt == n - 1)
        {
            break;
        }
    }

    int maxNum = *max_element(ans.begin(), ans.end());
    cout << accumulate(ans.begin(), ans.end(), -maxNum) << '\n';
    return 0;
}