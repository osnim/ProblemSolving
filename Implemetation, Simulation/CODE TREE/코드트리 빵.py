from collections import deque
import heapq as hq
class User:
    def __init__(self, cur_r, cur_c, nxt_r, nxt_c, con_r, con_c, m):
        self.cur_r = cur_r
        self.cur_c = cur_c
        self.nxt_r = nxt_r
        self.nxt_c = nxt_c
        self.con_r = con_r  # 도착점, 편의점
        self.con_c = con_c
        self.m = m #베이스 캠프 출발 시각

    def __str__(self):
        return f" 현재 = {self.cur_r}, c = {self.cur_c}\n "  \
               f" t = {self.m}\n " \
               f" 다음 = {self.nxt_r}, {self.nxt_c}\n" \
               f" 도착 = {self.con_r}, {self.con_c}\n"

n, m = map(int, input().split()) # 격자의 크기, 사람의 수
campMap = []
UserList = deque([])
t = 1
inMatrixQueue = deque([])
reachQueue = deque([]) # 도착한 사람들 모임

for i in range(n):
    campMap.append(list(map(int, input().split())))

for i in range(1, m+1): # 가고자 하는 편의점의 위치
    x, y = map(int, input().split())
    UserList.append(User(-1, -1, -1, -1, x-1, y-1, i)) #현재, 다음 칸, 편의점

def findCampBFS(user):
    visited = [[False] * n for _ in range(n)]
    q = []
    hq.heappush(q, [0, user.con_r, user.con_c])

    while (q):
        cnt, r, c = hq.heappop(q)
        if campMap[r][c] == 1:  # 가장 가까운 베이스 찾음
            user.cur_r = r # 시작점
            user.cur_c = c #
            campMap[r][c] = -user.m # 음수로 번호 표시
            return user

        # 행이 작은 순서 > 열이 작은 순서
        for (dr, dc) in (-1, 0), (0, -1), (0, 1), (1, 0):  # 일단 상 좌 우 하
            nr, nc = r + dr, c + dc
            if nr < 0 or nr >= n or nc < 0 or nc >= n:
                continue
            if visited[nr][nc]:
                continue
            if not(campMap[nr][nc] == 0 or campMap[nr][nc] == 1):  # 갈 수 없는 곳
                continue
            visited[nr][nc] = True
            hq.heappush(q, [cnt+1, nr, nc])

def findStoreBFS(user):
    visited = [[0] * n for _ in range(n)]
    q = []
    r, c = user.cur_r, user.cur_c

    #user의 다음 시작위치를 정하기 위해 1칸씩만 이동
    for (dr, dc) in (-1, 0), (0, -1), (0, 1), (1, 0):  # 일단 상 좌 우 하
        nr, nc = r + dr, c + dc
        if nr < 0 or nr >= n or nc < 0 or nc >= n:
            continue
        if visited[nr][nc] != 0:
            continue
        if not (campMap[nr][nc] == 0 or campMap[nr][nc] == 1):  # 갈 수 없는 곳
            continue
        visited[nr][nc] = user.m
        hq.heappush(q, [1, nr, nc, nr, nc])

    while(q):
        cnt, r, c, nxt_r, nxt_c = hq.heappop(q)
        if r == user.con_r and c == user.con_c: # 편의점 찾음
            if r == nxt_r and c == nxt_c: # 다음 한 칸이 편의점인 경우
                return True
            else: # 편의점 방향으로 한 칸 이동
                user.cur_r = nxt_r
                user.cur_c = nxt_c
                return False

        for (dr, dc) in (-1, 0), (0, -1), (0, 1), (1, 0):  # 일단 상 좌 우 하
            nr, nc = r + dr, c + dc
            if nr < 0 or nr >= n or nc < 0 or nc >= n:
                continue
            if visited[nr][nc] != 0:
                continue
            if not (campMap[nr][nc] == 0 or campMap[nr][nc] == 1):  # 갈 수 없는 곳
                continue
            hq.heappush(q, [cnt+1, nr, nc, nxt_r, nxt_c])
            visited[nr][nc] = user.m

    return exit(-1)

def step1(q):
    size = len(q)
    for i in range(size):
        user = q.popleft()
        if(findStoreBFS(user)): #편의점에 도착한 경우
            reachQueue.append(user)
            continue
        q.append(user)

    return reachQueue

def step2():
    global m
    while(reachQueue):
        user = reachQueue.popleft()
        campMap[user.con_r][user.con_c] = user.m+60 # m이 도착한 편의점 표시
        m -= 1
    return

def step3(user):
    return findCampBFS(user)

#시뮬 시작
while(True):
    # 도착한 편의점이나 출발한 적 있는 캠프는 못 지나감

    # 1.
    # 격자에 있는 사람들이 먼저 최단거리로 움직임, 최단거리가 여러 개 > 상 좌 우 하
    # 인접칸이라 하면 상하좌우 이동공간 중 갈 수 있는 공간, 누가 있으면 뚫고 못 감

    step1(inMatrixQueue)

    # 2.
    # 해당 편의점 도착 멈춤 > 다른 사람은 해당 편의점 칸 못 지나감
    step2()

    # 3.
    # t <= m 이면 편의점과 가장 가까운 베이스캠프 감 > 여러가지인 경우: 행이 작은, 열이 작은 순서,
    # T번 사람이 베이스 캠프로 이동하는데 시간 소요 x
    # 사람이 있는 캠프는 다른 사람이 못지나감,
    if(UserList):
        newUser = step3(UserList.popleft())
        inMatrixQueue.append(newUser)

    if (m == 0):
        print(t)
        break
    t += 1