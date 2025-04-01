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
        rearPtr = 0;
        capacity=8;
    }
    public void update(){
        if(size==capacity){
            resize();
        }else if(size>0&&capacity>=16&&size*4<capacity){

        }

    }
    public void resize(){
        capacity*=2;
        T[] newItems = (T[]) new Object[capacity];
        for(int i=0; i<size; i++){
            newItems[i]=items[(frontPtr+i+1)%size];
        }
        items = newItems;
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

    }
    public T removeFirst() {

    }
    public T removeLast() {

    }
    public T get(int index) {

    }
    public void printDeque() {

    }
}
