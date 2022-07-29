import sys

input = sys.stdin.readline
N, L = map(int, input().split())
arr = []
visited = [[0]*N for _ in range(N)]
for i in range(N):
    arr.append(list(map(int, input().split())))

def check(row):
    tempVisited = [0] * N
    for i in range(1, N):
        diff = row[i] - row[i-1]
        if abs(diff) > 1: return False
        # 증가 하는 경우
        elif diff == 1:
            # 경사로가| 밖에 나가는 경우
            # 경사로가 이미 있거나 이전이 평평하지 않은 경우(앞에 것은 신경 X)
            for j in range(L):
                if i - j - 1 < 0 or tempVisited[i-j-1] == 1 or row[i-1] != row[i-j-1]:
                    return False
                # 경사로 설치
                if row[i-j-1] == row[i-1]:
                    tempVisited[i-j-1] = 1
        #감소 하는 경우
        elif diff == -1:
            # 경사로가 밖에 나가는 경우
            # 경사로가 이미 있거나 이전이 평평하지 않은 경우(앞에 것은 신경 X)
            for j in range(L):
                if i + j >= N or tempVisited[i+j] == 1 or row[i] != row[i+j]:
                    return False
                # 경사로 설치
                if row[i] == row[i + j]:
                    tempVisited[i + j] = 1
    return True
cnt = 0
for i in range(N):
    if check(arr[i]):
        cnt += 1

arr = list(zip(*arr))

for i in range(N):
    if check(arr[i]):
        cnt += 1

print(cnt)


