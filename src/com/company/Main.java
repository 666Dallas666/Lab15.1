package com.company;
import java.util.Scanner;
    class Out {
        static Collection Test = new Collection();
        static void OutCollection(){
        for (int i = 0; i < Test.GetSize(); i++)
            System.out.print(Test.SearchElem(i) + " ");
        System.out.print("\n");
    }
     static class Collection {
        private int size;
        private int[] collection = new int[0];
        public void AddElem(int element){
            if (collection.length == 0)
                collection = new int[1];
            else {
                int[] collection1 = new int[collection.length + 1];
                System.arraycopy(collection, 0, collection1, 0, collection1.length - 1);
                collection = new int[collection.length + 1];
                System.arraycopy(collection1, 0, collection, 0, collection.length);
            }
            collection[collection.length - 1] = element;
            size++;
        }
        public void DeleteElem(int index){
            if (collection.length == 0 || index >= collection.length || index < 0)
                return;
            boolean check = false;
            collection[index] = Integer.MIN_VALUE;
            int[] collection1 = new int[collection.length - 1];
            for (int i = 0; i < collection.length - 1; i++){
                if (collection[i] == Integer.MIN_VALUE)
                    check = true;
                if (check == false)
                    collection1[i] = collection[i];
                else
                    collection1[i] = collection[i + 1];
            }
            collection = new int[collection.length - 1];
            System.arraycopy(collection1, 0, collection, 0, collection.length);
            size--;
        }
        public int SearchIndex(int element){
            for (int i = 0; i < collection.length; i++)
                if (collection[i] == element)
                    return i;
            return Integer.MIN_VALUE;
        }
        public int SearchElem(int index){
            return (index < collection.length && index >= 0) ? collection[index] : Integer.MIN_VALUE;
        }
        public int MaxElem(){
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < collection.length; i++)
                if (collection[i] > max)
                    max = collection[i];
            return max;
        }
        public int MinElem(){
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < collection.length; i++)
                if (collection[i] < min)
                    min = collection[i];
            return min;
        }
        public double AverElem(){
            int sum = 0;
            for (int i = 0; i < collection.length; i++)
                sum += collection[i];
            return collection.length > 0 ? (double)(sum / collection.length) : 0;
        }
         public int GetSize(){
             return size;
         }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result;
        for (int i = 0; i < 5; i++)
            Test.AddElem((int)(Math.random() * 100));
        System.out.print("Сгенерированная коллекция элементов: ");
        OutCollection();
        System.out.println("Введите индекс удаляемого элемента: ");
        Test.DeleteElem(scanner.nextInt());
        OutCollection();
        System.out.println("Введите значение элемента искомого индекса: ");
        result = Test.SearchIndex(scanner.nextInt());
        if (result != Integer.MIN_VALUE)
            System.out.println(result);
        else
            System.out.println("Индекс не найден");
        System.out.println("Введите индекс искомого элемента: ");
        result = Test.SearchElem(scanner.nextInt());
        if (result != Integer.MIN_VALUE)
            System.out.println(result);
        else
            System.out.println("Элемент не найден");
        result = Test.MaxElem();
        if (result != Integer.MIN_VALUE)
            System.out.println("Максимальный элемент коллекции: " + result);
        else
            System.out.println("Элемент не найден");
        result = Test.MinElem();
        if (result != Integer.MAX_VALUE)
            System.out.println("Значение минимального элемента: " + result);
        else
            System.out.println("Элемент не найден");
        System.out.println("Среднее арифметическое значение коллекции: " + Test.AverElem());
    }
}