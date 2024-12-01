import sys
input = sys.stdin.readline

n = int(input())

dp = [0] * 100005

dp[1] = 1
dp[2] = 2
dp[3] = 3
for i in range(4, n+1):
    dp[i] = i
    
for i in range(1, n+1):
    for j in range(1, i):
        if j*j > i:
            break
        dp[i] = min(dp[i], dp[i-j*j] + 1)

print(dp[n])
    