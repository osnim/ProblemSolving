N, K = map(int, input().split())
fact = [0] * (N+1)
fact[0] = 1
for i in range(1, N+1):
    fact[i] = i*fact[i-1]
print( (fact[N]//(fact[K] * fact[N-K]))%10007)