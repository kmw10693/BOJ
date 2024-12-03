import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = [] 
for _ in range(n):
    arr.append(input())


dp = [[0] * (m+1) for _ in range(n+1)]


for i in range(1, n+1):
    for j in range(1, m+1):
        dp[i][j] = int(arr[i-1][j-1])
        
ans = -1
for i in range(1, n+1):
    for j in range(1, m+1):
        if dp[i][j] > 0:
            dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
        ans = max(ans, dp[i][j]) 
print(ans*ans)

