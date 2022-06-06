A, B = map(str, input().split())
a, b = len(A), len(B)
ans = int(10e9)
for i in range(b-a+1):
    bstart = i
    cnt = 0
    for j in range(a):
        if A[j] != B[bstart+j]:
            cnt += 1
    ans = min(ans, cnt)
print(ans)