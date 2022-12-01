Павел Горуля (Pavel Gorulya)

First level:  1) Вычислить сложность следующих алгоритмов

//Time Complexity O(n) (Причина: operator break, который выполняется при каждом входе в цикл по j)
//Space Complexity O(1)
void test1(int n)
 {
    if (n==1) 
       return;
    for (int i=1; i<=n; i++)
        for (int j=1; j<=n; j++) {
            System.out.println("*");
            break;
		}
}


//Time Complexity O(n^2)
//Space Complexity O(1)
void test2(int n)
 {
    if (n==1) 
       return;
    for (int i=1; i<=n; i++)
        for (int j=1; j<=n; j++)
            System.out.println("*");
}


//Time Complexity O((n+1)*n/2)			//i = 0, j = n,.. 1		(n)
//Space Complexity O(1)					//i = 1, j = n,.. 2		(n-1)
										//i = 2, j = n,.. 3		(n-2)
// (n + (n-1) + (n-2) +...+ 1) = (1 + 2 + 3 +...+ n) = (n + 1)*n/2										
void test3(int n)
{
    int a = 0;
    for (i = 0; i < n; i++)
        for (j = n; j > i; j--)
        a = a + i + j;

}


//Time Complexity O(n/2*log n)			//i = n/2,	 j = 2,4,8,..n (log n)
//Space Complexity O(1)					//i = n/2+1, j = 2,4,8,..n (log n)
void test4(int n)
{
    int i, j, a = 0;
    for (i = n/2; i <=n; i++)
        for (j = 2; j <=n; j=j*2)
        a=a+n/2;

}


2) Find the element that appears once in a sorted array
    Given a sorted array in which all elements occur twice (one after the other) and one element appears only once.


Простое решение состоит в обходе массива слева направо. Поскольку массив отсортирован, мы легко можем найти нужный элемент.

//Алгоритм обхода отсортированного массива слева направо имеет сложность O(n).
//Я предлагаю более эффективный алгоритм, который имеет сложность O(log n).
//Опиание алгоритма:
//1. Выбираем элемент массива в середине между начальным (i) и конечным (n) индексом интервала(массива),
//	который разбивает интервал(массив) на левую и правую части.
//2. Проверяем, чтобы индекс [k] выбранного элемента был нечетным (чтобы в левой части интервала было 
//	четное 		число элементов). 
//3. Сравниваем значения элементов с индексами [k] и [k-1]
//4. Если сравниваемые элементы равны, значит искомый одиночный элемен находится в правой части интервала. 
//	Рекуривно выполняем алгоритм для правой части интервала
//5. Если сравниваемые элементы НЕ равны, значит искомый одиночный элемен находится в левой части интервала.
//	Рекуривно выполняем алгоритм для левой части интервала
//6. Когда, длина левого и правого интервала окажетя минимальной ( <= 1), вычиления заканчиваем и 
//	однозначно 		определяем искомый одиночный элемент.

//(Алгоритм выбран рекуривным из соображений наглядности)
//Данный рекурсивный алгоритм представлен ниже в виде программы:

public class SearchAlone {
    public static void main(String[] args) {

        int[] arr = {1,1,5,5,7,7,8,10,10,14,14};
        System.out.println(Arrays.toString(arr));

        int res = -1;
        int i = 0;					//start index
        int n = arr.length - 1;		//end index

        res = searchAloneEl(arr, i, n);
        System.out.println("Alone element = " + res);
    }
	// arr - input sorted array
	// i - start index
	// n - end index
    private static int searchAloneEl(int[] arr, int i, int n) {
        int k = i + (n - i)/2;
        if ((k - i) % 2 == 0) k++;

        if (k-i <= 1 && n-k <= 1) {
            if (arr[i] == arr[k])  return arr[n];
            else return arr[i];

        } else if (arr[k] == arr[k-1])  return searchAloneEl(arr, k+1, n);
          else  return searchAloneEl(arr, i, k);
    }
}



Задачки со звёздочкой - вычислить сложность в лучшем и худшем случае.

//best case O(1), (n = 1)
//worst case O(log n)
3) void test5(int n)
 {
    int a = 0, i = n;
    while (i > 0) {
        a += i;
        i /= 2;
}
}


//best case O(1)
//worst in case a || b == 0  O(infinity)
void method(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
    }

// best case O(1), (n = 1)
// worst case O(n/2*n/2*log k) ~ O((n^2)*log k)	
void method2(int n) {
        for (int i = 0; i < n / 2; i++) {
            for (int j = 1; j + n / 2 <= n; j++) {
                for (int k = 1; k <= n; k = k * 2) {
                    System.out.println("I am expert!");
                }
            }
        }
    }


// best case O(1), (n = 1)										//i = 1, j = 1,2,3,.. n	(n)
// worst case: 													//i = 2, j = 1,3,5,...n (n/2)
// 	O(n*ln n)													//i = 3, j = 1,4,7,...b (n/3)
//(n + n/2 + n/3 + ...) = n*(1 + 1/2 + ...) = n*ln n	
													
void method3(int n) {								
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j = j + i) {
                System.out.println("I am expert!");
            }
        }
    }


Second level: 