word = input()
alpha = [0]*26
for w in word:
    alpha[ord(w) - 97] += 1
for i in range(26):
    print(alpha[i], end = " ")