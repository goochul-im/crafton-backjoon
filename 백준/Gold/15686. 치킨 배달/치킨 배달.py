# 15686 치킨 배달
import sys

N, M = map(int, sys.stdin.readline().split())

PLANE = []
CHICKEN_LIST = []
HOUSE_LIST = []
DISTANCE = float('inf')
for i in range(N):
    lst = list(map(int, sys.stdin.readline().split()))
    PLANE.append(lst)
    chck = [(i, idx) for idx, val in enumerate(lst) if val == 2]
    if chck:
        CHICKEN_LIST.extend(chck)
    house = [(i, idx) for idx, val in enumerate(lst) if val == 1]
    if house:
        HOUSE_LIST.extend(house)

CHICK_LEN = len(CHICKEN_LIST)
OPENED_CHICKEN_CHECK = [False] * CHICK_LEN


def get_city_chicken_distance() -> int:
    result = 0
    for house_p in HOUSE_LIST:
        temp_distance = float('inf')
        for c_idx in range(CHICK_LEN):
            if OPENED_CHICKEN_CHECK[c_idx]:
                temp_distance = min(temp_distance,
                                    (abs(house_p[0] - CHICKEN_LIST[c_idx][0]) + abs(house_p[1] - CHICKEN_LIST[c_idx][1])))
        result += temp_distance
    return result


def find(opened: int, idx: int):
    global DISTANCE
    # 폐업시킬 치킨집을 하나씩 골라서 매번 계산을 다시 해야하나?? 시간제한 걸릴거 같은데...
    # 미리 치킨 거리를 구해놔도... 폐업시키면 달라지는거 아닌가?
    DISTANCE = min(DISTANCE, get_city_chicken_distance())
    if opened == M:
        return

    for closed_chick in range(CHICK_LEN):
        next_point = idx + closed_chick
        if next_point < CHICK_LEN:
            OPENED_CHICKEN_CHECK[next_point] = True  # False는 폐업을 의미
            find(opened + 1, next_point + 1)
            OPENED_CHICKEN_CHECK[next_point] = False


find(0, 0)
print(DISTANCE)
