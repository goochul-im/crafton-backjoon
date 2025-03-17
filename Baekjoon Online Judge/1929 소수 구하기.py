# 1929번 소수 구하기

import sys

start, end = map(int, sys.stdin.readline().split())


def get_prime_list(left: int, right: int):
    is_prime = [True] * (right+1) #일단 모두 True로 초기화
    is_prime[0] = False
    is_prime[1] = False

    for i in range(2, int(right**0.5) +1):
        if is_prime[i]:
            for j in range(i*i, right+1, i): #i의 배수들을 False로 만들기
                is_prime[j] = False

    for prime in range(left, right + 1):
        if is_prime[prime]:
            print(prime)


get_prime_list(start, end)
