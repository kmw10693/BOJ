import sys
input = sys.stdin.readline

n, m = map(int, input().split())

jadu = [0] + [int(input()) for _ in range(n)]
dp = [[0]*(m+1) for _ in range(n+1)]


dp[1][0] = jadu[1] % 2 
dp[1][1] = jadu[1] // 2

for i in range(2, n+1):
    for j in range(m+1):
        t = 0
        if j%2 == 0:
            t = jadu[i] % 2
        else:
            t = jadu[i] // 2
        dp[i][j] = max(dp[i-1][0:j+1]) + t

print(max(dp[-1]))