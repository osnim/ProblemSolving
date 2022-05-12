import sys
def gcd(a, b):
    while b > 0:
        mod = a % b # 나머지
        # 유클리드 호제법
        #GCD(a,b) = GCD(b, mod)
        a, b = b, mod
    return a

def lcm(a, b, GCD):
    return a*b // GCD

A, B = map(int, sys.stdin.readline().split())
GCD = 0
LCM = 1
for i in range(1, min(A+1, B+1)):
    if A%i == 0 and B%i==0:
        GCD = i

SET = set()
for i in range(1, max(A+1, B+1)):
    if A%i == 0:
        SET.add(i)

DividendA = A
DividendB = B
LCMList = []
divider = 2
while DividendA and DividendB:
    if DividendA % divider == 0 and DividendB % divider == 0:
        DividendA //= divider
        DividendB //= divider
        LCMList.append(divider)
        divider = 2
        continue
    else:
        divider += 1
        if divider > DividendA or divider > DividendB:
            LCMList.append(DividendA)
            LCMList.append(DividendB)
            break

for mul in LCMList:
    LCM *= mul

GCD = gcd(A,B)
print(GCD)
print(lcm(A,B, GCD))