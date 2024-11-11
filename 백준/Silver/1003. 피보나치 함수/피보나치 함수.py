import sys
n = sys.stdin.readline()
n = int(n)
fibo = [[0]*45 for _ in range(45)]

fibo[0][0] = 1
fibo[0][1] = 0
fibo[1][0] = 0
fibo[1][1] = 1

for i in range(2, 44):
    fibo[i][0] = fibo[i-1][0] + fibo[i-2][0]
    fibo[i][1] = fibo[i-1][1] + fibo[i-2][1]
    
for i in range(n):
    k = sys.stdin.readline()
    k = int(k)
    print(fibo[k][0], fibo[k][1])
    