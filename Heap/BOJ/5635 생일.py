import heapq as hq
MAX = []
MIN = []
for _ in range(int(input())):
    name, d, m, y = map(str, input().split())
    if len(m) == 1:
        m = "0"+m
    if len(d) == 1:
        d = "0"+d
    temp = int(y + m + d)
    hq.heappush(MIN, [temp, name])
    hq.heappush(MAX, [-temp, name])
print(MAX[0][1])
print(MIN[0][1])