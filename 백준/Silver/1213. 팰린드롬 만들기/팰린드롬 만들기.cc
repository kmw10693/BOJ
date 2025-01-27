#include <bits/stdc++.h>

using namespace std;

int alphabet[26];

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    string s;
    cin >> s;
    for(int i=0; i<s.length(); i++) {
        alphabet[s[i] - 'A']++;
    }
    
    int tmp = 0;
    int index = -1;
    for(int i=0; i<26; i++) {
        if(alphabet[i] % 2 != 0) {
            tmp++;
            index = i;
        }
    }
    
    if(tmp > 1) {
        cout << "I'm Sorry Hansoo";
        return 0;
    }
    
    string t = "";
    for(int i=0; i<26; i++) {
        int tmp = alphabet[i] / 2;
        while(tmp--) {
            t += (i + 'A');
        }
    }
    string c = "";
    if(index != -1) c += (index + 'A');
    
    string f = "";
    for(int i=t.length()-1; i>=0; i--) {
        f += t[i];
    }
    
    t += c;
    t += f;
    
    cout << t;
    
}