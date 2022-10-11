# ShujuJiegou
数据结构练习笔记
## 数据结构基础

警告！本章最难的部分！

学习集合类之前，我们还有最关键的内容需要学习，同第一章一样，自底向上才是最佳的学习方向，比起直接带大家认识集合类，不如先了解一下数据结构，只有了解了数据结构基础，才能更好地学习集合类，同时，数据结构也是你以后深入学习JDK源码的必备条件！（学习不要快餐式！）当然，我们主要是讲解Java，数据结构作为铺垫作用，所以我们只会讲解关键的部分，其他部分可以下去自行了解。

在计算机科学中，数据结构是一种数据组织、管理和存储的格式,它可以帮助我们实现对数据高效的访问和修改。更准确地说,数据结构是数据值的集合，可以体现数据值之间的关系，以及可以对数据进行应用的函数或操作。

通俗地说，我们需要去学习在计算机中如何去更好地管理我们的数据，才能让我们对我们的数据控制更加灵活！

### 线性表

线性表是最基本的一种数据结构，它是表示一组相同类型数据的有限序列，你可以把它与数组进行参考，但是它并不是数组，线性表是一种表结构，它能够支持数据的插入、删除、更新、查询等，同时数组可以随意存放在数组中任意位置，而线性表只能依次有序排列，不能出现空隙，因此，我们需要进一步的设计。

#### 顺序表

将数据依次存储在连续的整块物理空间中，这种存储结构称为`顺序存储结构`，而以这种方式实现的线性表，我们称为`顺序表`。

同样的，表中的每一个个体都被称为`元素`，元素左边的元素（上一个元素），称为`前驱`，同理，右边的元素（后一个元素）称为`后驱`。

![img](https://img1.baidu.com/it/u=4003060195,523881164&fm=26&fmt=auto)

我们设计线性表的目标就是为了去更好地管理我们的数据，也就是说，我们可以基于数组，来进行封装，实现增删改查！既然要存储一组数据，那么很容易联想到我们之前学过的数组，数组就能够容纳一组同类型的数据。

目标：以数组为底层，编写以下抽象类的具体实现

```java
/**
 * 线性表抽象类
 * @param <E> 存储的元素(Element)类型
 */
public abstract class AbstractList<E> {
    /**
     * 获取表的长度
     * @return 顺序表的长度
     */
    public abstract int size();

    /**
     * 添加一个元素
     * @param e 元素
     * @param index 要添加的位置(索引)
     */
    public abstract void add(E e, int index);

    /**
     * 移除指定位置的元素
     * @param index 位置
     * @return 移除的元素
     */
    public abstract E remove(int index);

    /**
     * 获取指定位置的元素
     * @param index 位置
     * @return 元素
     */
    public abstract E get(int index);
}
```

#### 链表

数据分散的存储在物理空间中，通过一根线保存着它们之间的逻辑关系，这种存储结构称为`链式存储结构`

实际上，就是每一个结点存放一个元素和一个指向下一个结点的引用（C语言里面是指针，Java中就是对象的引用，代表下一个结点对象）

![img](https://img1.baidu.com/it/u=3381038214,3369355034&fm=26&fmt=auto&gp=0.jpg)

利用这种思想，我们再来尝试实现上面的抽象类，从实际的代码中感受！

比较：顺序表和链表的优异？

顺序表优缺点：

* 访问速度快，随机访问性能高
* 插入和删除的效率低下，极端情况下需要变更整个表
* 不易扩充，需要复制并重新创建数组

链表优缺点：

* 插入和删除效率高，只需要改变连接点的指向即可
* 动态扩充容量，无需担心容量问题
* 访问元素需要依次寻找，随机访问元素效率低下

链表只能指向后面，能不能指向前面呢？双向链表！

***

栈和队列实际上就是对线性表加以约束的一种数据结构，如果前面的线性表的掌握已经ok，那么栈和队列就非常轻松了！

#### 栈

栈遵循先入后出原则，只能在线性表的一端添加和删除元素。我们可以把栈看做一个杯子，杯子只有一个口进出，最低处的元素只能等到上面的元素离开杯子后，才能离开。

![img](https://img2.baidu.com/it/u=4172728777,3669222584&fm=26&fmt=auto&gp=0.jpg)

向栈中插入一个元素时，称为`入栈（压栈）`，移除栈顶元素称为`出栈`，我们需要尝试实现以下抽象类型：

```java
/**
 * 抽象类型栈，待实现
 * @param <E> 元素类型
 */
public abstract class AbstractStack<E> {

    /**
     * 出栈操作
     * @return 栈顶元素
     */
    public abstract E pop();

    /**
     * 入栈操作
     * @param e 元素
     */
    public abstract void push(E e);
}
```

其实，我们的JVM在处理方法调用时，也是一个栈操作：

![img](https://img0.baidu.com/it/u=1098322354,1667908648&fm=26&fmt=auto)

所以说，如果玩不好递归，就会像这样：

```java
public class Main {
    public static void main(String[] args) {
        go();
    }

    private static void go(){
        go();
    }
}

Exception in thread "main" java.lang.StackOverflowError
	at com.test.Main.go(Main.java:13)
	at com.test.Main.go(Main.java:13)
	at com.test.Main.go(Main.java:13)
	at com.test.Main.go(Main.java:13)
	at com.test.Main.go(Main.java:13)
	at com.test.Main.go(Main.java:13)
	at com.test.Main.go(Main.java:13)
	at com.test.Main.go(Main.java:13)
  ...
```

栈的深度是有限制的，如果达到限制，将会出现`StackOverflowError`错误（注意是错误！说明是JVM出现了问题）

压栈太多满了
