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

    return [idx for idx, value in enumerate(prime_list) if value is True and value < int(end ** 0.5) + 1]


def under_prime(start: int, end: int):
    prime_list = get_prime_list(end)

    count = 0
    for s in range(start, end + 1):
        prime_count = 1
        while s not in prime_list:
            for i in prime_list:
                if i >= s:
                    break
                if s % i == 0:
                    prime_count += 1
                    s //= i
                    break
        if prime_count in prime_list:
            count += 1

    print(count)


under_prime(st, e)
