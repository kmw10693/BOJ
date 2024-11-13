n = int(input())
p = [0] * 105

p[1] = 1
p[2] = 1
p[3] = 1
for i in range(4, 105):
    p[i] = p[i-2] + p[i-3]
    
for i in range(n):
    k = int(input())
    print(p[k])