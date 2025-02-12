# Dijkstra (다익스트라 알고리즘)
#### 그래프의 한 정점에서 목적지까지의 최단 경로를 구하는 알고리즘

## 목적
#### 음의 가중치가 없는 그래프의 한 정점에서 다른 모든 정점까지의 최단 경로를 구하는 알고리즘

## 문제 해결 접근 방법
1. 방문하지 않은 노드 중에서 가장 적은 비용으로 방문할 수 있는 노드 선택 (Greedy)
2. 해당 노드로 부터 갈 수 있는 노드 비용 갱신 (Dynamic programming)

## 시간 복잡도
- 간선의 수 = E, 노드의 수 = V, E = V^2 미만
- 각 정점마다 인접한 간선들을 검사하는 작업 : O(E)
- 우선 순위 큐에 간선을 넣고 빼는 작업 (Heap 사용) : O(logE)
- 모든 간선을 우선 순위 큐에 넣고 빼는 데 걸리는 시간 : O(ElogE)
- ElogE = ElogV^2 = 2ElogV
- 시간 복잡도 : **O(ElogV)**

## Reference
[[필수 알고리즘] 다익스트라 알고리즘(Dijkstra Algorithm) 이해](https://cobi-98.tistory.com/46#%EB%-B%A-%EC%-D%B-%EC%-A%A-%ED%-A%B-%EB%-D%BC%--%EC%--%-C%EA%B-%A-%EB%A-%AC%EC%A-%---Dijkstra%--Algorithm-)
[다익스트라(Dijkstra) 알고리즘](https://great-park.tistory.com/133)