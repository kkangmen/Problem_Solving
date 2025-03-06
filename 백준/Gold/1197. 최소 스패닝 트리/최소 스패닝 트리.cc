#include <iostream>
#include <string>
#include <vector>
#include <tuple>
#include <algorithm>
using namespace std;

tuple<int, int, int> graph[100000];
int v, e;
int parent[10001];
int cnt = 0;
int sum = 0;
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

    cin >> v >> e;
    for (int i = 1; i <= v; i++)
    {
        parent[i] = i;
    }
    for (int i = 0; i < e; i++)
    {
        int a, b, cost;
        cin >> a >> b >> cost;
        graph[i] = make_tuple(cost, a, b);
        // tie(cost, a, b) = graph[i];
    }

    sort(graph, graph + e);

    // for (int i = 0; i < e; i++)
    // {
    //     cout << get<0>(graph[i]) << get<1>(graph[i]) << get<2>(graph[i]) << '\n';
    // }
    for (int i = 0; i < e; i++)
    {
        if (findParent(get<1>(graph[i]), get<2>(graph[i])) == true)
        {
            continue;
        }

        unionParent(get<1>(graph[i]), get<2>(graph[i]));
        cnt++;
        sum += get<0>(graph[i]);
        if (cnt == v - 1)
        {
            break;
        }
    }

    cout << sum << '\n';
    return 0;
}