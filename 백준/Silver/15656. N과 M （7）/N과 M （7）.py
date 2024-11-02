n,m = map(int, input().split())
listk = list(map(int, input().split()))
listk.sort()
listt = [False] * 20
lista = [''] * 20

def cur(k):
    if(k == m):
        for i in range(k):
            print(lista[i], end=' ')
        print()
    else:
        for i in range(n):
            lista[k] = listk[i]
            cur(k+1)

cur(0)