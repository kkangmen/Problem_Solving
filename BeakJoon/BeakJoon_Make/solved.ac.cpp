#include <iostream>
#include <string>
#include <vector>
#include <cmath>
#include <algorithm>
#include <deque>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    deque<int> dq;

    if (n == 0)
    {
        cout << 0 << '\n';
    }
    else
    {
        int del = round((double)(n * 0.15));
        for (int i = 0; i < n; i++)
        {
            int k;
            cin >> k;
            dq.push_back(k);
        }
        // cout << "del: " << del << '\n';
        sort(dq.begin(), dq.end());

        for (int i = 0; i < del; i++)
        {
            dq.pop_front();
            dq.pop_back();
        }

        // for (int i =0 ; i < dq.size(); i++){
        //     cout << dq[i] << '\n';
        // }
        int sum = 0;
        int dqsize = dq.size();
        while (!dq.empty())
        {
            // cout << sum << '\n';
            sum += dq.front();
            dq.pop_front();
        }
        // cout << sum << '\n';
        // cout << dqsize << '\n';
        int ans = round((double)sum / (double)dqsize);
        cout << ans << '\n';
    }
    return 0;
}