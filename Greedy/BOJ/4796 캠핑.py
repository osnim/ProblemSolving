cnt = 1
while True:
    L, P, V = map(int, input().split())
    result = 0
    if L == 0 and P == 0 and V == 0:
        break
    while V > P:
        result += L
        V -= P
    #반례 5 11 21 하면 10 나와야 하는데 15나오면 안됨
    if V <= L:
        result += V
    else:
        result += L
    print(f"Case {cnt}: {result}")
    cnt += 1