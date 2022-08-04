import sys
input = sys.stdin.readline
expression = input().strip()
n = len(expression)
arr = []
start, end = 0, 1
for i in range(n):
    if expression[i] == "+":
        arr += [int(expression[start:i]), "+"]
        start = i+1
    elif expression[i] == "-":
        arr += [int(expression[start:i]), "-"]
        start = i+1

arr += [int(expression[start:])]
ans, temp = 0, 0
while arr:
    num = arr.pop()
    if type(num) == int :
        temp += num
    elif num == "-":
        ans -= temp
        temp = 0

ans += temp
print(ans)