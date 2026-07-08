package cn.com.sky.algorithms.interview;

/**
 * <pre>
 * HashMap测试类【Easy】
 *
 * 测试自定义HashMap的put、get、remove、size等操作
 * </pre>
 */
public class TestHashMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        // 测试用例1：基本put和get
        System.out.println("=== 测试用例1：基本put和get ===");
        map.put("a", "1");
        map.put("a", "2");
        map.put("a", "3");
        map.put("a", "5");
        System.out.println("get(a): " + map.get("a")); // 5

        map.put("b", "3");
        map.put("b", "c");
        System.out.println("get(b): " + map.get("b")); // c
        System.out.println("size: " + map.getCount()); // 2

        // 测试用例2：remove操作
        System.out.println("\n=== 测试用例2：remove操作 ===");
        System.out.println("remove(a): " + map.remove("a")); // 5
        System.out.println("size after remove: " + map.getCount()); // 1
        System.out.println("remove(b): " + map.remove("b")); // c
        System.out.println("size after remove: " + map.getCount()); // 0

        // 测试用例3：remove不存在的key
        System.out.println("\n=== 测试用例3：remove不存在的key ===");
        System.out.println("remove(a): " + map.remove("a")); // null
        System.out.println("remove(b): " + map.remove("b")); // null
        System.out.println("size: " + map.getCount()); // 0

        // 测试用例4：空map
        System.out.println("\n=== 测试用例4：空map ===");
        System.out.println("isEmpty: " + map.isEmpty()); // true
        System.out.println("get(a): " + map.get("a")); // null
    }
}