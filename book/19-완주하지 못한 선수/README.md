# 완주하지 못한 선수

- 출처: 프로그래머스 42576
- 유형: 해시

## 문제 요약
참가자 중 완주하지 못한 한 명을 찾는다.  
동명이인이 존재할 수 있다.

## 풀이 핵심
- 동명이인이 있으므로 `HashSet`이 아닌 `HashMap<이름, 인원수>` 사용
- completion의 이름별 인원수를 저장
- participant를 순회하며 해당 이름의 인원수를 차감
- 남은 인원수가 0이면 해당 참가자가 미완주자

```java
for (String name : completion) {
    map.put(name, map.getOrDefault(name, 0) + 1);
}

for (String name : participant) {
    if (map.getOrDefault(name, 0) == 0) {
        return name;
    }
    map.put(name, map.get(name) - 1);
}
```

## 시간복잡도
- N = `participant.length`
- HashMap `get()`, `put()` → 평균 O(1)
- completion + participant 순회 → **O(N)**

## 기억할 개념
- 존재 여부만 필요 → `HashSet`
- 값별 개수까지 필요 → `HashMap`
- `HashSet`은 중복을 허용하지 않음

```java
// 빈도수 증가
map.put(key, map.getOrDefault(key, 0) + 1);

// 값 감소
map.put(key, map.get(key) - 1);

// 모든 Key 순회
for (String key : map.keySet()) {
    int value = map.get(key);
}
```

- `getOrDefault(key, 0)` → key가 없으면 0 반환
- `keySet()` → HashMap의 모든 Key 반환

## 내가 막힌 부분
- 처음에는 `HashSet`으로 접근했지만 동명이인을 처리할 수 없었음
- `getOrDefault()` 사용법을 새로 익힘
- participant를 먼저 저장하는 풀이에서는 `keySet()`으로 마지막 남은 사람을 찾을 수 있음

## 기억할 점
> 중복된 값의 **개수까지 관리해야 한다면 HashMap**을 생각하기.

> 빈도수 계산: `map.put(key, map.getOrDefault(key, 0) + 1)`