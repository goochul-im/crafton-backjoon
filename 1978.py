import sys, math

n = list(map(int, sys.stdin.read().split()[1:]))


def is_prime(number):
    if number < 2:
        return False

    if number == 2:
        return True

    for i in range(2, int(math.sqrt(number)) + 1):
        if number % i == 0:
            return False
    return True


print(sum(1 for x in n if is_prime(x)))
