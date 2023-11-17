package _02dsdb.day06_map.treemap;

import org.junit.Test;

import java.util.*;

/**
 * @author kiro
 * @description:
 * @data 11:06 15/11/2023
 **/
public class Demo {
    public static void main(String[] args) {
        // 1. TreeMap是Map接口的子实现
        // 2. TreeMap的数据结构红黑树。（左小右大）
        // 3. TreeMap存储数据大小有序。
        // 4. TreeMap不允许存储重复的key (什么叫重复: key的大小一样)
        // 5. TreeMap不允许存储null作为key:   null没有办法比较大小

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "23");
        treeMap.put(2, "23");
        treeMap.put(3, "23");
        treeMap.put(4, "23");
        treeMap.put(5, "23");
        System.out.println("treeMap = " + treeMap);
    }

    @Test
    public void test() {

        // 比如 自定义的 类作为  key
        // 构造方法摘要
        // TreeMap()
        //           使用键的自然顺序构造一个新的、空的树映射。
        TreeMap<User, Integer> treeMap = new TreeMap<>();
        treeMap.put(new User(1, "zs1"), 1);
        treeMap.put(new User(2, "zs2"), 2);
        treeMap.put(new User(3, "zs3"), 3);
        treeMap.put(new User(4, "zs4"), 4);
        treeMap.put(new User(5, "zs5"), 5);
        System.out.println("treeMap = " + treeMap);
        // TreeMap(Comparator<? super K> comparator)
        //           构造一个新的、空的树映射，该映射根据给定比较器进行排序。
        // TreeMap(Map<? extends K,? extends V> m)
        //           构造一个与给定映射具有相同映射关系的新的树映射，该映射根据其键的自然顺序 进行排序。
        // TreeMap(SortedMap<K,? extends V> m)
        //           构造一个与指定有序映射具有相同映射关系和相同排序顺序的新的树映射。
    }

    @Test
    public void test3() {
        // TreeMap大小有序 当相等时，直接更新 value
        TreeMap<User, Integer> treeMap = new TreeMap<>();
        treeMap.put(new User(1, "zs1"), 1);
        treeMap.put(new User(1, "zs2"), 2);
        treeMap.put(new User(1, "zs3"), 3);
        treeMap.put(new User(1, "zs4"), 4);
        treeMap.put(new User(1, "zs5"), 5);
        System.out.println("treeMap = " + treeMap);
    }

    @Test
    public void test4() {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 1);
        treeMap.put(2, 2);
        treeMap.put(3, 3);
        treeMap.put(4, 4);
        treeMap.put(99, 5);
        treeMap.put(6, 6);
        //  Map.Entry<K,V> ceilingEntry(K key): 大于等于给定key的最小键值对
        System.out.println("treeMap.ceilingEntry(4) = " + treeMap.ceilingEntry(4));
        // //        K ceilingKey(K key): 大于等于给定key的最小key
        System.out.println("treeMap.ceilingKey(3) = " + treeMap.ceilingKey(3));
        // //        Map.Entry<K,V> floorEntry(K key): 小于等于key的最大的键值对
        System.out.println("treeMap.floorEntry(5) = " + treeMap.floorEntry(5));
        // //        K floorKey(K key): 小于等于key最大的key
        System.out.println("treeMap.floorEntry(2) = " + treeMap.floorEntry(2));
    }


    @Test
    public void test5() {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 1);
        treeMap.put(2, 2);
        treeMap.put(3, 3);
        treeMap.put(4, 4);
        treeMap.put(99, 5);
        treeMap.put(6, 6);

        // //        Map.Entry<K,V> firstEntry(): 返回最小的键值对
        System.out.println("treeMap.firstEntry(5) = " + treeMap.firstEntry());
        System.out.println("treeMap.firstKey() = " + treeMap.firstKey());
        // //        K firstKey(): 返回最小的key
        // //        Map.Entry<K,V> lastEntry(): 返回最大的键值对
        // //        K lastKey(): 返回最大的key
        //
        // //        Map.Entry<K,V> pollFirstEntry(): 删除最小的键值对
        // //        Map.Entry<K,V> pollLastEntry(): 删除最大的键值对

    }

    @Test
    public void test6() {
        // subMap  fromInclusive判断开闭
        //  NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
        // //        返回此映射的部分视图，其键的范围从 fromKey 到 toKey。
        // //        SortedMap<K,V> subMap(K fromKey, K toKey)
        // //        返回此映射的部分视图，其键值的范围从 fromKey（包括）到 toKey（不包括）。
        // //        SortedMap<K,V> tailMap(K fromKey)
        // //        返回此映射的部分视图，其键大于等于 fromKey。
        // //        NavigableMap<K,V> tailMap(K fromKey, boolean inclusive)
        // //        返回此映射的部分视图，其键大于（或等于，如果 inclusive 为 true）fromKey。
        // //        SortedMap<K,V> headMap(K toKey)
        // //        返回此映射的部分视图，其键值严格小于 toKey。
        // //        NavigableMap<K,V> headMap(K toKey, boolean inclusive)
        // //        返回此映射的部分视图，其键小于（或等于，如果 inclusive 为 true）toKey
    }

    @Test
    public void test7() {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(123, 452532, 12, 35, 5, 6));
        integers.sort((o1, o2) -> o1 - o2);
        System.out.println("integers = " + integers);

    }
}


class User implements Comparable<User> {
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public int compareTo(User user) {
        // 与传入的 user进行比较
        return id - user.id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}


