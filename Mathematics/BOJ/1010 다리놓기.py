for _ in range(int(input())):
    N, M = map(int, input().split())
    ans = 1
    for i in range(M, M-N, -1):
        ans *= i
    for i in range(1, N+1):
        ans //= i
    print(ans)