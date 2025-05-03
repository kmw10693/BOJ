#include <bits/stdc++.h>

using namespace std;

int arr[200];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    string s;
    cin >> s;
    
    // 일단 소문자로 만들기
    for(int i=0; i<s.size(); i++) {
        s[i] = tolower(s[i]);
    }
    
    for(auto &S : s) {
        arr[S-'a']++;
    }
    
    int maxV = -0x7fffffff;
    for(int i=0; i<200; i++) {
        if(maxV < arr[i]) maxV = arr[i];
    }
    
    int cnt = 0;
    vector<char> v; 
    
    for(int i=0; i<200; i++) {
        if(maxV == arr[i]) {
            cnt++;
            v.push_back(i+'a');
        }
    }
    
    if(cnt >= 2) {
        cout << "?";
        return 0;
    }
    
    v[0] = toupper(v[0]);
    cout << v[0];
}