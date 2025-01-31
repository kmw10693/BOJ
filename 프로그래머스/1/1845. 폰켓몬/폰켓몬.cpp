#include <vector>
#include <bits/stdc++.h>

using namespace std;

int answer = 0;

map<int, int> m;
int solution(vector<int> nums)
{
    int size = nums.size();
    size /= 2;
    
    for(int i=0; i<nums.size(); i++) {
        m[nums[i]]++;
    }
    
    if(m.size() <= size) return m.size();
    else return size;
}
