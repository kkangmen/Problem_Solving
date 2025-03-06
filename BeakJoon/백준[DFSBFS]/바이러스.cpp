#include <iostream>
#include <string>
#include <vector>
#include <queue>
using namespace std;

vector<int> v[101];
bool visited[101];
int n, num;

int bfs(int start){
    int count = 0;
    visited[start] = true;
    queue<int> q;
    q.push(start);
    while (!q.empty()){
        int y = q.front();
        q.pop();
        for (int i = 0; i < v[y].size(); i++){
            int t = v[y][i];
            if (!visited[t]){
                visited[t] = true;
                q.push(t);
                count++;
            }
        }
    }
    return count;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> num;
    for (int i = 0; i < num; i++){
        int k, e;
        cin >> k >> e;
        v[k].push_back(e);
        v[e].push_back(k);
    }

    cout << bfs(1) << '\n';
    return 0;
}