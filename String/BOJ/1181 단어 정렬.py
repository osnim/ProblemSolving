import sys
input = sys.stdin.readline
n = int(input().strip())
datas = []
for i in range(n):
    s = input().strip()
    datas.append((len(s), s))
# 중복 제거
datas = list(set(datas))
datas.sort()
for s in datas:
    print(s[1])
