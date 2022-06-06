from collections import defaultdict
dic = defaultdict(int)
M = 0
for i in range(int(input())):
    dic[input()] += 1
arr = []
for k,v in dic.items():
    if v > M:
        arr = []
        M = v
        arr.append(k)
    elif v == M:
        arr.append(k)
arr.sort()
print(arr[0])