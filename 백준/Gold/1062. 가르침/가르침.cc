#include <bits/stdc++.h>
using namespace std;

int N,K;
bool visited[26];
vector<string> v;

int ans= -0x7f7f7f7f;

void backtrack(int index ,int cnt){
    // 만약 단어 다 돌았다면 
    if(cnt <= 0) {
        int tmpAns = 0;
        for(string V : v) {
            bool check = true;
            for(auto s : V) {
                if(visited[s-'a'] == false) {
                    check = false;
                    break;
                }
            }
            if(check) tmpAns++;
        }
        ans = max(ans, tmpAns);
        return;
    }
    
    // 인덱스 시작부터 
    for(int i=index; i<26; i++) {
        if(!visited[i]) {
            visited[i] = true;
            backtrack(i, cnt-1);
            visited[i] = false;
        }
    }
}

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    cin >> N >> K;
    for(int i=0; i<N; i++) {
        string s;
        cin >> s;
        v.push_back(s.substr(4, s.length()-8));
    }
    
    // 기본적으로 a n t i c 5개를 알고있음.
    if(K- 5 < 0) {
        cout << 0;
        return 0;
    }
    // 알파벳으로 visited = true
    // a b c d e f g h i j k l m n o p q r s t u v w x y z
    visited[0] = true, visited[13] = true, visited[2] = true, visited[8] = true, visited[19] = true;
    backtrack(0, K-5);
    cout << ans;
}