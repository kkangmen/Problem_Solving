#include <iostream>
#include <cstring>
#include <vector>
#include <algorithm>
#define MAX 3000
using namespace std;

char board[50][50];
string WB[] = {
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW"};
string BW[] = {
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB"};

int cntwb(int k, int p)
{
    int cnt = 0;
    int r = 0;
    for (int i = k; i < k + 8; i++)
    {
        int c = 0;
        for (int j = p; j < p + 8; j++)
        {
            if (board[i][j] != WB[r][c])
            {
                cnt++;
            }
            c++;
        }
        r++;
    }
    return cnt;
}
int cntbw(int k, int p)
{
    int cnt = 0;
    int r = 0;
    for (int i = k; i < k + 8; i++)
    {
        int c = 0;
        for (int j = p; j < p + 8; j++)
        {
            if (board[i][j] != BW[r][c])
            {
                cnt++;
            }
            c++;
        }
        r++;
    }
    return cnt;
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> board[i][j];
        }
    }

    int ans = MAX;
    for (int i = 0; i + 7 < n; i++)
    {
        for (int j = 0; j + 7 < m; j++)
        {
            // cout << i << ' ' << j << '\n';
            //  cout << cntbw(i) << ' ';
            int val = min(cntbw(i, j), cntwb(i, j));
            if (val < ans)
            {
                ans = val;
            }
        }
    }
    cout << ans << '\n';
    return 0;
}