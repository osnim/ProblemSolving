import sys

def updateVisit(r, c, n):
    global checkCnt
    for i in range(n):
        for j in range(n):
            visited[r + i][c + j] = n
            checkCnt += 1
    return

def undoVisit(r, c, n):
    global checkCnt
    for i in range(n):
        for j in range(n):
            visited[r + i][c + j] = 0
            checkCnt -= 1

def check(r, c, n):
    for i in range(n):
        for j in range(n):
            if r+i >= 10 or c+j >= 10:
                return False
            if matrix[r+i][c+j] == 0 or visited[r+i][c+j] > 0:
                return False
    return True

def dfs():
    global answer

    if checkCnt == totalCnt:
        #print(count)
        answer = min(answer, sum(count))
        return

    for i in range(10):
        for j in range(10):
            if visited[i][j] > 0:
                continue
            if matrix[i][j] == 1:
                flag = False
                for n in range(5, 0, -1):
                    if count[n - 1] + 1 <= 5:
                        if check(i, j, n):
                            count[n - 1] += 1
                            updateVisit(i, j, n) # 방문 표시
                            dfs()
                            undoVisit(i, j, n) # 백트래킹
                            count[n-1] -= 1
                        flag = True
                if flag:
                    return

if __name__ == "__main__":
    input = sys.stdin.readline
    matrix = [list(map(int, input().split())) for _ in range(10)]
    totalCnt = 0
    checkCnt = 0
    for i in range(10):
        for j in range(10):
            if matrix[i][j] == 1:
                totalCnt += 1

    answer = int(101)
    visited = [[0] * 10 for _ in range(10)]
    count = [0, 0, 0, 0, 0]  # 크기가 1x1 ~ 5x5 인 종이의 사용 개수
    dfs()

    if answer == 101:
        print(-1)
    else:
        print(answer)