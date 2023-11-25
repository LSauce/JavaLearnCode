package selflearn.jvm.memory;

import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author kiro
 * @description:
 * @data 15:16 15/11/2023
 **/
/*

 */
public class _24OutOfMemoryErrorDemo {

    @Test
    public void showJVMInfoTest(){
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        for (Map.Entry<String, String> stringStringEntry : runtimeMXBean.getSystemProperties().entrySet()) {
            System.out.println(stringStringEntry.getKey() + "=" + stringStringEntry.getValue());
        }
        // String maxDirectMemorySize = runtimeMXBean.getSystemProperties().get("jdk.nio.maxDirectMemory");
        //System.out.println("MaxDirectMemorySize: " + maxDirectMemorySize);
    }
}
// “代码清单2-3中限制Java堆的大小为20MB，不可扩展（
// 将堆的最小值-Xms参数与最大值-Xmx参数设置为一样即可避免堆自动扩展），
// 通过参数-XX：+HeapDumpOnOutOf-MemoryError
// 可以让虚拟机在出现内存溢出异常的时候Dump出当前的内存堆转储快照以便进行事后分析


/**
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author zzm
 */
class HeapOOM {

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }
    }

    static class OOMObject {
        List<String> list = new ArrayList<>();

        {
            for (int i = 0; i < 100000; i++) {
                list.add(i + "");

            }
        }
    }
}

/**
 * VM Args：-Xss128k
 *
 * @author zzm
 */
class JavaVMStackSOF {

    private int stackLength = 1;

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
}


/**
 * VM Args：-Xss2M （这时候不妨设大些，请在32位系统下运行）
 *
 * @author zzm
 */
class JavaVMStackOOM {

    public static void main(String[] args) throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }
}


/**
 * VM Args：-XX:PermSize=6M -XX:MaxPermSize=6M
 * -XX:MaxMetaspaceSize=size, Java8 默认不限制 Meta 空间, 一般不允许设置该选项。
 *
 * @author zzm
 */
class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        // 使用Set保持着常量池引用，避免Full GC回收常量池行为
        Set<String> set = new HashSet<String>();
        // 在short范围内足以让6MB的PermSize产生OOM了
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}

/**
 * VM Args：-Xmx20M -XX:MaxDirectMemorySize=10M
 *
 * @author zzm
 */
class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        /*

        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }*/
    }



}


