#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int n, m;
vector<int> v;

bool findNum(int target)
{
    int left = 0;
    int right = v.size() - 1;
    while (left <= right)
    {
        int mid = (left + right) / 2;
        if (v[mid] == target)
        {
            return true;
        }
        else if (v[mid] < target)
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

    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        v.push_back(x);
    }

    sort(v.begin(), v.end());

    cin >> m;
    for (int i = 0; i < m; i++)
    {
        int y;
        cin >> y;
        if (findNum(y))
        {
            cout << 1 << ' ';
        }
        else
        {
            cout << 0 << ' ';
        }
    }
    return 0;
}