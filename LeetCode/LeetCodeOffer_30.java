package LeetCode;

import java.util.Stack;

/**
 * @program: AlgorithmDepository
 * @description: 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * @author: PlusL
 * @create: 2022-10-01 16:52
 **/
public class LeetCodeOffer_30 {

    // 思路很简单，使用两个栈，一个存原本的数据，第二个栈作为最小栈，只存小于等于当前栈顶元素的元素。
    Stack<Integer> fullStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    /** initialize your data structure here. */
    public LeetCodeOffer_30() {

    }

    public void push(int x) {
        fullStack.push(x);
        // 当当前minStack为空，或者当前的元素小于minStack的栈顶元素，则当前元素push到minStack
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        // 弹出的前提是full栈内的栈顶元素与min栈的栈顶元素一样
        if (fullStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        fullStack.pop();
    }

    public int top() {
        return fullStack.peek();
    }

    public int min() {
        // 这儿就没啥好说的了，min栈存放的就是最小值。
        return minStack.peek();
    }
}
