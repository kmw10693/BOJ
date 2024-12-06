import sys
input = sys.stdin.readline

s = list(map(int, input().rstrip()))
n = len(s)
dp = [0] * (n + 1)

dp[0] = 1
dp[1] = 1

if s[0] == 0:
    print(0)

else:
    for k in range(1, n):
        i = k +1
        if s[k] > 0:
            dp[i] += dp[i-1]
        if 10 <= s[k] + 10 * s[k-1] <= 26:
            dp[i] += dp[i-2]
        
    print(dp[n] % 1000000)
        