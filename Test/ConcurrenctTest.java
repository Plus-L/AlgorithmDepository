package Test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: AlgorithmDepository
 * @description: 测试并发用的多线程等等
 * @author: PlusL
 * @create: 2022-06-14 15:54
 **/
public class ConcurrenctTest {

    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

    HashMap<String, String> map = new HashMap<>();

    ReentrantLock lock = new ReentrantLock();

}
