for T in range(int(input())):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    ans = 0
    if N < M:
        for i in range(M-N+1):
            temp = 0
            for j in range(N):
                temp += B[i+j] * A[j]
            ans = max(temp, ans)
    else:
        for i in range(N-M+1):
            temp = 0
            for j in range(M):
                temp += A[i + j] * B[j]
            ans = max(temp, ans)

    print(f'#{T+1} {ans}')
