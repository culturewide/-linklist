public class ArrayDeque<T> {
    public int size;
    public int frontPtr;
    public int rearPtr;
    public T[] items;
    public int capacity;
    public ArrayDeque () {
        items = (T[]) new Object[8];
        size=0;
        frontPtr = 0;
        rearPtr = 1;
        capacity=8;
    }
    public void update(){
        if(size==capacity){
            resize(capacity*2);
        }else if(size>0&&capacity>=16&&size*4<capacity){
            resize(Math.max(capacity/2,16));
        }
    }
    public void resize(int newcapacity){
        T[] newItems = (T[]) new Object[newcapacity];
        for(int i=0; i<size; i++){
            newItems[i]=items[(frontPtr+i+1)%size];
        }
        items = newItems;
        frontPtr = 0;
        rearPtr =size;
        capacity=newcapacity;
    }
    public void addFirst(T num) {
        update();
        items[frontPtr]=num;
        size++;
        frontPtr = (frontPtr-1+capacity)%capacity;
    }
    public boolean isEmpty() {
        return size==0;
    }
    public int size() {
        return size;
    }
    public void addLast(T item){
        update();
        items[rearPtr]=item;
        size++;
        rearPtr = (rearPtr+1+capacity)%capacity;
    }
    public T removeFirst() {
        if(size==0){
            return null;
        }
        T x=items[frontPtr+1];
        frontPtr = (frontPtr+1+capacity)%capacity;
        size--;
        update();
        return x;
    }
    public T removeLast() {
        if(size==0){
            return null;
        }
        T x=items[rearPtr-1];
        rearPtr = (rearPtr-1+capacity)%capacity;
        size--;
        update();
        return x;
    }
    public T get(int index) {
        if(index>=size)
            return null;
        return items[(frontPtr+index+1)%capacity];

    }
    public void printDeque() {
        for(int i=0; i<size; i++) {
            System.out.print(items[(i+frontPtr+1)%capacity]+" ");
        }

    }
}
