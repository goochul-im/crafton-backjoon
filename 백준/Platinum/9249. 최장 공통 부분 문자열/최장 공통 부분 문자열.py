import sys
input = sys.stdin.readline

A = input().strip()
B = input().strip()

comp_array = A + "$" + B + "#"
N = len(comp_array)

# 초기 rank: 문자 하나 기준
rank = [ord(c) for c in comp_array]
tmp = [0] * N
suffix_array = list(range(N))

k = 1
while k < N:
    # 정렬 기준: (현재 rank, 다음 rank)
    suffix_array.sort(key=lambda x: (rank[x], rank[x + k] if x + k < N else -1))

    tmp[suffix_array[0]] = 0
    for i in range(1, N):
        prev = suffix_array[i - 1]
        curr = suffix_array[i]
        tmp[curr] = tmp[prev] + (
            (rank[curr], rank[curr + k] if curr + k < N else -1) !=
            (rank[prev], rank[prev + k] if prev + k < N else -1)
        )
    rank = tmp[:]
    k <<= 1

# LCP 배열 (Kasai)
lcp = [0] * N
k = 0
rank_inv = [0] * N  # rank_inv[i] = i번째 접미사가 정렬된 순서에서 몇 번째인지
for i in range(N):
    rank_inv[suffix_array[i]] = i

for i in range(N):
    if rank_inv[i] == 0:
        continue
    j = suffix_array[rank_inv[i] - 1]
    while i + k < N and j + k < N and comp_array[i + k] == comp_array[j + k]:
        k += 1
    lcp[rank_inv[i]] = k
    if k > 0:
        k -= 1

# 최장 공통 부분 문자열 찾기
max_len = 0
pos = 0
len_A = len(A)

for i in range(1, N):
    a_idx = suffix_array[i]
    b_idx = suffix_array[i - 1]

    # A와 B에서 각각 온 접미사인지 확인
    in_A = a_idx < len_A
    in_B = b_idx < len_A

    if in_A != in_B:
        if lcp[i] > max_len:
            max_len = lcp[i]
            pos = a_idx if in_A else b_idx

print(max_len)
print(comp_array[pos:pos + max_len])
