from collections import defaultdict
N, M = map(int, input().split())
arr = [[0] * 4 for _ in range(M)]
dic = {0:"A", 1:"C", 2:"G", 3:"T"}
datas = []
for i in range(N):
    datas.append(input())

for data in datas:
    for j, dna in enumerate(data):
        if dna == "A":
            arr[j][0] += 1
        elif dna == "C":
            arr[j][1] += 1
        elif dna == "G":
            arr[j][2] += 1
        else:
            arr[j][3] += 1

ans = ""
Distance = 0
for i in range(M):
    ans += dic[arr[i].index(max(arr[i]))]

for data in datas:
    for j, dna in enumerate(data):
        if ans[j] != dna:
            Distance += 1
print(ans)
print(Distance)