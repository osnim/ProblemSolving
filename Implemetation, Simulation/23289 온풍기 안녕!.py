'''
가장 처음 온도 0, 빈칸은 온도 0
1. 집에 있는 모든 온풍기에서 바람 한번 나옴
2. 온도 조절
3. 온도가 1이상인 가장 바깥쪽 칸의 온도 1 감소
4. 초콜릿 하나 먹음
5. 모든 5번칸 온도가 K 이상이 되었는지 검사 , 모든 칸의 온도가 K 이상이면 중단, 아니면 1반복

온풍기 나오는 방향: 동서남북 중 하나
나오는 칸 바로 옆은 5 증가. 그 다음 4
(x, y) 칸 K도 증가 > (x-1, y+1), (x, y+1), (x+1, y+1) 온도도 k-1만큼 상승하게 된다

 바람이 오른쪽으로 불었을 때 어떤 칸 (x, y)에서 (x-1, y+1)로 바람이 이동할 수 있으려면,
 (x, y)와 (x-1, y) 사이에 벽이 없어야 하고, (x-1, y)와 (x-1, y+1) 사이에도 벽이 없어야 한다.
 (x, y)에서 (x, y+1)로 바람이 이동할 수 있으려면 (x, y)와 (x, y+1) 사이에 벽이 없어야 한다.
 마지막으로 (x, y)에서 (x+1, y+1)로 바람이 이동할 수 있으려면,
 (x, y)와 (x+1, y), (x+1, y)와 (x+1, y+1) 사이에 벽이 없어야 한다.

온풍기 바로 앞칸 5도 증가
(칸이 존재 안한다면 밖이라면 바람 이동 X)
어떤 칸이 바람 여러번 도착 한다 해도 1번만 증가
일부 칸 벽 존재, 온풍기 도달X
온풍기 2대 이상 존재할 수 있음 => 각각 상승한 온도 모두 합한 것이 그 칸의 최종 온도

온도 조절 과정
모든 인접 칸에 대해 온도가 높은 칸 > 낮은 칸 int((두 칸의 온도차/4))이 높은 칸에서 낮은칸 이동
벽 있으면 고려 X 온도 조절 X
모든 칸의 온도조절 동시 진행

방의 정보 R개 . i번째 줄의 j번째 정수는 (i, j)의 정보
0: 빈 칸
1: 방향이 오른쪽인 온풍기가 있음
2: 방향이 왼쪽인 온풍기가 있음
3: 방향이 위인 온풍기가 있음
4: 방향이 아래인 온풍기가 있음
5: 온도를 조사해야 하는 칸

벽의 정보 W
 x, y, t
 t = 0, (x, y)와 (x-1, y) 사이에 벽이 있는 것이고, 위쪽
 t = 1, (x, y)와 (x, y+1) 사이에 벽이 있는 것 오른쪽

구사과가 먹은 초콜릿의 개수를 출력

제한
2 ≤ R, C ≤ 20
1 ≤ K ≤ 1,000
온풍기는 하나 이상 있고, 온도를 조사해야 하는 칸도 하나 이상 있다.
0 ≤ W ≤ R×C
1 < x ≤ R, 1 ≤ y ≤ C (t = 0)
1 ≤ x ≤ R, 1 ≤ y < C (t = 1)
온풍기가 있는 칸과 바람이 나오는 방향에 있는 칸 사이에 벽이 없다.
온풍기의 바람이 나오는 방향에 있는 칸은 항상 존재 한다.
같은 벽이 두 번 이상 주어 지는 경우는 없다.
'''
from collections import deque
def blow(machines, R, C, total):
    #1: 오, 2:왼, 3:위, 4:아래
    for m in machines:
        md, mr, mc = m
        visited = diffuse(md, mr, mc)
        for i in range(R):
            for j in range(C):
                total[i][j] += visited[i][j]
    return total

def diffuse(md, mx, my):
    #x, y = mr, mc
    temp = [[0] * C for _ in range(R)]
    q = deque([])
    x, y = mx + dx[md], my + dy[md]
    temp[x][y] = 5
    q.append([x, y, 5])
    while q:
        x, y, t = q.popleft()
        if t < 1:
            return temp
        if md == 0:  # 오른쪽
            if upCh(x, y, 2):
                if rightCh(x - 1, y, md):
                    q.append([x - 1, y + 1, t - 1])
                    temp[x - 1][y + 1] = t - 1
            if rightCh(x, y, md):
                q.append([x, y + 1 , t - 1])
                temp[x][y + 1] = t - 1
            if downCh(x, y, 3):
                if rightCh(x + 1, y, md):
                    q.append([x + 1, y + 1, t - 1])
                    temp[x + 1][y + 1] = t - 1
        
        elif md == 1:  # 왼쪽
            if upCh(x, y, 2):
                if leftCh(x - 1, y, md):
                    q.append([x - 1, y - 1, t - 1])
                    temp[x - 1][y - 1] = t - 1
            if leftCh(x, y, md):
                q.append([x, y - 1, t - 1])
                temp[x][y - 1] = t - 1
            if downCh(x, y, 3):
                if leftCh(x + 1, y, md):
                    q.append([x + 1, y - 1, t - 1])
                    temp[x + 1][y - 1] = t - 1
        
        elif md == 2:
            if leftCh(x, y, 1):
                if upCh(x, y - 1, md):
                    q.append([x - 1, y - 1, t - 1])
                    temp[x - 1][y - 1] = t - 1
            if upCh(x, y, md):
                q.append([x - 1, y, t - 1])
                temp[x - 1][y] = t - 1
            if rightCh(x, y, 0):
                if upCh(x, y + 1, md):
                    q.append([x - 1, y + 1, t - 1])
                    temp[x - 1][y + 1] = t - 1
        
        elif md == 3:
            if leftCh(x, y, 1):
                if downCh(x, y - 1, md):
                    q.append([x + 1, y - 1, t - 1])
                    temp[x + 1][y - 1] = t - 1
            if downCh(x, y, md):
                q.append([x + 1, y, t - 1])
                temp[x + 1][y] = t - 1
            if rightCh(x, y, 0):
                if downCh(x, y + 1, md):
                    q.append([x + 1, y + 1, t - 1])
                    temp[x + 1][y + 1] = t - 1
    return temp

def rightCh(x, y, i):
    if wallVer[x][y] == 1:
        return False
    nx, ny = x + dx[i], y + dy[i]
    if 0 <= nx < R and 0 <= ny < C:
        return True
    return False

def leftCh(x, y, i):
    nx, ny = x + dx[i], y + dy[i]
    if 0 <= nx < R and 0 <= ny < C:
        if wallVer[nx][ny] != 1:
            return True
    return False

def upCh(x, y, i):
    if wallHori[x][y] == -1:
        return False
    nx, ny = x + dx[i], y + dy[i]
    if 0 <= nx < R and 0 <= ny < C:
        return True
    return False

def downCh(x, y, i):
    nx, ny = x + dx[i], y + dy[i]
    if 0 <= nx < R and 0 <= ny < C:
        if wallHori[nx][ny] != -1:
            return True
    return False

def adjustment(total):
    temp = [[0] * C for _ in range(R)]
    visited = [[0] * C for _ in range(R)]
    for x in range(R):
        for y in range(C):
            if rightCh(x, y, 0):
                dif = total[x][y] - total[x][y + 1]
                if dif > 0:
                    ad = dif//4
                    if ad > 0:
                        temp[x][y] -= ad
                        temp[x][y + 1] += ad

            if leftCh(x, y, 1):
                dif = total[x][y] - total[x][y - 1]
                if dif > 0:
                    ad = dif // 4
                    if ad > 0:
                        temp[x][y] -= ad
                        temp[x][y - 1] += ad

            if upCh(x, y, 2):
                dif = total[x][y] - total[x-1][y]
                if dif > 0:
                    ad = dif // 4
                    if ad > 0:
                        temp[x][y] -= ad
                        temp[x - 1][y] += ad

            if downCh(x, y, 3):
                dif = total[x][y] - total[x+1][y]
                if dif > 0:
                    ad = dif // 4
                    if ad > 0:
                        temp[x][y] -= ad
                        temp[x + 1][y] += ad
            #visited[x][y] = 1
    for x in range(R):
        for y in range(C):
            total[x][y] += temp[x][y]
    return total

def decrease(total):
    for j in range(C):
        if total[0][j] > 0:
            total[0][j] -= 1
    for j in range(C):
        if total[-1][j] > 0:
            total[R-1][j] -= 1

    for i in range(1, R-1):
        if total[i][0] > 0:
            total[i][0] -= 1
        if total[i][-1] > 0:
            total[i][-1] -= 1
    return total

if __name__=="__main__":
    chocolate = 0
    # 테스트 중단 조건 5번 위치가 K 이상
    # 1: 오, 2:왼, 3:위, 4:아래
    dx = [0, 0, -1, 1]
    dy = [1, -1, 0, 0]

    R, C, K = map(int, input().split())
    arr = []
    fivesPos = []
    wallHori = [[0] * C for i in range(R)]
    wallVer = [[0] * C for i in range(R)]
    #wallVer = [[0] * C for i in range(R)]
    machines = []
    for r in range(R):
        data = list(map(int, input().split()))
        for c in range(C):
            if data[c] == 0:
                continue
            if data[c] == 5:
                fivesPos.append([r, c])
            # 온풍기들 위치
            else:
                machines.append([data[c]-1, r, c])
                data[c] = -1
        arr.append(data)

    W = int(input())
    for _ in range(W):
        x, y, d = map(int, input().split())
        if d == 0:
            wallHori[x-1][y-1] = -1  # 위쪽
        else:
            wallVer[x-1][y-1] = 1  # 오른쪽
    loopCnt = 0
    total = [[0] * C for _ in range(R)]
    while True:
        loopCnt += 1
        total = blow(machines, R, C, total)
        total = adjustment(total)
        total = decrease(total)
        chocolate += 1
        cnt = 0
        for [x, y] in fivesPos:
            if total[x][y] >= K:
                cnt += 1

        if cnt == len(fivesPos):
            print(loopCnt)
            break

        if loopCnt > 100:
            print(101)
            break