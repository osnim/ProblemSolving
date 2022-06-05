S = input()
zero = S.split('1')
one = S.split('0')
cnt1 = 0
for z in zero:
    if z != "":
       cnt1 += 1
cnt2 = 0
for o in one:
    if o != "":
        cnt2 += 1
print(min(cnt1, cnt2))