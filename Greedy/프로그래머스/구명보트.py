def solution(people, limit):
    answer = 0
    people.sort(reverse=True)
    l = len(people)
    start = 0
    end = l - 1
    while start <= end:
        if people[start] + people[end] <= limit:
            end -= 1

        start += 1
        answer += 1
    return answer