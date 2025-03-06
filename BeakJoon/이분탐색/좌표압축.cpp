#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int n;
vector<int> v;
vector<int> vSort;
int binSearch(int target)
{
    int left = 0;
    int right = vSort.size() - 1;
    while (left <= right)
    {
        int mid = (left + right) / 2;
        if (vSort[mid] == target)
        {
            return mid;
        }
        else if (vSort[mid] < target)
        {
            left = mid + 1;
        }
        else
        {
            right = mid - 1;
        }
    }
    return 1;
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
        vSort.push_back(x);
    }
    sort(vSort.begin(), vSort.end());
    vSort.erase(unique(vSort.begin(), vSort.end()), vSort.end());
    for (int i = 0; i < n; i++)
    {
        cout << binSearch(v[i]) << ' ';
    }
    return 0;
}