#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    cin >> n;
    
    priority_queue<int> maxHeap;
    priority_queue<int, vector<int>, greater<int>> minHeap;
    
    while(n--) {
        int a;
        cin >> a;
        
        if(maxHeap.size() <= minHeap.size()) {
            maxHeap.push(a);
        }
        else {
            minHeap.push(a);
        }
        
        if(!minHeap.empty() && maxHeap.top() > minHeap.top()) {
            minHeap.push(maxHeap.top());
            maxHeap.pop();
            maxHeap.push(minHeap.top());
            minHeap.pop();
        }
        cout << maxHeap.top() << '\n';
    }
}