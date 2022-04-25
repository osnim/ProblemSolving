'''
1. 각 칸에 바구니, 바구니에 저장할 물의 양 제한 X
2. 1번행과 N 번 열이 연결되어 있음, 즉 맵 벗어나도 상관 x
3. 비바라기 > 맨 아래 1열 2열 맨 아래 위 행 1열 2열 비구름 생성
4. 비 구름을 M 번 이동, 방향 8개, 방향 d, 거리 s,
5. 방향 ←, ↖, ↑, ↗, →, ↘, ↓, ↙


1. 모든 구름 d 방향 s 칸 이동
2. 비구름 칸에 물 1씩 증가
3. 구름 모두 사라짐
4. 2에서 증가한 칸, 물 복사 버그, > 증가한 칸 기준 대각선 방향 거리가 1인 칸에 물이 있는 바구니의 수 만큼 물 증가
 물의 수 X
 a. 경계를 넘어가는 칸 X
 b.
5. 물이 2이 상인 칸 물의 양 2 감소, 구름이 생기는 칸은 3에서 구름이 사라진 칸 X

M 번 이동 후 물의 총 량
'''
from collections import deque
N, M = map(int, input().split())
arr = []
dx = [0, 0, -1, -1, -1, 0, 1, 1, 1]
dy = [0, -1, -1, 0, 1, 1, 1, 0, -1]
ans = 0
for i in range(N):
    arr.append(list(map(int, input().split())))

cloud = [[0]*N for _ in range(N)]
cloud[N-1][0] = 1
cloud[N-1][1] = 1
cloud[N-2][0] = 1
cloud[N-2][1] = 1

for _ in range(M):
    d, s = map(int, input().split())

    #구름 이동
    temp = []
    for x in range(N):
        for y in range(N):
            if cloud[x][y] == 1:
                cloud[x][y] = 0
                nx, ny = x + s * dx[d], y + s * dy[d]
                nx, ny = nx % N, ny % N
                temp.append([nx, ny])

    for [x, y] in temp:
        cloud[x][y] = 1

    # 물 증가
    basket = [[0]*N for _ in range(N)]
    for x in range(N):
        for y in range(N):
            if cloud[x][y] == 1:
                arr[x][y] += 1

    # 아 물 내리고 나서 대각선 찾기 해야함
    for x in range(N):
        for y in range(N):
            if cloud[x][y] != 1:
                continue
            cnt = 0
            for ddx, ddy in (-1, -1), (-1, 1), (1, -1), (1, 1):
                nx, ny = x + ddx, y + ddy
                if nx < 0 or nx >= N or ny < 0 or ny >= N:
                    continue
                if arr[nx][ny] > 0:
                    cnt += 1
            basket[x][y] = cnt

    #대각선 개수 만큼 물 증가
    for x in range(N):
        for y in range(N):
            # 대각선 개수 만큼 물 증가
            arr[x][y] += basket[x][y]

    for x in range(N):
        for y in range(N):
            if cloud[x][y] == 1:
                cloud[x][y] = 0

            elif arr[x][y] >= 2:
                arr[x][y] -= 2
                cloud[x][y] = 1

for i in range(N):
    for j in range(N):
        ans += arr[i][j]

print(ans)