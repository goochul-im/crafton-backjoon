# 1655 가운데를 말해요
import sys
import heapq

heap = []
N = int(sys.stdin.readline())
prob = list(map(int, sys.stdin.read().split()))


# TODO: 중간 힙 만들기
# 최대 힙과 최소 힙 유지하기
class MedianHeap:
    def __init__(self):
        self.max_heap = []
        self.min_heap = []
        self.length = 0

    def add_number(self, n):
        if len(self.max_heap) == len(self.min_heap):
            heapq.heappush(self.max_heap, -n)
        else:
            heapq.heappush(self.min_heap, n)
        if self.min_heap and self.max_heap and -self.max_heap[0] > self.min_heap[0]:
            max_root = -heapq.heappop(self.max_heap)
            min_root = -heapq.heappop(self.min_heap)
            heapq.heappush(self.max_heap, min_root)
            heapq.heappush(self.min_heap, max_root)

    def find_median(self):
        return -self.max_heap[0]


heap = MedianHeap()
for number in prob:
    heap.add_number(number)
    print(heap.find_median())
