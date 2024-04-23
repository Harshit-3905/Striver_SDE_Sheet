import java.util.ArrayList;

class Max_Heap_Using_ArrayList {

    ArrayList<Integer> heap;
    int size;

    public Max_Heap_Using_ArrayList() {
        heap = new ArrayList<>();
        size = 0;
    }

    public void insert(int val) {
        heap.add(val);
        size++;
        heapifyUp(size - 1);
    }

    public void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        if (index > 0 && heap.get(index) > heap.get(parent)) {
            swap(index, parent);
            heapifyUp(parent);
        }
    }

    public void heapifyDown(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        if (left < size && heap.get(left) > heap.get(largest)) {
            largest = left;
        }
        if (right < size && heap.get(right) > heap.get(largest)) {
            largest = right;
        }
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    public void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void delete(int val) {
        int index = heap.indexOf(val);
        if (index != -1) {
            heap.set(index, heap.get(size - 1));
            heap.remove(size - 1);
            size--;
            heapifyDown(index);
        }
    }

    public int extractMax() {
        if (size == 0) {
            return -1;
        }
        int max = heap.get(0);
        heap.set(0, heap.get(size - 1));
        heap.remove(size - 1);
        size--;
        heapifyDown(0);
        return max;
    }

    public static void main(String[] args) {
        Max_Heap_Using_ArrayList heap = new Max_Heap_Using_ArrayList();
        heap.insert(10);
        heap.insert(20);
        heap.insert(15);
        heap.insert(40);
        heap.insert(50);
        heap.insert(100);
        heap.insert(25);
        heap.insert(45);
        heap.insert(12);
        heap.insert(18);
        heap.insert(30);
        heap.insert(35);
        System.out.println(heap.extractMax());
    }
}
