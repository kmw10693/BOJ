#include <string>
#include <vector>

using namespace std;

vector<vector<int>> v;
vector<int> ans;

void bfs(int x, int y, int size) { // 0 2 2
    int zero = 0;
    int one = 0;
    for(int i=x; i<x+size; i++) { // 0~1
        for(int j=y; j<y+size; j++) { // 2~3
            if(v[i][j] == 0) zero++;
            else if(v[i][j] == 1) one++;
        }
    }
    if(one == 0 && zero > 0) {
        ans[0] += 1;
        return;
    }
    
    if(zero == 0 && one > 0) {
        ans[1] += 1;
        return;
    }

    bfs(x, y, size/2); //0, 0, 2
    bfs(x, y + size/2, size/2); //0, 2, 2
    bfs(x + size/2, y, size/2); // 2 0 2
    bfs(x + size/2, y + size/2, size/2); // 2 2 2
}

vector<int> solution(vector<vector<int>> arr) {
    v = arr;
    ans.push_back(0); // 0이 0개
    ans.push_back(0); // 1이 0개
    bfs(0, 0, arr.size()); // 0 0 4
    return ans;
}