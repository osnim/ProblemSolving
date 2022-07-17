import sys
input = sys.stdin.readline
N = int(input())
stack = []
answer = []
temp = 1
for i in range(N):
    data = int(input())
    while temp <= data:
        stack.append(temp)
        temp += 1
        answer.append('+')

    if stack[-1] != data:
        answer = ["NO"]
        break
    stack.pop()
    answer.append('-')

for i in range(len(answer)):
    print(answer[i])