# 2110 공유기 설치
import sys

N, C = map(int, sys.stdin.readline().split())
PROB = list(map(int, sys.stdin.read().split()))
PROB = sorted(PROB)


def get_possible_count(distance: int) -> int:  # 최대 인접 공유기의 거리가 distance일 때
    count = 1
    last_router = PROB[0]
    for i in range(1, N):
        if PROB[i] - last_router >= distance:
            count += 1
            last_router = PROB[i]
    return count


def binary_search():
    left = 1 # 최소 거리
    right = PROB[-1] - PROB[0] # 최대 거리
    answer = 0
    while left <= right:
        middle = (left + right) // 2  # 공유기 간의 최소 거리
        if C <= get_possible_count(middle):  # 설치 가능한 공유기의 수가 목표보다 작으면 같으면
            answer = middle # 정답 저장... 작거나 같으면 이니까 최대가 나올 것 
            left = middle + 1 # 거리 더 늘리기
        else: 
            right = middle - 1 # 목표보다 많이 나오면 거리를 더 줄이자
    print(answer)


binary_search()
