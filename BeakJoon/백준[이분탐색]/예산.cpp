#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int n, m;
vector<int> v;
int gap = 1e9;
int ans;

void binSearch()
{
    int left = 0;
    int right = 1e9;
    while (left <= right)
    {
        int sum = 0;
        int mid = (left + right) / 2;
        for (int i = 0; i < v.size(); i++)
        {
            if (v[i] <= mid)
            {
                sum += v[i];
            }
            else
            {
                sum += mid;
            }
        }
        if (sum == m)
        {
            ans = mid;
            return;
        }
        else if (sum < m)
        {
            if (0 < m - sum && m - sum < gap)
            {
                gap = m - sum;
                ans = mid;
            }
            left = mid + 1;
        }
        else
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

    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        v.push_back(x);
    }
    cin >> m;

    sort(v.begin(), v.end());
    int sum = 0;
    for (int i = 0; i < n; i++)
    {
        sum += v[i];
    }

    if (sum <= m)
    {
        cout << *max_element(v.begin(), v.end());
        return 0;
    }
    else
    {
        binSearch();
    }

    cout << ans << '\n';
    return 0;
}