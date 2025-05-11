#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    
    string str; cin >> str;
    
    int ptr = 0, num = 0;
    while(num++ < 50000) {
        string tmp_str = to_string(num);
        for(int i=0; i<tmp_str.length(); i++) {
            if(tmp_str[i] == str[ptr]) {
                ptr++;
            }
             if(ptr == str.length()){
                cout << num;
                return 0;
            }
        }
    }
}