import sys
input = sys.stdin.readline
MOD = 1000000007

K, P, N = map(int, input().split()) # 처음 바이러스 수, 증가율, 총 시간

N = (N*10)

def DivideAndConquer(p, n):
    if n == 0:
        return 1

    if n%2 == 1:
        return p * (DivideAndConquer(p, n-1)) % MOD

    else:
        half = (DivideAndConquer(p, n//2)) % MOD
        return half * half % MOD

print((K * DivideAndConquer(P, N)) % MOD)