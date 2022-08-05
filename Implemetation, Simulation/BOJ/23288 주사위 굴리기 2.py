'''
1. NxM, 오른쪽 동쪽, 위쪽 북쪽, 주사위 각 면 1~6, 전개도
2. 전개도
  2
4 1 3
  5
  6
3. 지도 윗 면 1, 동쪽을 바라보는 방향이 3 인 상태, 지도와 맞닿은 부분 6
4. 가장 처음 주사위 이동 방향 : 동쪽

주사위 이동 방식
1. 이동방향으로 한칸 구름, 칸이 없다면 반대방향으로 한 칸 구름
2. 도착한 칸 점수 획득
3. 주사위 아랫 면 숫자와 arr[i][j]를 비교
   주사위 아랫 면 > arr[i][j] : 이동 방향 시계 방향 90도 회전
   주사위 아랫 면 < arr[i][j] : 이동 방향 반시계 방향 90도 회전
   A = B 이동방향 변화 X

칸에 대한 점수 획득 : arr[i][j] 숫자 B 와 동서남북 BFS로 이동 가능한 방향 중 arr[i][j]와 같은 수의 개수 = C

B*C 의 합 출력
'''

def goDice(d):
    global dice
    new = [0, 0, 0, 0, 0, 0]
    #동
    if d == 0:
       #new = [0,5,1,2,4,3]
       new = [dice[0], dice[5], dice[1], dice[2], dice[4], dice[3]]
    #남
    elif d == 1:
        #new = [5, 1, 0, 3, 2, 4]
        new = [dice[5], dice[1], dice[0], dice[3], dice[2], dice[4]]
    #서
    elif d == 2:
        # new = [0, 2, 3, 5, 4, 1]
        new = [dice[0], dice[2], dice[3], dice[5], dice[4], dice[1]]
    #북
    elif d == 3:
        #new = [2, 1, 4, 3, 5, 0]
        new = [dice[2], dice[1], dice[4], dice[3], dice[5], dice[0]]

    dice = new[:]
    return new

def BFS(x, y, num):
    q = deque([])
    visited = [[0] * M for i in range(N)]
    visited[x][y] = 1
    q.append([x, y])
    cnt = 1
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny =  x+dx[i], y+dy[i]
            if nx < 0 or nx >=N or ny < 0 or ny >= M or visited[nx][ny]:
                continue
            visited[nx][ny] = 1
            if arr[nx][ny] == num:
                q.append([nx, ny])
                cnt += 1
    return cnt

#동 남 서 북
from collections import deque
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
direction = 2
N, M, K = map(int, input().split())
arr = []
for i in range(N):
    arr.append(list(map(int, input().split())))
'''
dice = [[0, 2, 0],
        [4, 1, 3],
        [0, 5, 0],
        [0, 6, 0]]
'''
dice = [2, 4, 1, 3, 5, 6]
diceX, diceY = 0, 0 #주사위 위치
ans = 0
# 첫번째 동쪽으로
ndX, ndY = diceX + dx[direction], diceY + dy[direction]
if ndX < 0 or ndX >= N or ndY < 0 or ndY >= M:
    direction = (direction+2) % 4
    ndX, ndY = diceX + dx[direction], diceY + dy[direction]

diceX, diceY = ndX, ndY
dice = goDice(direction)

num = arr[diceX][diceY]
cnt = BFS(diceX, diceY, num)
ans += (num * cnt)
if dice[5] > arr[diceX][diceY]:
    # 시계 방향
    direction = (direction+1)%4
elif dice[5] < arr[diceX][diceY]:
    # 반시계
    direction = (direction-1)%4

for i in range(1, K):
    ndX, ndY = diceX + dx[direction], diceY + dy[direction]
    if ndX < 0 or ndX >= N or ndY < 0 or ndY >= M:
        direction = (direction + 2) % 4
        ndX, ndY = diceX + dx[direction], diceY + dy[direction]

    diceX, diceY = ndX, ndY
    dice = goDice(direction)
    num = arr[diceX][diceY]
    cnt = BFS(diceX, diceY, num)
    ans += (num * cnt)

    if dice[5] > arr[diceX][diceY]:
        # 시계 방향
        direction = (direction + 1) % 4
    elif dice[5] < arr[diceX][diceY]:
        # 반시계
        direction = (direction -1) % 4

print(ans)


