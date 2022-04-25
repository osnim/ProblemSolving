from collections import deque
N = int(input())
datas = []
arr = [[0]*N for _ in range(N)]
#각 번호가 위치한 장소
pos = [[0, 0] for i in range(N**2)]
for i in range(N**2):
    datas.append(list(map(int, input().split())))

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

for st in range(len(datas)):
    x, y = 0, 0
    adj = 0
    empty = 0
    for i in range(N):
        for j in range(N):
            #누가 있는 경우
            if arr[i][j] != 0:
                continue
            adjTemp = 0
            empTemp = 0
            for k in range(4):
                nx, ny = i + dx[k], j + dy[k]
                if nx < 0 or nx >= N or ny < 0 or ny >= N:
                    continue
                #4 방향의 선호 친구 수
                prefer = datas[st][1:]
                if arr[nx][ny] in prefer:
                    adjTemp += 1
                # 빈칸이 많은 경우
                elif arr[nx][ny] == 0:
                    empTemp += 1
            # 선호 수 > 빈칸 > 인덱스 낮은 순

            #주위 좋아하는 애들 많고 빈칸 많을때
            if adj < adjTemp:
                adj = adjTemp
                empty = empTemp
                x, y = i, j

            elif adj == adjTemp:
                if empTemp > empty:
                    adj = adjTemp
                    empty = empTemp
                    x, y = i, j

                 # 주위에 좋아하는 애들 없고 빈칸도 없는 경우
                elif empTemp == 0 and x == 0 and y == 0 and arr[x][y] != 0:
                    x, y = i, j

    arr[x][y] = datas[st][0]

datas.sort()

ans = 0
for x in range(N):
    for y in range(N):
        num = arr[x][y]
        cnt = 0
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= N or arr[nx][ny] == 0:
                continue
            prefer = datas[num-1][1:]
            if arr[nx][ny] in prefer:
                cnt += 1

        if cnt == 0:
            continue
        ans += 10**(cnt-1)

print(ans)