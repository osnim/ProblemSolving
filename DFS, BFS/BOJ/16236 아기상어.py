import sys
from collections import deque
N = int(sys.stdin.readline().rstrip())
MAP = []
shark_x, shark_y, size, eat = 0, 0, 2, 0
dx = [-1, 0, 0, 1]
dy = [0, -1, 1, 0]
time = 0
fishPositions = [[] for i in range(6+1)]
fishList = []

def BFS(shark_x, shark_y, MAP):
    visited = [[0] * N for _ in range(N)]
    minTime= int(1e9)
    global size, eat
    queue = deque([(shark_x, shark_y)])
    minDistFish = []
    while queue:
        MAP[shark_x][shark_y] = -1
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and 0 <= MAP[nx][ny] <= size and visited[nx][ny] == 0:
                visited[nx][ny] = visited[x][y] + 1 # 최단거리 기록
                # 물고기가 먹을 수 있는 것인지
                if 0 < MAP[nx][ny] < size:
                    if visited[nx][ny] <= minTime:
                        minTime = visited[nx][ny]
                        minDistFish.append([minTime, nx, ny])
                queue.append((nx, ny))
    if minDistFish:
        minDistFish.sort()
        MAP[minDistFish[0][1]][minDistFish[0][2]] = 9
        MAP[shark_x][shark_y] = 0
        shark_x, shark_y = minDistFish[0][1], minDistFish[0][2]
        return [shark_x, shark_y, minTime]
    else:
        return False

for i in range(N):
    MAP.append(list(map(int, sys.stdin.readline().split())))

#상어 위치 찾기
for i in range(N):
    for j in range(N):
        if MAP[i][j] == 9:
            shark_x, shark_y = i, j

for i in range(N):
    for j in range(N):
        if MAP[i][j] <= 6 and MAP[i][j] >= 1:
            fishPositions[MAP[i][j]].append([abs(shark_x-i)+abs(shark_y-j), i, j, MAP[i][j]])
        if MAP[i][j] == 1:
            fishList.append([abs(shark_x - i) + abs(shark_y - j), i, j, MAP[i][j]])

while fishList:
    result = BFS(shark_x, shark_y, MAP)
    if not result:
        break
    else:
        fishList.pop(0)
        eat += 1
        if eat == size:
            if size < 7:
                for i in fishPositions[size]:
                    fishList.append(i)
            size += 1
            eat = 0
        shark_x, shark_y, tempTime = result
        time += tempTime

print(time)