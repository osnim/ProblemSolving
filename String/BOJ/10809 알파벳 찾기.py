string = input()
alpha = dict()
for i in range(26):
    alpha[chr(i+97)] = -1
for i in range(len(string)):
    s = string[i]
    if alpha[s] == -1:
        alpha[s] = i

for k, v in alpha.items():
    print(v, end=" ")
