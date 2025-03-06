#include <iostream>
#include <string>
#include <vector>
#include <queue>
using namespace std;

int t, n;
vector<pair<int, int>> store;
int val[100000][100000];
int dx[4] = {0, 50, 0, -50};
int dy[4] = {50, 0, -50, 0};

void bfs(int x, int y){
    queue<pair<int, int>> q;
    q.push(make_pair(x, y));
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> t;
    while (t--){
        cin >> n;
        for (int i = 0; i < n + 2; i++){
            int x, y;
            cin >> x >> y;
            x = x + 32768;
            y = y + 32768;
            store.push_back(make_pair(x, y));
        }
    }

    bfs(store.front().first, store.front().second);
    return 0;
}