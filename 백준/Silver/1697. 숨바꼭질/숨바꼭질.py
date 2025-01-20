from sys import stdin
from queue import Queue
from pprint import pprint

# 현재위치 == X
# 걷는다면 X-1 or X+1
# 순간이동이라면 2*X

# 빼고 * 2 or 더하고 * 2 or 그냥 *2


source, dest = map(int, stdin.readline().split())

dp = [100000] * 100001
visited = [False] * 100001


q = Queue()
q.put((source, 0))

while not q.empty():
    cur, cnt = q.get()
    if cur == dest:
        print(cnt)
        break
    
    if cur - 1 >= 0 and not visited[cur-1]:
        visited[cur-1] = True
        q.put((cur-1, cnt+1))
    if cur + 1 <= 100000 and not visited[cur+1]:
        visited[cur+1] = True
        q.put((cur+1, cnt+1))
    if cur * 2 <= 100000 and not visited[cur*2]:
        visited[cur*2] = True
        q.put((cur*2, cnt+1))
        
