# [Bronze III] 약수 구하기 - 2501 

[문제 링크](https://www.acmicpc.net/problem/2501) 

### 성능 요약

메모리: 14400 KB, 시간: 136 ms

### 분류

브루트포스 알고리즘(bruteforcing), 수학(math)

### 문제 설명

<p>어떤 자연수 p와 q가 있을 때, 만일 p를 q로 나누었을 때 나머지가 0이면 q는 p의 약수이다. </p>

<p>6을 예로 들면</p>

<ul>
	<li>6 ÷ 1 = 6 … 0</li>
	<li>6 ÷ 2 = 3 … 0</li>
	<li>6 ÷ 3 = 2 … 0</li>
	<li>6 ÷ 4 = 1 … 2</li>
	<li>6 ÷ 5 = 1 … 1</li>
	<li>6 ÷ 6 = 1 … 0</li>
</ul>

<p>그래서 6의 약수는 1, 2, 3, 6, 총 네 개이다.</p>

<p>두 개의 자연수 N과 K가 주어졌을 때, N의 약수들 중 K번째로 작은 수를 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N과 K가 빈칸을 사이에 두고 주어진다. N은 1 이상 10,000 이하이다. K는 1 이상 N 이하이다.</p>

### 출력 

 <p>첫째 줄에 N의 약수들 중 K번째로 작은 수를 출력한다. 만일 N의 약수의 개수가 K개보다 적어서 K번째 약수가 존재하지 않을 경우에는 0을 출력하시오.</p>
 
 
 ## 자바 주의사항
- class 명은 무조건 Main
- method 명은 무조건 static void main(String[] args)
- 문제에 나온 변수를 파라미터처럼 받으려면, Scanner 나 System.in 사용
- import 무조건 추가해줘야함

### 풀이
```java
public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> measures = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int remainder = N % i;
            if (remainder == 0) {
                int quotient = N / i;
                measures.add(quotient);
            }
        }
        
        List<Integer> reverseMeasures = measures.stream()
                .sorted()
                .collect(Collectors.toList());

        if (reverseMeasures.size() >= K) {
            System.out.println(reverseMeasures.get(K - 1));
        } else {
            System.out.print(0);
        }
    }
```

int N, int K 를 받아줘야함

알고리즘이라 그런지, `Scanner` 나 `System.in` 을 사용해야함

```java
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
```

#### 변수명
- `measures`  약수를 담는 배열
- `remainder` 나머지
- `quotient` 몫
- `reverseMeasures` 역순정렬로 된 배열 (역순정렬이 아니라 그냥 정순 정렬인데 문제를 잘못이해해서 변수명을 역순정렬로 지정해버림;;)

`%` 를 사용하면 나눗셈 후 나머지를 구하는 것

`/` 를 사용하면 나눗셈 후 몫을 구하는 것

#### 코드 설명
1. for 문을 돌며 `int remainder = N % i;` 를 통해 나머지가 0 인 식만 약수로 들어올 수 있게끔 설정
2. `int quotient = N / i;` 를 통해 몫을 구함(= 약수 구하기)
3. 약수 배열에 추가
4. steram() 의 sort() 를 이용해서 정순정렬
5. `if (reverseMeasures.size() >= K)` 정렬된 배열의 개수가 K 의 수보다 크거나 같다면 정렬된 약수 배열 중 K 번째를 가져옴 (if 문으로 처리하지않으면 OutOfBoundMemory 오류 발생)
6. 만약 정렬된 배열의 개수가 K 의 수보다 작으면 숫자 0 을 응답 


