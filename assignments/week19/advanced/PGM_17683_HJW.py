# PGM 17683 - [3차] 방금그곡
# 유형: 구현, 정렬
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/17683

def time_gap(time):
    hour, minuite = map(int, time.split(':'))
    return hour*60+minuite

def make_chord(chord):
    return chord.replace('C#', 'c').replace('D#', 'd').replace('F#', 'f').replace('G#', 'g').replace('A#', 'a').replace('B#', 'c').replace('E#', 'f')


def solution(m, musicinfos):
    answer = ''
    m = make_chord(m)
    
    musics = []
    
    for music in musicinfos:
        start, end, word, chord = music.split(',')
        gap = time_gap(end) - time_gap(start)
        chord = make_chord(chord)
        while len(chord) < gap:
            chord += chord
        chord = chord[:gap]
        musics.append([gap, chord, word])
    
    musics.sort(key=lambda x:x[0], reverse=True)

    for music in musics:
        chord = music[1]
        word = music[2]
        
        if m in chord:
            answer = word
            break

    return '(None)' if answer == '' else answer