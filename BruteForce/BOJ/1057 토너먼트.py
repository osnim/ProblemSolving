N, A, B = map(int, input().split())
cnt = 0
while A != B:
    A -= A//2
    B -= B//2
    cnt += 1
print(cnt)