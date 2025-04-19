#include <bits/stdc++.h>
using namespace std;

int maxV = -0x7f7f7f7f;
int minV = 0x7f7f7f7f;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    cin >> n;
    
    vector<int> v;
    for(int i=0; i<n; i++) {
        int a; cin >> a;
        v.push_back(a);
    }
    
    // 연산자 덧셈 1, 뺄셈 2, 나눗셈 3, 곱셈 4
    vector<int> op;
    for(int i=0; i<4; i++) {
        int v; cin >> v;
        for(int j=0; j<v; j++) {
            op.push_back(i+1);
        }
    }
    
    // 이제 랜덤으로 섞기 전 정렬
    sort(op.begin(), op.end());
    
    do {
        // 섞고 v 처음부터 순차적으로 계산
        int first = v[0];
        // 두번째부터 시작 0 ~ n-2 성립
        for(int i=1; i<n; i++) {
            if(op[i-1] == 1) {
                first += v[i];
            }
            else if(op[i-1] == 2) {
                first -= v[i];
            }
            else if(op[i-1] == 3) {
                first *= v[i];
            }
            else {
                first /= v[i];
            }
        }
        // 최댓값 정립
        maxV = max(maxV, first);
        minV = min(minV, first);
    } while(next_permutation(op.begin(), op.end()));
    
    cout << maxV << '\n' << minV;
}