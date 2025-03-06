#include <iostream>
#include <string>
#include <vector>
using namespace std;

int n, m;
int parent[1000001];

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
    int x = getParent(a);
    int y = getParent(b);
    if (x == y)
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
        int order, a, b;
        cin >> order >> a >> b;
        if (order == 0)
        {
            unionParent(a, b);
        }
        else if (order == 1)
        {
            if (findParent(a, b))
            {
                cout << "YES" << '\n';
            }
            else
            {
                cout << "NO" << '\n';
            }
        }
    }
    return 0;
}