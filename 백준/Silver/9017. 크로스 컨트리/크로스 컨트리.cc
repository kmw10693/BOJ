#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    vector<pair<int,int>> v;
    
    int t;
    cin >> t;
    
    
    // O(N^2) 으로 가능
    while(t--) {
        int cnt[205] = {0};
        int score[205][2] = {0};
        int sec_cnt[205] = {0};
        
       int n; cin >> n;
       vector<int> v;
       for(int i=0; i<n; i++) {
           int idx; cin >> idx;
           v.push_back(idx);
           cnt[idx]++;
       }
       
       int score_cnt = 1;
       for(auto &V : v) {
           if(cnt[V] >= 6) {
               if(sec_cnt[V] < 4) {
                  score[V][0] += score_cnt;
               }
               else if(sec_cnt[V] == 4) {
                   score[V][1] = score_cnt;
               }
               sec_cnt[V]++;
               score_cnt++;
           }
       }
       
     
       int max = 0x7fffffff;
       int max_idx = -1;
       for(int i=1; i<205; i++) {
           if(cnt[i] >= 6) {
               if(score[i][0] < max) {
                   max = score[i][0];
                   max_idx = i;
               }
               else if(score[i][0] == max) {
                   if(score[max_idx][1] > score[i][1]) {
                       max_idx = i;
                   }
               }
           }
       }
       cout << max_idx << "\n";
       
    }
}