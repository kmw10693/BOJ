#include <bits/stdc++.h>
using namespace std;

int N;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    // 시뮬레이션 
    vector<int> v;
    cin >> N;
    for(int i=0; i<N; i++) {
        int p; cin >> p;
        v.push_back(p);
    }
    
    // 가장 큰 값부터 터뜨리기 (그리디) 시간 복잡도, N*logN + N
    
    //정답 벡터
    vector<int> ans;
    int cnt = 0;
    while(true) {
        // 최댓값 및 인덱스 가져오기
        int max = -1;
        int index = 0;
        for(int i=0; i<N; i++) {
            if(max < v[i]) {
                max = v[i];
                index = i;
            }
        }
        // max가 -1이면 모두 제거된 것이므로 종료
        if(max == -1) break;
        
        ans.push_back(index);
        // 최댓값 기준으로 옆에 지우기 인덱스 기준 양 옆 지우기
        // 초기값 max로 설정 하고 지울때마다 갱신 폭탄도 터뜨리기
        int tmp = max;
        v[index] = -1;
        for(int i=index-1; i>=0; i--) {
            // 폭탄 붐
            if(v[i] < tmp && v[i] != -1) {
                tmp = v[i];
                v[i] = -1;
            }
            // 폭탄 안터지면 종료해야 함.
            else break;
        }
        
        tmp = max;
        for(int i=index+1; i<N; i++) {
            if(v[i] < tmp && v[i] != -1) {
                tmp = v[i];
                v[i] = -1;
            }
            else break;
        }
    }

    sort(ans.begin(), ans.end());
    for(int i=0; i<ans.size(); i++) {
        cout << ans[i] +1 << '\n';
    }
}