class Min_Heap_Using_Array {
    int heap[];
    int capacity;
    int size;

    Min_Heap_Using_Array(int c) {
        capacity = c;
        size = 0;
        heap = new int[c];
    }

    void MinHeapify() {
        int i = 0;
        while (2 * i + 1 < size) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int min = left;
            if (right < size && heap[right] < heap[left])
                min = right;
            if (heap[i] < heap[min])
                break;
            int temp = heap[i];
            heap[i] = heap[min];
            heap[min] = temp;
            i = min;
        }
    }

    void insert(int x) {
        if (size == capacity)
            return;
        size++;
        heap[size - 1] = x;
        for (int i = size - 1; i != 0 && heap[(i - 1) / 2] > heap[i];) {
            int temp = heap[i];
            heap[i] = heap[(i - 1) / 2];
            heap[(i - 1) / 2] = temp;
            i = (i - 1) / 2;
        }
    }

    int extractMin() {
        if (size == 0)
            return -1;
        if (size == 1) {
            size--;
            return heap[0];
        }
        int temp = heap[0];
        heap[0] = heap[size - 1];
        size--;
        MinHeapify();
        return temp;
    }

    public static void main(String[] args) {
        Min_Heap_Using_Array h = new Min_Heap_Using_Array(11);
        h.insert(3);
        h.insert(2);
        h.insert(15);
        h.insert(5);
        h.insert(4);
        h.insert(45);
        System.out.println(h.extractMin());
        System.out.println(h.extractMin());
        System.out.println(h.extractMin());
        h.insert(1);
        h.insert(10);
        System.out.println(h.extractMin());
    }
}
