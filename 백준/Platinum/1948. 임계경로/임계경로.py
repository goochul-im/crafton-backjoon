import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
M = int(input())

graph = [[] for _ in range(N + 1)]
indegree = [0] * (N + 1)
distance = [0] * (N + 1)
prev_node = [[] for _ in range(N + 1)]  # 최장 경로 이전 노드들 저장

# 그래프 입력
for _ in range(M):
    start, end, cost = map(int, input().split())
    graph[start].append((end, cost))
    indegree[end] += 1

START, END = map(int, input().split())

# 위상 정렬 + 최장 거리 계산 + prev_node 저장
def critical_path(start_node):
    q = deque()
    q.append(start_node)

    while q:
        current = q.popleft()
        for next_node, weight in graph[current]:
            # 현재까지의 최장 거리 계산
            if distance[next_node] < distance[current] + weight:
                distance[next_node] = distance[current] + weight
                prev_node[next_node] = [current]  # 새로 갱신되면 초기화
            elif distance[next_node] == distance[current] + weight:
                prev_node[next_node].append(current)  # 같은 거리면 추가

            indegree[next_node] -= 1
            if indegree[next_node] == 0:
                q.append(next_node)

critical_path(START)
print(distance[END])  # END까지 걸리는 총 시간 출력

# 역추적으로 임계 경로 간선 수 세기
def count_critical_edges(end_node):
    visited = [False] * (N + 1)
    q = deque()
    q.append(end_node)
    count = 0

    while q:
        current = q.popleft()
        for prev in prev_node[current]:
            count += 1
            if not visited[prev]:
                visited[prev] = True
                q.append(prev)
    return count

print(count_critical_edges(END))
