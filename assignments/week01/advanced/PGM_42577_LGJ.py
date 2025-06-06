def solution(phone_book):
    # 길이순 정렬
    phone_book.sort(key=len)
    phone_set = set()
    
    for number in phone_book:
        if number in phone_set:
            return False
        
        # 현재 번호의 접두어가 해시셋에 있는지 확인
        for i in range(1, len(number)):
            if number[:i] in phone_set:
                return False
        
        phone_set.add(number)
    return True
