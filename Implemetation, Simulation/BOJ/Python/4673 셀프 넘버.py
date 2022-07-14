import sys
print = sys.stdout.write
check = [0] * (10001)
for i in range(1, 10001):
    string = str(i)
    temp = i
    for j in string:
        temp += int(j)

    if temp < 10001:
        check[temp] = 1

for i in range(1, 10001):
    if not check[i]:
        print(f"{i}\n")