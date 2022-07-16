for T in range(int(input())):
    N = int(input())
    arr = []
    answer = ["" for _ in range(N)]
    for _ in range(N):
        arr.append(list(map(int, input().split())))

    def rotate(arr):
        temp = [[0]*N for _ in range(N)]
        for i in range(N):
            for j in range(N):
                temp[i][j] = arr[N-1-j][i]

        return temp

    for _ in range(3):
        arr = rotate(arr)
        for i in range(N):
            for j in range(N):
                answer[i] += str(arr[i][j])
            answer[i] += " "

    print(f"#{T+1}")
    for i in range(N):
        print(answer[i])