#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <algorithm>
#include <queue>
using namespace std;

int n, m;
map<string, int> name;
map<int, string> nameIndex;
vector<int> graph[1001], child[1001];
int indegree[1001];
int ancestorNum = 0;
vector<string> ancestor;

void topoSort()
{
    queue<int> q;
    for (int i = 1; i <= n; i++)
    {
        if (indegree[i] == 0)
        {
            q.push(i);
            ancestorNum++;
            ancestor.push_back(nameIndex[i]);
        }
    }

    while (!q.empty())
    {
        int x = q.front();
        q.pop();
        for (int i = 0; i < graph[x].size(); i++)
        {
            int y = graph[x][i];
            indegree[y]--;
            if (indegree[y] == 0)
            {
                q.push(y);
                child[x].push_back(y);
            }
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    // freopen("input.txt", "r", stdin);
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        string s;
        cin >> s;
        name.insert({s, i});
        nameIndex.insert({i, s});
    }

    cin >> m;
    for (int i = 0; i < m; i++)
    {
        string x, y;
        cin >> x >> y;
        indegree[name[x]]++;
        graph[name[y]].push_back(name[x]);
    }

    topoSort();
    // for (auto iter : name)
    // {
    //     cout << iter.first << ' ' << iter.second << '\n';
    // }

    cout << ancestorNum << '\n';
    sort(ancestor.begin(), ancestor.end());
    for (int i = 0; i < ancestor.size(); i++)
    {
        cout << ancestor[i] << ' ';
    }
    cout << '\n';
    for (auto iter : name)
    {
        cout << iter.first << ' ' << child[iter.second].size() << ' ';
        vector<string> v;
        for (auto i : child[iter.second])
        {
            v.push_back(nameIndex[i]);
        }
        sort(v.begin(), v.end());
        for (auto i : v)
        {
            cout << i << ' ';
        }
        cout << '\n';
    }
    return 0;
}

/*
백준 문제 파일 읽어와서 문제 입출력 자동으로 하는 방법
*/

// freopen("파일명", "r" , stdin);
// 프로젝트 안에 파일이 있어야 함.
// freopen("input.txt", "r", stdin);