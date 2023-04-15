#스택을 활용, 수열의 오른쪽부터 시작
import sys
input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split()))
answer = []
stack = []
for i in range(N-1, -1, -1):
    cur = arr[i]
    flag = False
    while stack:
        top = stack[-1]
        if cur < top:
            answer.append(top)
            stack.append(cur)
            flag = True
            break
        else:
            stack.pop() # 스택의 top이 현재 num보다 작을 경우

    if not flag: # answer에 넣지 못하고 stack이 빈 경우
        answer.append(-1)
        stack.append(cur)

print(*reversed(answer))