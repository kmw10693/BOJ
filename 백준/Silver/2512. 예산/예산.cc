#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    long long m;
    cin >> n;
    vector<long long> v(n);
    for (int i = 0; i < n; i++) {
        cin >> v[i];
    }
    cin >> m;

    sort(v.begin(), v.end());

    // 판정 함수: cap을 mid로 했을 때 총합 ≤ m 인지 여부만 리턴
    auto valid = [&](long long cap) {
        long long sum = 0;
        for (long long x : v) {
            sum += (x <= cap ? x : cap);
            if (sum > m) return false;
        }
        return true;
    };

    long long lo = 0, hi = v.back(), ans = 0;
    while (lo <= hi) {
        long long mid = (lo + hi) / 2;
        if (valid(mid)) {
            ans = mid;      // mid가 유효하면 기록
            lo  = mid + 1;  // 더 큰 값도 탐색
        } else {
            hi = mid - 1;   // mid가 너무 크면 작게 줄임
        }
    }

    cout << ans << "\n";
    return 0;
}