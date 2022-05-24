def solution(rows, columns, queries):
    answer = []
    r, c = rows, columns
    arr = [[0] * c for _ in range(r)]
    for i in range(r):
        for j in range(c):
            arr[i][j] = ((i) * c + j + 1)

    def rotate(x1, y1, x2, y2, arr, MIN):
        temp = [i[:] for i in arr]
        # >> 이동
        ty1 = y1
        while True:
            ny = ty1 + 1
            if ty1 >= y2: break
            temp[x1][ny] = arr[x1][ty1]
            MIN = min(arr[x1][ty1], MIN)
            ty1 = ny
        # 아래 이동
        tx1 = x1
        while True:
            nx = tx1 + 1
            if tx1 >= x2: break
            temp[nx][y2] = arr[tx1][y2]
            MIN = min(arr[tx1][y2], MIN)
            tx1 = nx

        # << 이동
        ty2 = y2
        while True:
            ny = ty2 - 1
            if ty2 <= y1: break
            temp[x2][ny] = arr[x2][ty2]
            MIN = min(arr[x2][ty2], MIN)
            ty2 = ny

        # 위로 이동
        tx2 = x2
        while True:
            nx = tx2 - 1
            if tx2 <= x1: break
            temp[nx][y1] = arr[tx2][y1]
            MIN = min(arr[tx2][y1], MIN)
            tx2 = nx

        arr = [i[:] for i in temp]
        return arr, MIN

    for x1, y1, x2, y2 in queries:
        MIN = 1000001
        arr, MIN = rotate(x1 - 1, y1 - 1, x2 - 1, y2 - 1, arr, MIN)
        answer.append(MIN)

    return answer