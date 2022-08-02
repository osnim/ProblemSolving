from collections import defaultdict
T = int(input())
dic = defaultdict(int)
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for i in range(ord('A'), ord('Z')+1):
    dic[chr(i)] = i-65
for i in range(ord('a'), ord('z')+1):
    dic[chr(i)] = i-65-6
dic.update({'0':52, '1':53, '2':54, '3':55, '4':56, '5':57, '6':58, '7':59, '8':60, '9':61, '+':62, '/':63})

for test_case in range(1, T + 1):
    string = input()
    temp = ""
    for s in string:
        temp += "".join(format(dic[s], 'b').zfill(6))
    ans = ""
    for i in range(0, len(temp), 8):
        ans += chr(int(temp[i:i + 8], 2))

    print(f"#{test_case} {ans}")
