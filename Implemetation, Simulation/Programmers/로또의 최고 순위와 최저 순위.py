def solution(lottos, win_nums):
    zeroes = lottos.count(0)
    hit = 0
    lottos = set(lottos)
    for lotto in lottos:
        if lotto in win_nums:
            hit += 1
    if hit == 0 and zeroes == 0:
        return [6, 6]
    top = 7 - (hit + zeroes)
    worst = 7 - (hit)
    if worst > 6:
        worst = 6
    return [top, worst]