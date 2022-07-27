import sys
N, M = map(int, sys.stdin.readline().split())
fact = [1]*(N+1)

for i in range(2, N+1):
    fact[i] = i*fact[i-1]

print(fact[N] // (fact[N-M]*fact[M]))
