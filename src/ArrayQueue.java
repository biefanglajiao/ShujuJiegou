public class ArrayQueue<E> extends AbstractQueue<E> {
    private Object[] arr = new Object[10];//创建底层数组
    private int head=0, tail=0;//队首，队尾下标

    /***
     * 队列处理的关键点；循坏操作 队列容量
     * @param e 元素
     */
    @Override
    public void offer(E e) {
        if (head==(tail + 1) % arr.length){
            //判断是否追尾，相等则追尾
            return;//这里做返回处理
        }
        arr[tail] = e;
        tail = (tail + 1) % arr.length;//循环
    }

    @Override
    public E poll() {
        E e= (E)arr[head];
        head=(head+1)%arr.length;
        return  e;
    }
}
