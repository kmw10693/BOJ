#include <bits/stdc++.h>

using namespace std;

int n;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    
    while(n--){
        string s;
        cin >> s;
        
        bool f = true;
        int tmp = 1;
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            
            if(s[i] == 'O') {
                if(f == true) {
                    sum += tmp;
                    f = false;
                }
                else {
                    sum += (++tmp);
                }
            }
            else {
                f = true;
                tmp = 1;
            }
        }
        cout << sum << '\n';
    }
}