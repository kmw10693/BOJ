#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

bool arr[105][105];

int solution(int n, vector<vector<int>> results) {
    for(int i=1; i<=n; i++) {
        fill(arr[i], arr[i] + n+1, false);
    }
    
    for(int i=0; i<results.size(); i++) {
        arr[results[i][0]][results[i][1]] = true;
    }
    
    for(int k=1; k<=n; k++) {
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++) {
                if(arr[i][k] == true && arr[k][j] == true) arr[i][j] = true;
            }
        }
    }
    
    int cnt = 0;
    int answer = 0;
    for(int i=1; i<=n; i++) {
        for(int j=1; j<=n; j++) {
            if(arr[i][j] == true || arr[j][i] == true) cnt++;
        }
        if(cnt >= n-1) answer++;
        cnt = 0;
    }
    return answer;
}