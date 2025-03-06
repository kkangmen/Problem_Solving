#include <iostream>
#include <string>
#include <vector>
using namespace std;
int arr[6];
int n;
int t, p;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for (int i = 0; i < 6; i++)
    {
        cin >> arr[i];
    }
    cin >> t >> p;

    int cnt = 0;
    for (int i = 0; i < 6; i++)
    {
        if (arr[i] % t == 0)
        {
            cnt += arr[i] / t;
        }
        else if (arr[i] < t)
        {
            cnt += 1;
        }
        else
        {
            cnt += arr[i] / t + 1;
        }
    }

    cout << cnt << '\n';
    cout << n / p << ' ' << n % p << '\n';
    return 0;
}