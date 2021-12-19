package arrays;

import java.util.Arrays;

public class CircularQueue {
    int[] arr;
    int frontPointer;
    int rearPointer;
    int size = 0;

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(3);
        int[] arr = {1,2,3,4};
        Arrays.stream(arr).forEach(x -> System.out.println(cq.enQueue(x)));
        System.out.println(cq.Rear());
        System.out.println(cq.isFull());
        System.out.println(cq.deQueue());
        System.out.println(cq.enQueue(4));
        System.out.println(cq.Rear());
    }

    public CircularQueue(int k) {
        arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = -1;
        }
        frontPointer = 0;
        rearPointer = 0;
    }

    public boolean enQueue(int value) {
//        System.out.println(Arrays.toString(arr));
        if (size == arr.length) {
            return false;
        }
        arr[rearPointer] = value;
        rearPointer = offSet(rearPointer, true);
        size ++;
        return true;
    }

    public boolean deQueue() {
        if (frontPointer == rearPointer) {
            return false;
        }
        arr[frontPointer] = -1;
        frontPointer = offSet(frontPointer, true);
        size--;
        return true;
    }

    public int Front() {
        return arr[frontPointer];
    }

    public int Rear() {
        return arr[offSet(rearPointer, false)];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }

    private int offSet(int k, boolean plus) {
//        System.out.println(k);
        int len = arr.length;
        k = plus ? k + 1: k - 1;
        k = k < 0? k + len: k;
        int answer = k % len;
//        System.out.println("Pointer is now: " + Integer.toString(answer));
        return k % len;
    }
}
