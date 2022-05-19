from collections import deque
def rotate(sx, sy, n, unit):
    #진짜 로테이션
    if unit == n:
        temp = [[0] * size for _ in range(size)]
        for i in range(n):
            for j in range(n):
                temp[sx + j][sy + n - 1 - i] = graph[sx+i][sy+j]
        for i in range(n):
            for j in range(n):
                graph[sx + i][sy + j] = temp[sx+i][sy+j]
        return

    n //= 2
    # 한번 들어갈 때 4칸씩 쪼개서 이동
    rotate(sx, sy, n, unit)
    rotate(sx + n, sy, n, unit) # 아래로 부분 격자 길이 만큼 내려간 곳이 시작 점
    rotate(sx, sy + n, n, unit)  # 우측으로 부분 격자 길이 만큼 이동한 곳이 시작 점
    rotate(sx + n, sy + n, n, unit)  # 우측으로 부분 격자 길이 만큼 이동한 곳이 시작 점
    return

# 상 하 좌 우 중 3방향이 붙어 있지 않은 경우 얼음 1 녹이기
def melt(size):
    temp = [[0] * size for _ in range(size)]
    global graph
    for x in range(size):
        for y in range(size):
            cnt = 0 # 주위 얼음의 개수
            for dx, dy in (-1, 0), (0, 1), (1, 0), (0, -1):
                nx, ny = x + dx, y + dy
                if nx < 0 or nx >= size or ny < 0 or ny >= size:
                    continue
                if graph[nx][ny] == 0:
                    continue
                cnt += 1
            if cnt >= 3 or graph[x][y] == 0: # 0 인 부분은 -1해서 음수 되면 안됨
                temp[x][y] = graph[x][y]
            else:
                temp[x][y] = graph[x][y] - 1

    graph = [i[:] for i in temp]
    return


N, Q = map(int, input().split())
size = (1 << N)
graph = []

for i in range(size):
    graph.append(list(map(int, input().split())))
ls = list(map(int, input().split()))

for l in ls:
    if l > 0:
        rotate(0, 0, size, 1 << l)
    melt(size)


# BFS()
total = 0  # 전체 얼음의 양
maxSize = 0  # 제일 큰 덩어리 칸의 개수
visited = [[0] * size for _ in range(size)]

for i in range(size):
    for j in range(size):
        curSize = 0
        if not visited[i][j] and graph[i][j] > 0:
            # total += graph[i][j]
            q = deque([])
            q.append([i, j])
            visited[i][j] = 1
            while q:
                x, y = q.popleft()
                total += graph[x][y]
                curSize += 1
                for dx, dy in (-1, 0), (0, 1), (1, 0), (0, -1):
                    nx, ny = x + dx, y + dy
                    if nx < 0 or nx >= size or ny < 0 or ny >= size:
                        continue
                    if graph[nx][ny] == 0 or visited[nx][ny]:
                        continue
                    q.append([nx, ny])
                    visited[nx][ny] = 1

        maxSize = max(maxSize, curSize)

print(total)
print(maxSize)





