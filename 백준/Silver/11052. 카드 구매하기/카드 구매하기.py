import sys
input = sys.stdin.readline
n = int(input())
arr = list(map(int, input().split()))
arr.insert(0,0)
dp = [0 for _ in range(n+1)]

for i in range(1, n+1):
    for j in range(1, i+1):
        dp[i] = max(dp[i], dp[i-j] + arr[j])

print(dp[n])