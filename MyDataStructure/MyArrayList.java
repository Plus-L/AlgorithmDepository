package MyDataStructure;


public class MyArrayList<E> {

    // 默认的数组长度
    private static final int DEFAULT_CAPATICY = 10;

    /* 元素数量 */
    private int size;
    /* 存放元素的数组 */
    private Object[] elements;
    
    /**
     * 指定初始列表长度
     * @param capaticy 容量
     */
    public MyArrayList(int capaticy) {
        capaticy = capaticy < DEFAULT_CAPATICY ? DEFAULT_CAPATICY : capaticy;
        elements = new Object[capaticy];
    }

    /**
     * 无参构造
     */
    public MyArrayList() {
        this(DEFAULT_CAPATICY);
    }

    /**
     * 清楚列表中的所有元素
     */
    public void clear() {
        // （逻辑删除）这里不需要重新new一个空数组进行替换，直接将size置为0，随后因为getset操作都有执行前检查会拦截住，谁使用谁覆盖即可
        size = 0; 
    }

    /**
     * 获取列表长度
     * @return 列表长度
     */
    public int size() {
        return size;
    }

    /**
     * 判断列表是否为空
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E element) {
        return false;
    }

    /**
     * 添加元素
     * @param element 想要添加的元素
     */
    public void add(E element) {
        
    }

    /**
     * 获取对应下标的元素
     * @param index 下标
     * @return 对应下标的元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: [" + index + "] out of bounds, Size is [" + size + "]");
        }
        return (E) elements[index];
    }

    /**
     * 设置对应下标的元素
     * @param index 下标
     * @param element 元素
     * @return 修改前的元素
     */
    public E set(int index, E element) {
        checkIndex(index, size);

        Object old = elements[index];
        elements[index] = element;

        return (E) old;
    }

    /**
     * 获取某一元素的下标
     * @param element 元素
     * @return 下标
     */
    public int indexOf(E element) {
        return 0;
    }



    public int remove(int index) {
        return 0;
    }


    /**
     * 检查输入下标是否越界
     * @param index 下标
     * @param length 长度/容量
     * @return 输入的下标
     */
    public int checkIndex(int index, int length) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index: [" + index + "] out of bounds, Size is [" + size + "]");
        }

        return index;
    }

}
