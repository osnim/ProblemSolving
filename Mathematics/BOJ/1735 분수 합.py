import math
A, B = map(int, input().split())
a, b = map(int, input().split())

top = b*A + B*a
bot = B * b
gcd = math.gcd(top, bot)

top = top//gcd
bot = bot//gcd
print(top, bot)