import math
for _ in range(int(input())):
    arr = list(map(int, input().split()))
    n = arr[0]
    ans = 0
    for i in range(1, n):
        for j in range(i+1, n+1):
            ans += math.gcd(arr[i], arr[j])
    print(ans)