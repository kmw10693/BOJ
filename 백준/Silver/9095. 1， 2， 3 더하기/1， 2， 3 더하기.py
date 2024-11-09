d = []
d = [''] * 100
d[1] = 1
d[2] = 2
d[3] = 4

for i in range(4, 99):
    d[i] = d[i-1] + d[i-2] + d[i-3]
    
n = int(input())
for i in range(n):
    k = int(input())
    print(d[k])

    