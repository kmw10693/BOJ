import sys
input = sys.stdin.readline

n, k = map(int,input().split())

dp = [10001] * (k+1)
dp[0] = 0

arr = []
for i in range(n):
    arr.append(int(input()))

for li in arr:
    for i in range(li, k+1):
        dp[i] = min(dp[i], dp[i-li]+1)

if dp[k] == 10001:
    print(-1)
else:
    print(dp[k])