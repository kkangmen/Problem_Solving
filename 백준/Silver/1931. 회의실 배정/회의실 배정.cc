#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int n;
pair<int, int> d[100000];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> d[i].second >> d[i].first;
    }

    sort(d, d + n);

    int ans = 0;
    int t = 0;
    for (int i = 0; i < n; i++)
    {
        if (t <= d[i].second)
        {
            ans++;
            t = d[i].first;
        }
    }

    cout << ans << '\n';
    return 0;
}