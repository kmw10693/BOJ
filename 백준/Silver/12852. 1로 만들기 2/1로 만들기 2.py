n = int(input())

d = [0] * 1000005
pre = [0] * 1000005
d[1] = 0

for i in range(2, n+1):
    d[i] = d[i-1] + 1
    pre[i] = i-1
    if i % 2 == 0:
        if d[i] > d[i//2] + 1:
            d[i] = d[i//2] + 1
            pre[i] = i//2
    if i % 3 == 0:
        if d[i] > d[i//3] + 1:
            d[i] = d[i//3] + 1
            pre[i] = i//3
            
print(d[n])
k = n
t = 0
while(t <= d[n]):
    print(k, end = ' ')
    k = pre[k]
    t+=1
