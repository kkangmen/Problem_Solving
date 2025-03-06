#include <iostream>
#include <string>

using namespace std;

class Histogram{
private:
    int count[26] = {0,};
    string str;
public: 
    Histogram(string s){
        str = s;
        makeHisto();
    }
    void makeHisto(){
        //int alphat_cnt = 0;
        for (int i = 0; i < str.size(); i++){
            str[i] = tolower(str[i]);
            if(isalpha(str[i])){
                count[str[i]-97]++;
                //alphat_cnt++;
            }
        }
        //cout << "ÃÑ ¾ËÆÄºª ¼ö " << alphat_cnt << '\n';
    }
    void operator!(){
        for (int i = 0; i < 26; i++){
            cout << static_cast<char>(i+97) << " : ";
            for (int j = 0; j < count[i]; j++){
                cout << '*';
            }
            cout << '\n';
        }
    }
    Histogram& operator << (string s){
        this->str += s;
        return *this;
    }
    Histogram& operator << (char c){
        this->str += c;
        return *this;
    }
};

int main(){
    cout << "Wise men say, \nonly fools rush in But I can't help, falling in love with you.- by kit" << '\n';
    cout << '\n';
    Histogram song("Wise men say, \nonly fools rush in But I can't help,\n");
    song << "falling" << " in love with you." << "-by";
    song << 'k' << 'i' << 't';
    song.makeHisto();
    !song;
    return 0;
}