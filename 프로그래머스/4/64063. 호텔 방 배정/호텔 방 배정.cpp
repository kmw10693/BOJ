#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

#define ll long long

unordered_map<ll, ll> room;

ll find(ll n) {
    if(room[n] == 0) return n;
    return room[n] = find(room[n]);
}

vector<ll> solution(ll k, vector<long long> room_number) {
    vector<ll> answer;
    for(int i=0; i<room_number.size(); i++) {
        ll num = room_number[i];
        if(room[num] == 0) {
            answer.push_back(num);
            room[num] = find(num+1);
        }
        else {
            ll next_num = find(num);
            answer.push_back(next_num);
            room[next_num] = find(next_num + 1);
        }
    }
    return answer;
}