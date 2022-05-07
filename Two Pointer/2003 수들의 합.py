import sys
input = sys.stdin.readline
N, M = map(int, input().split())
arr = list(map(int, input().split()))

start = 0
end = 0
ans = 0
while end < N:
    if sum(arr[start:end+1])== M:
       ans += 1
       end += 1
    elif sum(arr[start:end+1]) < M:
        end += 1
    elif sum(arr[start:end+1]) > M:
        start += 1

print(ans)