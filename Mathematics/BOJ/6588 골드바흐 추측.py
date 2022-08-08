import sys

sieve = [1] * 1000001
for i in range(2, 1001):
    if sieve[i] == 1:
        for j in range(i+i, 1000001, i):
            sieve[j] = 0

while True:
    N = int(sys.stdin.readline().strip())
    if N == 0:
        break
    FIND = False #찾았을 때
    for i in range(3, N+1, 2):
        if FIND:
            break
        if sieve[i] == 1 and sieve[N-i] == 1:
            FIND = True
            sys.stdout.write(f"{N} = {i} + {N-i}"+"\n")

    if not FIND:
        print("Goldbach's conjecture is wrong.")
