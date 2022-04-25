from collections import deque
N, M, K = map(int, input().split())
data = []
graph = [[deque([]) for _ in range(N)] for _ in range(N)]
pos = deque([])
dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]
for _ in range(M):
    i, j, m, s, d = map(int, input().split())
    graph[i - 1][j - 1].append([m, s, d])
    pos.append([i - 1, j - 1])

for _ in range(K):
    All = deque([])
    tempPos = []
    # 이동
    posLen= len(pos)
    for _ in range(posLen):
        x, y = pos.popleft()
        for _ in range(len(graph[x][y])):
            m, s, d = graph[x][y].popleft()
            nx, ny = x + s * (dx[d]), y + s * (dy[d])
            nx, ny = nx % N, ny % N
            All.append([nx, ny, m, s, d])
            pos.append([nx, ny])

    # 이동한 파이어 볼 한번에 옮기기
    for x, y, m, s, d in All:
        graph[x][y].append([m, s, d])

    #합치고 나누기
    for x in range(N):
        for y in range(N):
            if len(graph[x][y]) >= 2:
                ms, ss, ds = [], [], []
                tempLen = len(graph[x][y])
                for _ in range(tempLen):
                    m, s, d = graph[x][y].popleft()
                    if d % 2 == 0:
                        ds.append(0)
                    elif d % 2 == 1:
                        ds.append(1)
                    ms.append(m)
                    ss.append(s)

                updateM = sum(ms) // 5
                if updateM == 0:
                    # 나눴을 때 질량이 0인 경우 무시
                    continue
                # 방향이 전체 짝수 거나 홀수인 경우 판단
                if sum(ds) == 0 or sum(ds) == tempLen:
                    ds = [0, 2, 4, 6]
                else:
                    ds = [1, 3, 5, 7]
                updateS = sum(ss) // tempLen
                for i in range(4):
                    graph[x][y].append([updateM, updateS, ds[i]])

ans = 0
for x in range(N):
    for y in range(N):
        for l in range(len(graph[x][y])):
            ans += graph[x][y][l][0]

print(ans)
