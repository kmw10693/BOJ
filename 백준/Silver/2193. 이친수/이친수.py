n = int(input())

data = [0] * 95

data[1] = 1
data[2] = 1
data[3] = 2
data[4] = 3
data[5] =  5
data[6] = 9
data[7] = 13

for i in range(5, n+1):
    data[i] = data[i-1] + data[i-2] 
print(data[n])