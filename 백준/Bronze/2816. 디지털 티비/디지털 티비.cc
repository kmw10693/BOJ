#include <bits/stdc++.h>
using namespace std;

int n;
vector<string> v;
vector<int> ans;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n;
    
    for(int i=0; i<n; i++) {
        string s;
        cin >> s;
        v.push_back(s);
    }
    
    // KBS1 부터 맨 앞으로 보내기
    int index = -1;
    for(int i=0; i<v.size(); i++) {
        if(v[i] != "KBS1") {
            ans.push_back(1);
        }
        else {
            index = i;
            break;
        }
    }
    // KBS1으로 커서 했으면 맨앞으로 옮기기
    while(index > 0) {
        string tmp = v[index];
        v[index] = v[index-1];
        v[index-1] = tmp;
        ans.push_back(4);
        index--;
    }
    
    // KBS2 부터 맨 앞으로 보내기
    index = -1;
    for(int i=0; i<v.size(); i++) {
        if(v[i] != "KBS2") {
            ans.push_back(1);
        }
        else {
            index = i;
            break;
        }
    }
    // KBS2으로 커서 했으면 맨앞으로 옮기기
    while(index > 1) {
        string tmp = v[index];
        v[index] = v[index-1];
        v[index-1] = tmp;
        ans.push_back(4);
        index--;
    }
    
    for(int i=0; i<ans.size(); i++) {
        cout << ans[i];
    }
    
}