ans = 1
for i in range(1, int(input())+1):
    ans *= i
temp = ans
print(len(str(ans)) - len(str(temp).rstrip('0')))