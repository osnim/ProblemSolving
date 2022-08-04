import sys
input = sys.stdin.readline
N = int(input())
ans = []

for i in range(N):
    cmd = input().split()
    if cmd[0] == "push":
        ans.append(cmd[1])
    elif cmd[0] == "top":
        if ans:
            print(ans[-1])
        else:
            print(-1)
    elif cmd[0] == "size":
        print(len(ans))
    elif cmd[0] == "pop":
        if ans:
            print(ans.pop())
        else:
            print(-1)
    elif cmd[0] == "empty":
        if not ans:
            print(1)
        else:
            print(0)
    #print(ans)
