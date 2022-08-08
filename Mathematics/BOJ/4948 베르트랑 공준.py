import sys
input = sys.stdin.readline

def sieve(n, N):
    arr = [1]*(N+1)
    for i in range(2, int(N**0.5)+1):
        if arr[i] == 1:
            for j in range(i+i, N+1, i):
                arr[j] = 0
    return [i for i in range(n+1, N+1) if arr[i]]

while True:
    N = int(input().strip())
    if N == 0: break
    print(len(sieve(N, 2*N)))