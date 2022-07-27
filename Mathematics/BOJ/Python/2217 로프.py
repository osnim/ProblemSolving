N = int(input())
arr = []
for _ in range(N):
    arr.append(int(input()))
arr.sort()
ans = 0
for i in range(N):
    ans = max(arr[i]*(N-i), ans)
print(ans)