#include <iostream>
#include <string>
#include <vector>
using namespace std;

int n;
int cnt = 0;
int endNode;
bool flag = true;
struct Edge
{
    int left;
    int right;
};
Edge node[100001];

void inorder(int x)
{
    if (x == -1)
    {
        return;
    }
    inorder(node[x].left);
    //cout << x << ' ';
    endNode = x;
    inorder(node[x].right);
}

void countNode(int x)
{
    // cout << "node: " << x << " cnt: " << cnt << '\n';
    cnt++;
    if (x == -1)
    {
        cnt--;
        return;
    }
    countNode(node[x].left);
    if (x == endNode)
    {
        flag = false;
        return;
    }
    countNode(node[x].right);
    if (flag)
    {
        cnt++;
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        int x, y, z;
        cin >> x >> y >> z;

        node[x].left = y;
        node[x].right = z;
    }

    inorder(1);
    countNode(1);
    // cout << endNode << '\n';
    cout << cnt - 1 << '\n';
    return 0;
}