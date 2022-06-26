def sol(A, B, C):
    if B == 0:
        return 1

    if B%2 == 1:
        return A*sol(A, B-1, C)

    else:
        half = sol(A, B//2, C) % C
        return half * half

A, B, C = map(int, input().split())

#print(sol(A, B, C) % C)
print(pow(A,B,C))