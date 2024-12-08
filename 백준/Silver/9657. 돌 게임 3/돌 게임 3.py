import sys
input = sys.stdin.readline

n = int(input())
dp = [0] * (10005)

dp[1] = 1
dp[2] = 0
dp[3] = 1
dp[4] = 1
dp[5] = 1
dp[6] = 1
dp[7] = 0

for i in range(8, n+1):
    x = dp[i-1]
    y = dp[i-3]
    z = dp[i-4]
    if x == 1 and y == 1 and z == 1:
        dp[i] = 0
    else:
        dp[i] = 1
        
if dp[n] == 1:
    print("SK")
else:
    print("CY")