import sys, math


prob = map(int, sys.stdin.read().split()[1:])


def get_prime_list(number):
    is_prime = [True] * (number + 1)
    is_prime[0] = is_prime[1] = False

    for i in range(2, int(math.sqrt(number)) + 1):  # number의 제곱근까지만 반복
        if is_prime[i]:
            for j in range(i * i, number + 1, i):  # i의 제곱 -> 소수가 아님, i의 제곱 + i -> 소수가 아님 ( i(i+1) )
                is_prime[j] = False

    return [n for n in range(2, number + 1) if is_prime[n]]


for task in prob:
    prime_list = get_prime_list(task)
    head, rear = 0, len(prime_list) - 1
    best_pair = (0, task)
    while head <= rear:
        total = prime_list[head] + prime_list[rear]

        if total == task:
            if abs(prime_list[rear] - prime_list[head]) < abs(best_pair[1] - best_pair[0]):
                best_pair = (prime_list[head], prime_list[rear])
                head += 1
                rear -= 1
        elif total < task:
            head += 1
        else:
            rear -= 1

    print(f"{best_pair[0]} {best_pair[1]}")
