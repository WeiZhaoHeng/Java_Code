import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/15
 * Time: 9:41
 */
public class Test {
    public static void main2(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("1","松江");
        map.put("2","刘备");
        map.put("3","张飞");
        map.put("4","关羽");
        map.put("5","曹操");
        System.out.println(map);
        String str = map.getOrDefault("2","唐三藏");
        System.out.println(str);
        System.out.println(map.containsKey("5"));
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey()+ " "+entry.getValue());
        }


    }


    public static void main1(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("hi");
        collection.add("ni");
        collection.add("hao");
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
        System.out.println(collection);
        collection.remove("ni");
        System.out.println(collection);
        collection.add("wo");
        collection.add("shi");
        collection.add("shui");
        Object[] str = collection.toArray();
        System.out.println(Arrays.toString(str));
        //一个类只要实现了Iterable(迭代)接口才能用foreach;
        for (String s:collection) {
            System.out.println(s);
        }
    }
}
