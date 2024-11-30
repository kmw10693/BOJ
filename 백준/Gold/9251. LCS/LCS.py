import sys
input = sys.stdin.readline

s1 = list(input().strip())
s2 = list(input().strip())


dp = [[0] * 1005 for _ in range(1005)]

for i in range(len(s1)):
    for j in range(len(s2)):
        if s1[i] == s2[j]:
            dp[i+1][j+1] = dp[i][j] + 1
        elif s1[i] != s2[j]:
            dp[i+1][j+1] = max(dp[i][j+1], dp[i+1][j])

print(dp[len(s1)][len(s2)])