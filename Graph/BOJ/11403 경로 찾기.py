def floydWarshall():
    for k in range(N): # 거쳐가는 노드
        for i in range(N): #출발 노드
            for j in range(N): # 도착 노드
                if arr[i][k] + arr[k][j] < arr[i][j]:
                    arr[i][j] = 1

    for i in range(N):  # 출발 노드
        for j in range(N):  # 도착 노드
            if arr[i][j] == INF:
                arr[i][j] = 0

    for i in range(N):
        print(*arr[i])

N = int(input())
arr = []
INF = int(10e9)
for i in range(N):
    data = list(map(int, input().split()))
    for j, num in enumerate(data):
        if num == 0:
            data[j] = INF
    arr.append(data)

floydWarshall()
