/**线性表的应用之一*顺序表**/
public class ArrayList <E> extends AbstractList<E>{
    /****
     * 初始化10个大小的数组
     * 初始化数组大小的长度
     */
    private  Object[] arr=new Object[10];
    private int size=0;



    @Override
    public int size() {
        return size;
    }

    /***
     * 先检查扩容，（扩容完后），旧位置元素后移，加入新位置元素。
     * 安全检查，不可在空元素后插入
     * @param e     元素
     * @param index 要添加的位置(索引)
     */
    @Override
    public void add(E e, int index) {
        if (index>size)throw new ArrayIndexOutOfBoundsException("超出顺序表长度");//安全检查
    if(size>=arr.length){
        Object[] arr= new Object[this.arr.length+10];//扩容
        for (int i = 0; i <this.arr.length ; i++) {arr[i]=this.arr[i];        }//内容替换
        this.arr=arr;//数组替换
    }
    int i=size-1;//定义下标，最后一个元素的,倒着依次后移一个单位
        while (i>=index){
            arr[i+1]=arr[i];
            i--;
        }
        this.arr[index]=e;//插入操作
        size++;//更新数组长度。

    }

    /*****
     * 顺序表后元素前移，最后一位致空，长度减一
     * 安全检查，是否这个下标有元素
     * 🕐减容
     * @param index 位置
     * @return 移除的元素
     */
    @Override
    public E remove(int index) {
        if (arr[index]==null)throw new ArrayIndexOutOfBoundsException("插入的下标为空"); //安全检查 判断语句也可为index>size-1
        E e =(E)arr[index];//获得要删除的值
        for (int j=index; j <size-1 ; j++) {  //删除操作
            arr[j]=arr[j+1];
        }
        arr[size-1]=null;  //对旧顺序表末位制空，是否制空取决于前面判断语句用的啥
        size--;//长度减一
        return e;
    }

    /****
     * 初始和删除为空时，可以不安全检查，如果不做制空操作的话，必须要安全检查
     * @param index 位置
     * @return 对应位置元素
     */
    @Override
    public E get(int index) {
        if (arr[index]==null)throw new ArrayIndexOutOfBoundsException("插入的下标为空值"); //安全检查 判断语句也可为index>size-1
        return (E)arr[index];
    }
}
