import sys
input = sys.stdin.readline
#print = sys.stdout.write
MOD = 1000000007

K, P, N = map(int, input().split()) # 처음 바이러스 수, 증가율, 총 시간

K %= MOD
P %= MOD
N %= (N*10)

def DivideAndConquer(p, n):
    if p == 0:
        return 1

    if p%2 == 1:
        return p * (DivideAndConquer(p-1, n) % MOD)

    else:
        half = (DivideAndConquer(p//2, n) % MOD)
        return half * half % MOD

print((k * DivideAndConquer(P, N)) % MOD)