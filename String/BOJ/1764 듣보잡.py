from collections import defaultdict
n, m = map(int, input().split())
a = defaultdict(int)
ans = []
for _ in range(n):
    a[input()] += 1
for _ in range(m):
    name = input()
    a[name] += 1
    if a[name] > 1:
        ans.append(name)
ans.sort()
n = len(ans)
print(n)
for name in ans:
    print(name)