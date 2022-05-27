import sys
def sieve():
    temp = [1] * 10001
    for i in range(2, int(10001**0.5)+1):
        if temp[i] == 1:
            for j in range(i+i, 10001, i):
                temp[j] = 0
    return temp
input = sys.stdin.readline
T = int(input().strip())
primes = sieve()
for _ in range(T):
    N = int(input().strip())
    temp1, temp2 = 0, 0
    for i in range(2, (N+1)//2+1):
        if primes[i] and primes[N-i]:
            temp1, temp2 = i, N-i
    print(temp1, temp2)
