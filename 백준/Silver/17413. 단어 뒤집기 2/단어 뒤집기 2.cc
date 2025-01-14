#include <bits/stdc++.h>
using namespace std;

int main() {
    
    string s;
    stack<char> c;
    
    getline(cin, s);
    
    bool flag = false;
    for(int i=0; i<s.length(); i++) {
        
        if(s[i] == '<') {
            
            while(!c.empty()) {
                cout << c.top();
                c.pop();
            }
            
            flag = true;
            cout << s[i];
        }
        else if(s[i] == '>') {
            cout << s[i];
            flag = false;
        }
        else {
            if(flag == true) {
                cout << s[i];
            }
            
            else if(s[i] == ' ' || i == s.length() - 1) {
                if(i == s.length() - 1) cout << s[i];
                while(!c.empty()) {
                    cout << c.top();
                    c.pop();
                }
                if(s[i] == ' ') cout << s[i];
            }
            else {
                c.push(s[i]);
            }
        }
        
        
    }
}