# 정렬

## O(n^2): Bubble Sort, Selection Sort, Insertion Sort
#### Bubble Sort 
- 인접한 두개를 비교해가면서 뒤로. 배열 크기만큼 반복
#### Selection Sort
- i번째 과정이면 i부터 끝까지 중 최소 찾아 i번에 넣기
#### Insertion Sort
- i번째 과정이면 0부터 i앞까지와 비교해 맞는자리에 넣기. 이미 정렬되어 있으면 한번씩만 비교해 O(n)
 
## O(nlogn): Quick Sort, Merge Sort, Heap Sort
#### Quick Sort
- 기준값pivot보다 작으면 왼쪽 크면 오른쪽. 각부분에서 새 pivot 정해서 반복. 최악의경우 O(N^2)
- 로무토분할: 가장안쪽 i,방문위치j. j증가시키면서 pivot보다 크면 다음위치로, 작으면 i와 swap. j가 pivot 도달하면 i와 pivot 교환
#### Merge Sort
- 리스트 크기가 1 될때까지 나눔, 정렬된 리스트 두개씩 정렬하면서 합침. 자료수 같으면 걸리는 시간도 같다.
#### Heap Sort
- 힙 트리 이용

## O(n)/O(n+k): Counting Sort
#### Counting Sort
- 계수정렬. 주어진 값의 범위가 작을경우 빠름. 값의 갯수를 저장하는 배열, 결과 배열 필요. 
- 갯수배열에서 원배열의 value와 같은 index의 원소 값++, 갯수배열에서 인접한 두원소 합을 뒤쪽 원소에 저장(누적합). 원배열 맨뒤부터 value -> 갯수배열 index의 원소 값 - 1 -> 결과배열 index에 원배열 value 저장. 복잡한듯 단순..
