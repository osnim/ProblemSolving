for T in range(int(input())):
    N, M = map(int, input().split())
    arr = []
    for _ in range(N):
        arr.append(list(map(int, input().split())))

    ans = 0
    for i in range(N-M+1):
        for j in range(N-M+1):
            temp = 0
            for x in range(M):
                for y in range(M):
                    temp += arr[i+x][j+y]
            ans = max(temp, ans)
    
    print(f"#{T+1} {ans}")