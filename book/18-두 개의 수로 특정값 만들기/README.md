# 18-두 개의 수로 특정값 만들기

- 출처: 코딩테스트 합격자 되기 Java편 - 문제 18
- 유형: 해시

## 문제 요약

배열에서 서로 다른 두 수를 골랐을 때, 두 수의 합이 `target`이 되는 경우가 있는지 확인한다.

## 풀이 핵심

- 모든 두 수를 직접 비교하면 O(N²)
- 현재 값이 `i`라면 필요한 값은 `target - i`
- `target - i`가 이전에 등장했는지 HashSet으로 확인
- 없다면 현재 값을 HashSet에 저장하고 다음 원소로 이동

```java
for (int i : arr) {
    if (hashSet.contains(target - i)) {
        return true;
    }
    hashSet.add(i);
}
```

## 시간복잡도

- N = `arr.length`
- HashSet `contains()`, `add()` → 평균 O(1)
- N개의 원소를 한 번씩 확인 → **평균 O(N)**

### List와 차이

- `ArrayList.contains()` → O(N)
- `HashSet.contains()` → 평균 O(1)
- for문 안에서 List의 `contains()` 사용 → O(N²)
- HashSet 사용 → 평균 O(N)

## 기억할 개념

### HashMap
- Key + Value가 필요할 때 사용
- `put()`, `get()`, `containsKey()`

### HashSet
- 값의 존재 여부만 필요할 때 사용
- 중복 허용 X
- `add()`, `contains()`, `remove()`
- 주요 연산은 평균 O(1)

## 내가 막힌 부분

- HashSet을 사용해본 적이 없어 처음에는 익숙한 HashMap으로 풀이함
- 이 문제는 Value가 필요하지 않고 값의 존재 여부만 확인하면 되므로 HashSet이 더 적합
- `contains()` → `add()` 순서로 처리하면 현재 원소 자기 자신을 짝으로 사용하는 것을 방지할 수 있음

## 기억할 점

> 특정 값이 존재하는지 반복해서 확인해야 한다면 HashSet을 떠올려보기.

> for문이 하나라고 항상 O(N)은 아니다. 반복문 안에서 호출하는 메서드의 시간복잡도도 확인하기.