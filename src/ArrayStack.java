/*****
 * 用顺序表实现栈操作
 * @param <E>
 */
public class ArrayStack <E> extends AbstractStack<E>{
    /****
     * 初始化10个大小的数组
     * 初始化数组大小的长度
     */
    private  Object[] arr=new Object[10];
    private int size=0;

    /****
     * 以底为0
     * 出栈无需扩容
     * @return
     */
    @Override
    public E pop() {
        size--;

       return (E)arr[size];
    }

    /*****
     * 入栈
     * 扩容
     * 底为0
     * @param e 元素
     */
    @Override
    public void push(E e) {
        if(size>=arr.length){
            Object[] arr= new Object[this.arr.length+10];//扩容
            for (int i = 0; i <this.arr.length ; i++) {arr[i]=this.arr[i];        }//内容替换
            this.arr=arr;//数组替换

        }
        size++;
        arr[size]=e;

    }
}
