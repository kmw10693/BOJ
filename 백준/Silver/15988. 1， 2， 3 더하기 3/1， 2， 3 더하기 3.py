import sys
input = sys.stdin.readline

n = int(input())

d =  [0] * 1000005
d[1] = 1
d[2] = 2
d[3] = 4

    
for i in range(n):
    t = int(input())
    for i in range(4, t+1):
        d[i] = (d[i-1] + d[i-2] + d[i-3]) % 1000000009
    print(d[t])
    
