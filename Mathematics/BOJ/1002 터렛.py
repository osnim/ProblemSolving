import math
import sys
input = sys.stdin.readline
n = int(input().strip())
for i in range(n):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    if x1 == x2 and y1 == y2 :
        if r1 == r2:
            print(-1)
        else:
            print(0)
        continue
    d = math.sqrt(pow(abs(x1-x2), 2) + pow(abs(y1-y2), 2))
    # 한 원이 내부에 있는 경우
    if d < max(r1, r2):
        if abs(r1 - r2) == d:  # 내접
            print(1)
            # 안 내부에 있으나 접하지 않은 경우
        elif d+min(r1, r2) < max(r1, r2):
            print(0)
        else:
            print(2)

    else:
        if r1 + r2 == d:
            print(1)
        elif r1 + r2 < d:
            print(0)
        else:
            print(2)