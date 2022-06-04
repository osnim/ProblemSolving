for _ in range(int(input())):
    S = list(map(str, input().split()))
    L = ""
    for s in S:
        L += "".join(reversed(s)) + " "
    print(L)