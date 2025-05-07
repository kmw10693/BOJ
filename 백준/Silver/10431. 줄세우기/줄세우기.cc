#include <bits/stdc++.h>
using namespace std;

int p;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> p;
    for(int i=0; i<p; i++) {
        vector<int> v;
        int t;
        cin >> t;
        
        for(int j=0; j<20; j++) {
            int tmp; cin >> tmp;
            v.push_back(tmp);
        }
        
        int sum = 0;
        // 바꿀 인덱스
        int change = -1;
        // 0은 그냥 고정
        for(int j=1; j<v.size(); j++) {
            bool isfront = false;
            // j번째에서 내 앞에 나보다 큰 학생 있는지 검사
            for(int k=0; k<j; k++) {  // 여기를 수정함
                // 나보다 크다면
                if(v[k] > v[j]) {
                    isfront = true;
                    change = k;
                    break;
                }
            }
            // 만약 내 앞에 있다면
            if(isfront) {
                // j번째 값 가져오기
                int num = v[j];
                // change 인덱스 앞에 집어넣음
                v.insert(v.begin() + change, num);
                
                // j번째 값 지우기 (기존 값)
                v.erase(v.begin() + j + 1);  // 여기를 수정함
                
                sum += abs(change - j);
            }
        }
        cout << i+1 << " " << sum << "\n";
    }
}
