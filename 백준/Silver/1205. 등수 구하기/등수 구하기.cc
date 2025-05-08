#include <bits/stdc++.h>

using namespace std;

int n,new_score, p;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n >> new_score >> p;
    
    int cnt = 0;
    vector<int> v;
    for(int i=0; i<n; i++) {
        int score; cin >> score;
        v.push_back(score);
    }
    
    int my_rank = 1;
    for(int i=0; i<n; i++) {
        if(new_score < v[i]) my_rank++;
        else if(new_score == v[i]) {}
        else break;
        cnt++;
    }
    
    if(cnt == p) {
        cout << -1;
        return 0;
    }
    if(n == 0) {
        cout << 1;
        return 0;
    }
    cout << my_rank;
}