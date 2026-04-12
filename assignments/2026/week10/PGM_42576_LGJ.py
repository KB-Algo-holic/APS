# PGM - 42576 완주하지못한 선수
# 해쉬
# https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=java

def solution(participant, completion):
	participantCnt = {}

	for p in participant:
		participantCnt[p] = participantCnt.get(p, 0)+1

	for c in completion:
		participantCnt[c] -= 1

	for key, value in participantCnt.items():
		if participantCnt[key] > 0:
			return key

	return ""

