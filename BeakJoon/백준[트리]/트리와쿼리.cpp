#include <iostream>
#include <string>
#include <vector>
using namespace std;

int n, r, q;
vector<int> graph[100001];
vector<int> tree[100001];
bool isvisited[100001];
int node_cnt[100001];
void countNode(int currentNode)
{
    node_cnt[currentNode] = 1;
    for (int i = 0; i < tree[currentNode].size(); i++)
    {
        int y = tree[currentNode][i];
        countNode(y);
        node_cnt[currentNode] += node_cnt[y];
    }
}
void make_tree(int currentNode)
{
    isvisited[currentNode] = true;
    for (int i = 0; i < graph[currentNode].size(); i++)
    {
        int y = graph[currentNode][i];
        if (isvisited[y] == false)
        {
            isvisited[y] = true;
            tree[currentNode].push_back(y);
            make_tree(y);
        }
    }
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> r >> q;
    for (int i = 0; i < n - 1; i++)
    {
        int u, v;
        cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
    make_tree(r);
    countNode(r);
    for (int i = 0; i < q; i++)
    {
        int x;
        cin >> x;
        cout << node_cnt[x] << '\n';
    }
    return 0;
}