#include <bits/stdc++.h>

using namespace std;

int main(){
    
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int n;
    vector<int> v;
    v.push_back(-1);

    cin >> n;
    for(int i=0; i<n; i++) {
        int swt; cin >> swt;
        v.push_back(swt);
    }
    
    int stu_num; cin >> stu_num;
    for(int i=0; i<stu_num; i++) {
        int sex, idx; 
        cin >> sex >> idx;
        
        // 남자면 배수 다 켜고 꺼야지
        if(sex == 1) {
            // 1 ~ 부터
            int basu = 1;
            while(idx * basu <= n) {
                v[idx*basu] = !v[idx*basu];
                basu++;
            }
        }
        else {
            // 좌우 대칭이니 idx 감소하면서 0 될때 ㄱㄱ
            v[idx] = !v[idx];
            int upper_idx = idx+1;
            int lower_idx = idx-1;
            while(true) {
                if(lower_idx < 1 || upper_idx > n) break;
                if(v[lower_idx] != v[upper_idx]) break;
                v[lower_idx] = !v[lower_idx];
                v[upper_idx] = !v[upper_idx];
                upper_idx += 1;
                lower_idx -= 1;
            }
        }
        
    }
    for(int i=1; i<=n; i++) {
       cout << v[i] << " ";
       if(i % 20 == 0) {
           cout << "\n";
       }
    }
    
}