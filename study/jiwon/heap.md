#### 1\. 힙(Heap)에 대해

힙 트리(Heap Tree, Heap)는 완전 이진 트리의 형태를 띄며, 주로 최솟값, 최댓값을 찾기 위해 사용하는 자료구조다.

어떤 비교연산을 기준으로 하냐에 따라서 다르지만, 힙 트리의 루트노드가 최우선순위를 가지는 노드가 된다는 것을 보장한다. 이하 설명은 최솟값을 보장하는 최소 힙을 기준으로 설명하겠다.

**최소 힙을 기준으로 부모노드는 항상 자식보다 작아야 한다.**

따라서 루트 노드에는 항상 데이터들 중 가장 작은 값이 있게 되고, 이를 통해 _O_(1) 안에 최솟값을 찾아낼 수가 있다.

또한, 완전 이진 트리의 특성에 의해 삽입, 삭제에는 _O_(log*N*)이 소요된다.





#### 2\. 표현

힙의 구현은 다음과 같이 할 수 있다.

<img src="C:\Users\crisj\Desktop\tistory\KakaoTalk_20250817_215506092.jpg" style="zoom: 50%;" />

힙은 완전 이진 트리 구조이기 때문에 배열로 표현하기 편하다. 배열로 표현하면 부모노드는 `i/2`, 자식은 `2*i`, `2*i+1`로 편하게 찾을 수 있기 때문이다.

**배열로 표현했을 때, 데이터가 정렬되어 있음이 보장되지는 않는다.**

그저 부모노드의 위치에 있는 데이터는 자식노드 위치에 있는 데이터보다만 작을 뿐이다!





#### 3\. 데이터의 삽입

1\. 가장 끝의 자리에 노드를 삽입한다.

2\. 그 노드와 부모 노드를 서로 비교한다.

3\. 규칙에 맞으면 그대로 두고, 그렇지 않으면 부모와 교환한다.

4\. 규칙에 맞을 때 까지 3번 과정을 반복한다.

[##_Image|kage@bArKqA/btsPWl0f0EK/AAAAAAAAAAAAAAAAAAAAAOwYB4IaKzDXatBgTD25Vi3-WVlSbR_uOUueu7lh5AEn/img.jpg?credential=yqXZFxpELC7KVnFOS48ylbz2pIh7yKj8&amp;expires=1756652399&amp;allow_ip=&amp;allow_referer=&amp;signature=wI12FMViJBC6gc9Vs0PooZCmKg8%3D|CDM|1.3|{"originWidth":1536,"originHeight":826,"style":"alignLeft","width":440,"height":237,"caption":"가장 끝의 자리에 7을 삽입한다.","filename":"KakaoTalk_20250817_215506092_07.jpg"}_##]

<img src="C:\Users\crisj\Desktop\tistory\KakaoTalk_20250817_215506092_07.jpg" style="zoom:33%;" align="left"/>

> 가장 끝의 자리에 7을 삽입한다.



<img src="C:\Users\crisj\Desktop\tistory\KakaoTalk_20250817_215506092_06.jpg" style="zoom:33%;" align="left" />

> 부모 노드18과 비교 후 교환한다.



<img src="C:\Users\crisj\Desktop\tistory\KakaoTalk_20250817_215506092_05.jpg" style="zoom:33%;" align="left" />

> 부모 9와 비교 후 교환한다. 그 이후는 교환이 일어나지 않는다.





#### 4\. 데이터의 삭제

1\. 루트 노드를 제거한다.

2\. 루트 자리에 가장 마지막 노드를 삽입한다. (빈 공간이 생기지 않기 위해서)

3\. 올라간 노드와 그 자식을 비교한다.

4\. 조건에 만족하면 그대로 두고, 그렇지 않으면 자식과 교환한다.

최소 힙을 기준으로 자식 둘 다 부모보다 작다면, 더 작은 값으로 교환하면 된다.

5.조건을 만족할 때까지 4의 과정을 반복한다.



<img src="C:\Users\crisj\Desktop\tistory\KakaoTalk_20250817_215506092_04.jpg" style="zoom:33%;" align="left" />

> 루트 노드 5를 제거하고, 마지막 노드 27을 루트로 올린다.



<img src="C:\Users\crisj\Desktop\tistory\KakaoTalk_20250817_215506092_03.jpg" style="zoom:33%;" align="left" />

> 자식 노드와 비교하고, 더 작은 값인 9와 교환한다.



<img src="C:\Users\crisj\Desktop\tistory\KakaoTalk_20250817_215506092_02.jpg" style="zoom:33%;" align="left" />

> 자식 노드와 비교하고, 더 작은 값인 14와 교환한다.



<img src="C:\Users\crisj\Desktop\tistory\KakaoTalk_20250817_215506092_01.jpg" style="zoom:33%;" align="left" />

> 자식 노드 17과 비교 후 교환한다.