import sys
from collections import defaultdict
dic = defaultdict(int)
total = 0
while True:
    name = sys.stdin.readline().rstrip()
    if not name:
        break
    dic[name] += 1
    total += 1

dic = sorted(dic.items())
for (k, v) in dic:
    print(k, '%.4f' %((v/total) * 100))
