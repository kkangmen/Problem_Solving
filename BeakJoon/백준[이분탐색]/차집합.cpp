#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int n, m;
vector<int> a;
vector<int> b;
vector<int> ans;
int cnt = 0;
bool binSearch(int target)
{
    int left = 0;
    int right = b.size() - 1;
    while (left <= right)
    {
        int mid = (left + right) / 2;
        if (b[mid] == target)
        {
            return true;
        }
        else if (b[mid] < target)
        {
            left = mid + 1;
        }
        else
        {
            right = mid - 1;
        }
    }
    return false;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        a.push_back(x);
    }
    for (int i = 0; i < m; i++)
    {
        int y;
        cin >> y;
        b.push_back(y);
    }
    sort(a.begin(), a.end());
    sort(b.begin(), b.end());

    for (int i = 0; i < n; i++)
    {
        if (!binSearch(a[i]))
        {
            ans.push_back(a[i]);
            cnt++;
        }
    }

    cout << cnt << '\n';
    for (int i = 0; i < ans.size(); i++)
    {
        cout << ans[i] << ' ';
    }
    return 0;
}