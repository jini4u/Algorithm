# 정렬

### O(n^2): Bubble Sort, Selection Sort, Insertion Sort
-  Bubble Sort : 인접한 두개를 비교해가면서 뒤로. 배열 크기만큼 반복
-  Selection Sort : i번째 과정이면 i부터 끝까지 중 최소 찾아 i번에 넣기
-  Insertion Sort : i번째 과정이면 0부터 i앞까지와 비교해 맞는자리에 넣기. 이미 정렬되어 있으면 한번씩만 비교해 O(n)
 
### O(nlogn): Quick Sort, Merge Sort, Heap Sort
-  Quick Sort : 기준값pivot보다 작으면 왼쪽 크면 오른쪽. 각부분에서 새 pivot 정해서 반복. 최악의경우 O(N^2)
 				로무토분할: 가장안쪽 i,방문위치j. j증가시키면서 pivot보다 크면 다음위치로, 작으면 i와 swap. j가 pivot 도달하면 i와 pivot 교환
-  Merge Sort : 리스트 크기가 1 될때까지 나눔, 정렬된 리스트 두개씩 정렬하면서 합침. 자료수 같으면 걸리는 시간도 같다.
-  Heap Sort : 힙 정렬 

