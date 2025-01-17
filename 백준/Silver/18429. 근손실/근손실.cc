#include <bits/stdc++.h>

using namespace std;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int N, K;
    cin >> N >> K;
    
    vector<int> v;
    vector<int> temp;
    for(int i=0; i<N; i++){
        int t; 
        cin >> t;
        v.push_back(t);
        temp.push_back(i);
    }
    int ans = 0;
    sort(temp.begin(), temp.end());
    
    do{
        int tempA = 0;
        int b =500;
        for(int i=0; i<temp.size(); i++) {
               b += (v[temp[i]] - K);
               if(b < 500) tempA = -1;
        }
        if(tempA == 0) ans++;
    } while(next_permutation(temp.begin(), temp.end()));
    
    cout << ans;
}