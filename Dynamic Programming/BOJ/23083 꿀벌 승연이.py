import sys
input = sys.stdin.readline
print = sys.stdout.write

N, M = map(int, input().split()) # 행, 열
N += 1
arr = [[1]*M for i in range(N)] #갈 수 있으면 1 없으면 0
dp = [[0]*M for i in range(N)] # 해당 좌표에 갈 수 있는 경로 개수 누적 합 저장

for j in range(1, M, 2):
    arr[0][j] = 0 # 갈 수 없음

for j in range(0, M, 2):
    arr[N-1][j] = 0 # 갈 수 없음

K = int(input()) # 구멍 개수
for _ in range(K):
    x, y = map(int, input().split()) # x행 y열
    x, y = x - 1, y - 1
    if y%2 == 0: # 짝수 열은 그대로 빈칸 표시
        arr[x][y] = 0
    else: # 홀수 열은 한 칸 아래 빈칸 표시
        arr[x+1][y] = 0

dp[0][0] = 1
for y in range(M):
    for x in range(N):
        if y%2 == 0: # 짝수 열은 오른쪽, 오른쪾 아래, 아래
            for dx, dy in (1, 0), (0, 1), (1, 1):
                nx, ny = x + dx, y + dy
                if nx < 0 or nx >= N or ny < 0 or ny >= M:
                    continue
                if arr[nx][ny] == 0:  # 못가는 곳
                    continue
                dp[nx][ny] += dp[x][y]
        else:# 홀수 열은 아래, 오른쪽 위, 오른쪽 가능
            for dx, dy in (1, 0), (0, 1), (-1, 1):
                nx, ny = x + dx, y + dy
                if nx < 0 or nx >= N or ny < 0 or ny >= M:
                    continue
                if arr[nx][ny] == 0:  # 못가는 곳
                    continue
                dp[nx][ny] += dp[x][y]

if M%2 == 1:
    print(f"{dp[N - 2][M - 1] % (int(1e9 + 7))}")
else:
    print(f"{dp[N-1][M-1]%(int(1e9+7))}")
