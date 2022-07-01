N, K = map(int, input().split())
primes = [1] * (N+1)
for i in range(2, N+1):
    if primes[i]:
        primes[i] = 0
        K -= 1
        if K == 0:
            print(i)
            break
        for j in range(i+i, N+1, i):
            if primes[j]:
                K -= 1
                primes[j] = 0
                if K == 0:
                    print(j)
                    exit()
