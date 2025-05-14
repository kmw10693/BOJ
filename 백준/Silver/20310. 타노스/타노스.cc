#include <bits/stdc++.h>

using namespace std;

int zero, one;
int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    string s;
    cin >> s;
    
    for(int i=0; i<s.size(); i++) {
        if(s[i] == '1') one++;
        else zero++;
    }
    
    int dst_one = one /2;
    int dst_zero = zero/2;
    
    while(zero > dst_zero) {
        int idx = s.rfind('0');
        if(idx != string::npos) {
            s.erase(idx, 1);
            zero--;
        }
    }
    
    while(one > dst_one) {
        int idx = s.find('1');
        if(idx != string::npos) {
            s.erase(idx, 1);
            one--;
        }
    }
    cout << s;
}