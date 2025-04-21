#include <bits/stdc++.h>
using namespace std;

int N,K;

// 이미 사용중인것을 저장할 배열
bool visited[105];

// 정답
int ans;

// 꽂힌 플러그 중 가장 나중에 뽑힐 플러그롤 먼저 뽑는다.
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N >> K;
    
    // 우선순위 저장할 플러그
    vector<int> v;
    // 멀티탭
    vector<int> multi;
    
    for(int i=0; i<K; i++) {
        int t; cin >> t;
        v.push_back(t);
    }
    
    // K번 반복
    for(int i=0; i<K; i++) {
        // 우선순위 가져오기
        int tmp = v[i];
        // 플러그가 비었다면? 걍 넣기
        if(multi.size() < N && !visited[tmp]) {
            // 남은 플러그 인덱스에 넣기
            multi.push_back(tmp);
            visited[tmp] = true;
            continue;
        }
        
        // 이미 꼽혀있으면 넘어가자
        if(visited[tmp]) continue;
        
        // 플러그가 안비었다면, 가장 나중에 사용될 플러그 먼저 뽑기!
        // 모든 플러그에 대해 count로 검사해서, 멀리 떨어진거 찾기
        int count = 0;
        // 가장 멀리떨어진 인덱스
        // 플러그에서 가장 멀리떨어진 인덱스의 값을 가진 놈 제거
        int index = 0;
        for(int j=0; j<N; j++) {
             //현재 인덱스가 i니, i+1부터 검사하면 됨!
            int tmpCount = 0;
            for(int k=i+1; k<K; k++) {
                // 먼저 플러그인 찾았으면
                if(multi[j] == v[k]) {
                    break;
                }
                tmpCount++;
            }
            if(count < tmpCount) {
                index = j;
                count = tmpCount;
            }
        }
        
        // 기존 플러그놈 제거
        visited[multi[index]] = false;
        // 인덱스랑 바꾸기 i는 검사 안해도 되나?
        // 어차피 i는 검사 안해도 될듯
        multi[index] = tmp;
        visited[multi[index]] = true;
        ans++;
    }
    // 왜 이거 3 이 나옴?
    cout << ans;
    
}