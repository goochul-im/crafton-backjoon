# 1124 언더프라임
# 시간초과 남...
import sys

st, e = map(int, sys.stdin.readline().split())


def get_prime_list(end: int):
    prime_list = [True] * (end + 1)
    prime_list[0], prime_list[1] = False, False

    for i in range(2, int(end ** 0.5) + 1):
        if prime_list[i]:
            for j in range(i * i, end + 1, i):
                prime_list[j] = False

    return prime_list


def under_prime(start: int, end: int):
    prime_list = get_prime_list(end)
    integer_prime_list = [idx for idx, val in enumerate(prime_list) if val is True and val <= int(end ** 0.5) + 1]

    count = 0
    for s in range(start, end + 1):
        prime_count = 1
        while prime_list[s] is False:
            for i in integer_prime_list:
                if i >= s:
                    break
                if s % i == 0:
                    prime_count += 1
                    s //= i
                    break
        if prime_list[prime_count]:
            count += 1

    print(count)


under_prime(st, e)
