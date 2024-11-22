import sys
input = sys.stdin.readline

n = int(input())
m = int(input())

dp = [0] * 45
dp[0] = 1
dp[1] = 1
dp[2] = 2

vip = [0] * 45

for i in range(3, n+1):
    dp[i] = dp[i-1] + dp[i-2]
    
for i in range(1, m+1):
    vip[i] = int(input())
    
answer = 1
start = 0
end = 0
for i in range(1, m+1):
    end = vip[i]
    answer *= dp[end - start - 1]
    start = vip[i]
    
answer *= dp[n - end]
print(answer)