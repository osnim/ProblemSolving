s = input()
n = len(s)
arr = set()
for i in range(1, n+1):
    for j in range(n):
        arr.add(s[j:j+i])
print(len(arr))