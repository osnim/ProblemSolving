import sys
from collections import deque
input = sys.stdin.readline
T = int(input().strip())
for _ in range(T):
    functions = input().strip()
    n = int(input().strip())
    temp = input().strip()
    check = 0
    temp = deque(temp.strip()[1:-1].split(","))
    R = 0
    for f in functions:
        if f == "R":
            R += 1

        else: # f == "D"
            if not temp:
                print("error")
                check = 1
                break
            if temp[0] == '':
                print("error")
                check = 1
                break
            if R % 2 == 1:
                temp.pop()
            else:
                temp.popleft()
    if not check:
        if R%2 == 1:
            print("["+ ",".join(reversed(temp)) + "]")
        else:
            print("["+ ",".join(temp) + "]")