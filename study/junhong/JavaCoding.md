✅ 1. 객체 생명주기 관리
<br>
▶ 필요 이상으로 객체를 오래 참조하지 마라
불필요한 객체 참조는 GC를 방해한다.
<br>
        
        List list = new ArrayList<>();
        list.clear(); // 데이터만 지우고 재사용 가능
<br>
▶ 사용 후 비우기
list = null;  // 더 이상 필요 없으면 명시적으로 참조 해제
<br>
▶ 지역 변수 범위를 좁혀라
객체의 수명은 블록 단위로 짧게 관리하는 것이 좋다.
<br><br><br>
✅ 2. 불필요한 객체 생성을 피하라
<br>
▶ new를 남용하지 마라
<br><br>

        
        String s = new String("hello"); // ❌
        String s = "hello";             // ✅ intern pool 사용
<br>
▶ 객체 재사용을 고려하라
Integer.valueOf() 같은 캐싱이 가능한 정수 사용

싱글톤 패턴 또는 Flyweight 패턴 도입
<br><br><br>
✅ 3. 컬렉션 사용 시 용량 관리
<br>
▶ 적절한 초기 용량 지정
<br>
Map<String, Object> map = new HashMap<>(16); // 예상 크기 고려
<br><br><br>
✅ 4. String 관련 주의사항
<br>
▶ 문자열 연결 시 + 남용 금지

        
        String result = "";
        for (String s : list) {
            result += s; // ❌ 비효율적
            }
            
        // 아래와 같이 사용
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s); // ✅
            }
<br><br><br>
🧵 StringBuilder vs StringBuffer 요약 비교표
| 항목       | StringBuilder     | StringBuffer           |
| -------- | ----------------- | ---------------------- |
| 스레드 안전성  | ❌ 스레드에 안전하지 않음    | ✅ 스레드에 안전함 (동기화 처리됨)   |
| 동기화 여부   | ❌ 비동기 (빠름)        | ✅ 모든 메서드가 synchronized |
| 성능       | 빠름 (싱글스레드 환경에 적합) | 느림 (멀티스레드 환경에 적합)      |
| 사용 시작 시기 | Java 5 이상         | Java 1.0 부터 존재         |
| 추천 사용 상황 | 대부분의 경우에 더 추천됨    | 동시성 제어가 꼭 필요한 경우만 사용   |

<br>
📌 어떤 걸 선택해야 하나요?
<br>
✅ 싱글스레드 or 병렬 처리를 하지 않는 웹 애플리케이션, API 등 대부분 상황 → StringBuilder 추천
<br>
⚠️ 여러 스레드에서 동시에 문자열을 다루는 경우 (예: 멀티스레드 로깅, 서버 내부 버퍼 공유 등) → StringBuffer
<br>
참고: 실제로 Java 표준 라이브러리에서도 대부분 StringBuilder를 사용합니다. 성능이 더 뛰어나기 때문입니다.
<br><br><br>
      
        

        StringBuffer sb = new StringBuffer();

        Runnable task = new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    sb.append("A");
                }
            }
        };

        Thread a1 = new Thread(task);
        Thread a2 = new Thread(task);

        a1.start();
        a2.start();
        a1.join();
        a2.join();

        System.out.println("Result length: " + sb.length());
<br><br>
aa

