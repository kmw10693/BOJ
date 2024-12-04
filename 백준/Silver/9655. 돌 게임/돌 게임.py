import sys
input = sys.stdin.readline

dp = [0] * 1005
n = int(input())
dp[1] = 1
dp[2] = 0
dp[3] = 1
dp[4] = 0
dp[5] = 1
dp[6] = 0

for i in range(1, 1001):
    if i % 2 == 0:
        dp[i] = 1
    else:
        dp[i] = 0

if dp[n] == 0:
    print("SK")
else:
    print("CY")

