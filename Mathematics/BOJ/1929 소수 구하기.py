M, N = map(int, input().split())
if M == 1:
    M = 2
arr = [1] * (N+1)
for i in range(2, int((N+1)**0.5)+1):
    if arr[i] == 1:
        for j in range(i+i, N+1, i):
            arr[j] = 0
for i in range(M, N+1):
    if arr[i]:
        print(i)