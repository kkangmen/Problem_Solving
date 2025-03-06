#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int m, n;
vector<int> v;
int ans = 0;

void binSearch()
{
    int left = 1;
    int right = 1e9;
    while (left <= right)
    {
        int sum = 0;
        int mid = (left + right) / 2;
        for (int i = 0; i < v.size(); i++)
        {
            int cnt = v[i] / mid;
            if (cnt >= 1)
            {
                sum += cnt;
            }
        }
        if (sum >= m)
        {
            ans = max(ans, mid);
            left = mid + 1;
        }
        else if (sum < m)
        {
            right = mid - 1;
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> m >> n;
    for (int i = 0; i < n; i++)
    {
        int l;
        cin >> l;
        v.push_back(l);
    }

    binSearch();

    cout << ans << '\n';
    return 0;
}