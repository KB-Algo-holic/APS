# PGM 42579 - 베스트앨범
# 유형: 해시
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42579

def solution(genres, plays):
    answer = []
    musics = {}
    for i in range(len(genres)):
        if not musics.get(genres[i]):
            musics[genres[i]] = []
        musics.get(genres[i], []).append((plays[i], i))
        
    for genre in musics:
        musics[genre].sort(key=lambda x:(x[0], -x[1]))
    
    counts = []
    for genre in musics:
        tmp = 0
        for music in musics[genre]:
            tmp += music[0]
        counts.append((tmp, genre))
    
    counts.sort(key=lambda x:x[0], reverse = True)
    
    for count in counts:
        genre = count[1]
        for _ in range(2):
            if musics[genre]:
                answer.append(musics[genre].pop()[1])    
    
    return answer