# 주어진 시간 패턴을 분 단위로 교체
def dateFilter(time):
    hour, min = map(int, time.split(":"))
    return hour * 60 + min


def solution(video_len, pos, op_start, op_end, commands):
    video_len = dateFilter(video_len)
    pos = dateFilter(pos)
    op_start = dateFilter(op_start)
    op_end = dateFilter(op_end)

    # 기능 수행 직전 오프닝 구간 사이에 있다면 오프닝 끝나는 시간으로 이동
    if pos >= op_start and pos < op_end:
        pos = op_end

    for c in commands:
        if c == 'prev':
            # 재생 위치 - 10초 가 현재 위치 10초 미만일 경우
            if pos - 10 <= 0:
                pos = 0
            else:
                pos -= 10
                # prev 명령 수행시 오프닝 구간 사이에 위치하는 경우
                if pos >= op_start and pos <= op_end:
                    pos = op_end
        elif c == 'next':
            # 10초 후 이동 뒤 동영상 길이를 초과 하는 경우
            if pos + 10 >= video_len:
                pos = video_len
            else:
                # 명령어 수행 전 현재 위치가 오프닝 구간 사이에 있는 경우
                if pos >= op_start and pos <= op_end:
                    # 현재 위치 = 오프닝 끝나는 시간 + 10초
                    pos = op_end + 10
                else:
                    pos += 10
                    # 10초 후 이동 뒤 오프닝 구간 사이에 위치하는 경우
                    if pos >= op_start and pos <= op_end:
                        pos = op_end

    hour = pos // 60
    min = pos % 60

    return str(hour).zfill(2) + ":" + str(min).zfill(2)