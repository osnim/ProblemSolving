A, B, V = map(int, input().split())
if V == A:
    print(1)
    exit()
V -= A
if V % (A-B):
    print((V // (A - B)) + 2)
else:
    print((V // (A - B)) + 1)