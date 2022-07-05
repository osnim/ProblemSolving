import math
N = int(input())
arr = list(map(int, input().split()))
for i in range(1, N):
    gcd = math.gcd(arr[0], arr[i])
    print(f"{arr[0]//gcd}/{arr[i]//gcd}")

