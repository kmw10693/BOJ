#include <bits/stdc++.h>
using namespace std;

int arr[10] = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

bool check = false;
int N;
void bfs(int cnt, vector<int> v) {
    if(cnt == 6 && check == false) {
        int a1 = 10*v[0] + v[1];
        int a2 = 10*v[2] + v[3];
        int sum = 10*v[4] + v[5];
        
        if(a1 + a2 != sum || arr[v[0]] + arr[v[1]] + arr[v[2]] + arr[v[3]] + arr[v[4]] + arr[v[5]] != N-4) return;
        
        if(a1 + a2 == sum && arr[v[0]] + arr[v[1]] + arr[v[2]] + arr[v[3]] + arr[v[4]] + arr[v[5]] == N-4) {
            cout << v[0] << v[1] << '+' << v[2] << v[3] << '=' << v[4] << v[5];
            check = true;
            return;
        }
    }
    if(cnt >= 6) return;
    
    for(int i=0; i<10; i++) {
        v.push_back(i);
        bfs(cnt+1, v);
        v.pop_back();
    }
}

int main() {
    cin >> N;
    vector<int> v;
    bfs(0, v);
    if(!check) {
        cout << "impossible";
    }
}