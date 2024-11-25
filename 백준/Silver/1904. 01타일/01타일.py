import sys
input = sys.stdin.readline

n = int(input())
d = [0] * 1000001

d[1] = 1
d[2] = 2
d[3] = 3
d[4] = 5

for i in range(5, n+1):
    d[i] = (d[i-1] + d[i-2]) % 15746
    
print(d[n] % 15746)

# 3-> 001 111 100
#