import sys

def makeSieve(n):
    sqrt = int(n**(0.5))
    temp = [1] * (n + 1)
    for i in range(2, sqrt+1):
        if temp[i] == 1:
            for j in range(i*2, n+1, i):
                temp[j] = 0

    return [i for i in range(2, n+1) if temp[i] == 1]

def solve():
    answer = 0
    input = sys.stdin.readline
    N = int(input())
    primes = makeSieve(N)

    start = 0
    end = 0
    while end < len(primes):
        if sum(primes[start:end+1]) == N:
            answer += 1
            end += 1
        elif sum(primes[start:end+1]) > N:
            start += 1
        elif sum(primes[start:end+1]) < N:
            end += 1
    print(answer)

if __name__ == "__main__":
    solve()



