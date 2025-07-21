from collections import deque

def solution(maps):
    # 상하좌우 이동을 위한 방향 벡터
    dr = [0, 1, 0, -1] # 행 (row) 변화량
    dc = [1, 0, -1, 0] # 열 (column) 변화량

    rows, cols = len(maps), len(maps[0])
    start_coords, lever_coords, exit_coords = [], [], []

    # 'S', 'L', 'E'의 좌표 찾기
    for r in range(rows):
        for c in range(cols):
            if maps[r][c] == "S":
                start_coords = [r, c]
            elif maps[r][c] == "L":
                lever_coords = [r, c]ㅑ
            elif maps[r][c] == "E":
                exit_coords = [r, c]

    # 시작점('S')에서 레버('L')까지의 최단 거리 계산
    dist_to_lever = bfs(start_coords, lever_coords, rows, cols, maps, dr, dc)

    # 레버에 도달할 수 없다면 -1 반환
    if dist_to_lever == -1:
        return -1

    # 레버('L')에서 탈출구('E')까지의 최단 거리 계산
    dist_to_exit = bfs(lever_coords, exit_coords, rows, cols, maps, dr, dc)

    # 탈출구에 도달할 수 없다면 -1 반환, 아니면 총 거리 반환
    if dist_to_exit == -1:
        return -1
    else:
        return dist_to_lever + dist_to_exit

def bfs(start, destination, rows, cols, maze_map, dr, dc):
    queue = deque()
    queue.append(start)
    
    # 방문 배열 초기화 (-1은 미방문, 숫자는 시작점으로부터의 거리)
    visited = [[-1 for _ in range(cols)] for _ in range(rows)]
    visited[start[0]][start[1]] = 0 # 시작점의 거리는 0

    while queue:
        r, c = queue.popleft()

        # 목적지에 도달했다면 현재까지의 거리를 반환
        if r == destination[0] and c == destination[1]:
            return visited[r][c]

        # 4방향 탐색
        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]

            # 맵 범위 내에 있고, 벽('X')이 아니며, 아직 방문하지 않은 경우
            if 0 <= nr < rows and 0 <= nc < cols and maze_map[nr][nc] != "X" and visited[nr][nc] == -1:
                visited[nr][nc] = visited[r][c] + 1 # 거리 업데이트
                queue.append([nr, nc]) # 큐에 추가
                
    # 목적지에 도달할 수 없는 경우 -1 반환
    return -1