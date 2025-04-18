// 슬라이딩 윈도우 O(N)
#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int N,X; cin >> N >> X;
    
    vector<int> arr;
    vector<int> window(N-X+1, 0);
    
    for(int i=0; i<N; i++) {
        int t; cin >> t;
        arr.push_back(t);
    }
    
    // 윈도우 인덱스 0 초기화
    for(int i=0; i<X; i++){
        window[0] += arr[i];
    }
    
    // 슬라이딩 윈도우
    for(int i=1; i<N-X+1; i++) {
        window[i] = window[i-1] - arr[i-1] + arr[i+X-1];
    }
    
    // 윈도우에서 최댓값 찾기
    int maxV = *max_element(window.begin(), window.end());
    
    if(maxV == 0) {
        cout << "SAD";
        return 0;
    }
    
    cout << maxV << '\n';
    cout << count(window.begin(), window.end(), maxV);
}