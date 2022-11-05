from collections import defaultdict
def solution(nums):
    dic = defaultdict(int)
    for num in nums:
        dic[num] += 1

    half = len(nums) // 2
    cnt = len(dic)

    if cnt >= half:
        answer = half
    else:
        answer = cnt
    return answer