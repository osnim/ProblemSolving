import math
n, m = map(int, input().split(":"))
G = math.gcd(n,m)
print(f'{n//G}:{m//G}')