# 8963 사냥꾼
import sys

M, N, L = map(int, sys.stdin.readline().split())

hunters = sorted(list(map(int, sys.stdin.readline().split())))
animals = []

for i in range(N):
    animals.append(list(map(int, sys.stdin.readline().split())))


def is_huntable(animal: list) -> bool:
    if L >= get_distance(animal):
        return True
    return False


def find_nearest_hunter(animal_x: int):
    left = 0
    right = M - 1
    nearest_distance = float('inf')
    nearest_idx = 0
    while left <= right:
        middle = (left + right) // 2
        now_distance = hunters[middle] - animal_x
        if now_distance > 0:
            right = middle - 1
        elif now_distance < 0:
            left = middle + 1
        else:
            return middle
        if nearest_distance > abs(now_distance):
            nearest_distance = abs(now_distance)
            nearest_idx = middle
    return nearest_idx


def get_distance(animal: list) -> int:
    animal_x = animal[0]
    animal_y = animal[1]
    hunter_x = hunters[find_nearest_hunter(animal_x)]
    return abs(hunter_x - animal_x) + animal_y


def find():
    count = 0
    for animal in animals:
        if is_huntable(animal):
            count += 1
    print(count)


find()
