for T in range(int(input())):
    N, K = map(int, input().split())
    arr = []
    ans = 0
    for _ in range(N):
        arr.append(list(map(int, input().split())))

    for i in range(N):
        cnt = 0
        for j in range(N):
            if arr[i][j]:
                cnt += 1
            else:
                if cnt == K:
                    ans += 1
                cnt = 0
        if cnt == K:
            ans += 1

    for j in range(N):
        cnt = 0
        for i in range(N):
            if arr[i][j]:
                cnt += 1
            else:
                if cnt == K:
                    ans += 1
                cnt = 0
        if cnt == K:
            ans += 1
    print(f'#{T+1} {ans}')
