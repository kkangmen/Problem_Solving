#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(){
    int n;
    int score;
    vector<float> score_arr;
    float avg;
    float sum = 0;

    cin >> n;

    for (int i = 0; i < n; i++){
        cin >> score;
        score_arr.push_back(score);
    }

    float max_score = score_arr[0];
    for (int i = 1; i < n; i++){
        max_score = max(max_score, score_arr[i]);
    }
    
    for (int i = 0; i < n; i++){
        score_arr[i] = static_cast<float> (score_arr[i])/max_score*100;
        sum += score_arr[i];
    }
    avg = sum / static_cast<float> (n);

    cout << fixed;
    cout.precision(2);

    cout << avg << endl;
    
    return 0;
}