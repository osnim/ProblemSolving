T = int(input())
for t in range(1, T + 1):
    ans = 0
    n = int(input())
    op = [1, -1]
    for i in range(1, n+1):
        ans += op[(i+1)%2]*i

    print(f"#{t} {ans}")