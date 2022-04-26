"""
어항 물고기 1마리 이상, 배열 물고기 수
어항을 한번 정리하는 과정

2. 어항 쌓기
    가장 왼쪾에 있는 어항을 그 오른쪽 어항 위에 올려 놓음
    2개 이상 쌓인 어항, 90도 시계방향 회전, 바닥 왼쪽 어항위에 공중부양된 어항중 가장 왼쪽에 있는 어항 존재
위 2 번 과정을 공중부양 시킨 어항중 가장 오른 쪽에 있는 어항의 아래 바닥에 있는 어항이 있을 때 까지

3. 물고기 수 조절
    d = (모든 인접한 두 어항 차이) // 5
    d > 0:
        두 어항 중 물고기 많은 곳에 있는 d마리 물고기 > 적은곳
        이 과정 모든 인접한 칸에 대해 동시 발생

4. 2 번 과정 다시
"""

def fillFish(fishes, N):
    # 물고기 수 가장 적은 어항에 물고기 한마리 넣음
    # if 여러개 >
    #  모두 1마리 넣음
    minCnt = min(fishes)
    for i in range(N):
        if fishes[i] == minCnt:
            fishes[i] += 1
    return fishes

def stackBowl1(fishes, N):
    '''
    2. 어항 쌓기
    가장 왼쪽에 있는 어항을 그 오른쪽 어항 위에 올려 놓음
        2개 이상 쌓인 어항, 90도 시계방향 회전, 바닥 왼쪽 어항위에 공중부양된 어항 중
        가장 왼쪽에 있는 어항 존재

        위 2 번 과정을 공중부양 시킨 어항 중
        가장 오른쪽에 있는 어항의 아래 바닥에 있는 어항이 있을 때 까지
    :return:
    '''

    # 처음 회전 부분
    bowl = fishes[:]
    rot = [[bowl[0]], [bowl[1]]]
    # 앞에서 부터 h 만큼 잘라내기
    bowl = bowl[2:]

    # 첫번째 회전 이후
    while True:
        h = len(rot) # 높이
        w = len(rot[0]) # 밑변
        # 남은 길이 - 높이 >= 0
        if len(bowl) - h >= 0:
            # 회전 == 떼어내서 회전 >
            # 회전 배열 배열 > 밑변 높이 바뀜
            temp = [[0] * h for _ in range(w)]
            for i in range(0, w):
                for j in range(h):
                    temp[i][j] = rot[h - 1 - j][i]
            # 밑에 넣기
            rot = temp + [bowl[:h]]
            # 앞에서 부터 h 만큼 잘라내기
            bowl = bowl[h:]
        else:
            rot[-1] = rot[-1] + bowl
            break

    # 사각 행렬 만들게 -1 붙임 # 불가능한 곳
    for i in range(len(rot)-1):
        rot[i].extend([-1] * (len(rot[-1])-len(rot[i])))
    '''
     d = (모든 인접한 두 어항 차이) // 5
        d > 0:
        두 어항 중 물고기 많은 곳에 있는 d마리 물고기 > 적은곳
        이 과정 모든 인접한 칸에 대해 동시 발생
    '''
    #temp = [i[:] for i in rot]
    r = len(rot)
    c = len(rot[-1])
    #temp = [[[0, False] for _ in range(len(rot[h-1]))] for _ in range(h)]
    temp = [[0]*c for _ in range(r)]

    for x in range(len(rot)):
        for y in range(len(rot[x])):
            for i in range(4):
                nx, ny = x + dx[i], y + dy[i]
                if nx < 0 or nx >= len(rot) or ny < 0 or ny >= len(rot[x]):
                    continue
                if rot[nx][ny] == -1:
                    continue
                d = (rot[x][y] - rot[nx][ny])// 5
                if d > 0:
                    if rot[x][y] < rot[nx][ny]:
                        #temp[x][y] = [temp[x][y][0] + d, True]
                        #temp[nx][ny] = [temp[nx][ny][0] - d, True]
                        temp[x][y] += d
                        temp[nx][ny] -= d
                    elif rot[nx][ny] < rot[x][y]:
                        #temp[nx][ny] = [temp[nx][ny][0] + d, True]
                        #temp[x][y] = [temp[x][y][0] - d, True]
                        temp[nx][ny] += d
                        temp[x][y] -= d

    #rot = [i[:] for i in temp]
   # return rot

    for i in range(r):
        for j in range(c):
            if rot[i][j] != -1:
                rot[i][j] += temp[i][j]

    # 한 줄로 만들기
    '''
        어항 다시 일렬로
        가장 왼쪽에 있는 어항부터, 가장 아래쪽에 있는 어항 순
        '''
    #r = len(temp[0])
    cnt = 0
    bowl = []

    for c in range(len(rot[0])):
        for r in range(len(rot)-1, -1, -1):
           #값을 변경했을 때만
           if rot[r][c] != -1:
               bowl.append(rot[r][c])

    fishes = bowl[:]
    return fishes

def makeArow(rot, fishes, N):
    return


def stackBowl2(fishes, N):
    """
    가운데를 중심으로  N/2개를 공중 부양시켜 전체를 시계 방향으로 180도 회전 시킨 다음, 오른쪽 N/2개
    두 번 반복
    두 번 반복 하면 바닥에 있는 어항의 수는 N/4개
    """

    #left = fishes[:N//2]
    left = list(reversed(fishes[:(N//2)]))
    #left.reverse()
    right = fishes[N//2:]
    stackbowl = [left] + [right]

    left = [[0]*(N//4) for _ in range(2)]
    right = [[0]*(N//4) for _ in range(2)]
    for i in range(2):
        for j in range(N//2):
            if j < N//4:
                left[i][j] = stackbowl[i][j]
            else:
                right[i][j-(N//4)] = stackbowl[i][j]
    pass
    # left만 180도 회전
    left = list(reversed(left))
    leftup = list(reversed(left[0]))
    leftdown = list(reversed(left[1]))
    left =  [leftup] + [leftdown]
    stackbowl = left + right

    r = 4
    c = N//4
    temp = [[0]*c for _ in range(r)]
    #temp = [i[:] for i in stackbowl]
    for x in range(r):
        for y in range(c):
            for i in range(4):
                nx, ny = x + dx[i], y + dy[i]
                if nx < 0 or nx >= r or ny < 0 or ny >= c:
                    continue
                d = (stackbowl[x][y] - stackbowl[nx][ny])// 5
                if d > 0:
                    if stackbowl[x][y] < stackbowl[nx][ny]:
                        temp[x][y] += d
                        temp[nx][ny] -= d
                    elif stackbowl[nx][ny] < stackbowl[x][y]:
                        temp[nx][ny] += d
                        temp[x][y] -= d

    for x in range(r):
        for y in range(c):
            stackbowl[x][y]+= temp[x][y]
    bowl = []
    for c in range(N//4):
        for r in range(3, -1, -1):
            bowl.append(stackbowl[r][c])
    fishes = bowl[:]
    return fishes

def solve(fishes, N):
    fishes = fillFish(fishes, N)
    fishes = stackBowl1(fishes, N)
    #makeArow(rot, fishes, N)
    fishes = stackBowl2(fishes, N)

    """ 
    물고기가 가장 많이 들어있는 어항과 가장 적게 들어있는 어항의 물고기 수 차이가 K 이하가 되려면 
    어항을 몇 번 정리해야하는지 구해보자.
    """
    return fishes
if __name__ == "__main__":
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    N, K = map(int, input().split())
    fishes = list(map(int, input().split()))
    op = 0
    while max(fishes) - min(fishes) > K:
        op += 1
        fishes = solve(fishes, N)
    print(op)



