def solution(phone_book):
    answer = True
    phone_book.sort(key = lambda x : (x, len))

    for i in range(len(phone_book)-1):
        left = phone_book[i]
        right = phone_book[i+1]
        if left == right[:len(left)]:
            answer = False
            return answer

    return answer