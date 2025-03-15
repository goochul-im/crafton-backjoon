import copy
import sys

prob = list(map(int, sys.stdin.read().split()[1:]))


def get_sum(li):
    answer = 0
    for i in range(1, len(li)):
        answer += abs(li[i - 1] - li[i])
    return answer


result = []


def permutation(idx, length, my_list):
    result.append(get_sum(my_list))
    for i in range(idx, length):
        my_list[idx], my_list[i] = my_list[i], my_list[idx]  # swap
        permutation(idx+1, length, my_list)
        my_list[idx], my_list[i] = my_list[i], my_list[idx]  # swap


permutation(0, len(prob), prob)

print(max(result))
