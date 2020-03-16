import javafx.scene.chart.LineChart;
import org.omg.PortableInterceptor.INACTIVE;

import java.lang.management.ManagementFactory;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2020/2/20
 * Time: 14:01
 */
public class MapSet {
    //只出现一次的数字
    public  static int singleNumber(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length;i++){
            if(!set.add(nums[i])){
                set.remove(nums[i]);
            }
        }
        Iterator<Integer> integer = set.iterator();
        return integer.next();
    }

    static class Node{
        private int val;
        private Node next;
        private Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //复制带随机指针的链表
    public static Node copyRandomList(Node head){
        if(head == null){
            return null;
        }
        Node cur = head;
        Map<Node,Node> map = new HashMap<>();
        while(cur != null){
            Node node = new Node(cur.val);
            map.put(cur,node);
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }


    //宝石与石头
    public static int numJeweLsInStones(String J,String S){
        Set<Character> set = new HashSet<>();
        for(int i = 0 ; i < J.length();i++){
            set.add(J.charAt(i));
        }
        int count = 0;
        for(int i = 0; i < S.length();i++){
            if(set.contains(S.charAt(i))){
                count++;
            }
        }
        return count;
    }


    //旧键盘上坏了几个键，于是在敲一段文字的时候对应的字符就不会出现。
    //现在给出应该输入的一段文字、以及实际被输入的文字，请你列出肯定坏掉的那些键。
    public static void breaken(String s1,String s2){
        Set<Character> setAct = new HashSet<>();
        for(char ch: s2.toUpperCase().toCharArray()){
            setAct.add(ch);
        }
        Set<Character> setBreak = new HashSet<>();
        for(char ch: s1.toUpperCase().toCharArray()){
            if(setAct.add(ch)){
                setBreak.add(ch);
                System.out.print(ch);
            }
        }
        System.out.println();
    }


    //TopK 问题
    public static Integer[] findTopK(int[] array,int k){
        //该堆建立默认是小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>
                (k, new Comparator<Integer>() {
                    //使用 Comparator 可以用来自定义建立大堆还是小堆
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);//小堆
            }
        });
        for(int i = 0 ; i < array.length ; i++ ){
            if(minHeap.size() < k){
                minHeap.add(array[i]);
            }else{
                Integer top = minHeap.peek();
                if(top != null && top > array[i]){
                    minHeap.poll();
                    minHeap.add(array[i]);
                }
            }
        }
        Integer[] integers = new Integer[k];
        for(int i = 0 ; i < integers.length;i++){
            integers[i] = minHeap.peek();
            minHeap.poll();
        }
        return integers;
    }



    //给一非空的单词列表，返回前 k 个出现次数最多的单词。
    //返回的答案应该按单词出现频率由高到低排序。
    // 如果不同的单词有相同出现频率，按字母顺序排序。
    public static List<String> topKFrequent(String[] words, int k) {
        //将 单词--个数 以 key--value 放入 map 中
        Map<String,Integer> map = new HashMap<>();
        for(String s : words){
            if(map.get(s) == null){
                map.put(s,1);
            }else{
                map.put(s,map.get(s)+1);
            }
        }

        //找前 k 个出现最多的
        //建以 value 为基准的小堆
        PriorityQueue<Map.Entry<String,Integer>> minHeap = new PriorityQueue<>
                (k, new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    //以下顺序仅仅是 堆 在进行内部调整时的顺序
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        //如果有两个单词，出现的频率相同
                        if(o1.getValue().equals(o2.getValue())){
                            //按照单词首字母的顺序，从大到小排列（z--a）
                            return o2.getKey().compareTo(o1.getKey());
                        }
                        //按照出现的次数，从小到大排列
                        return o1.getValue().compareTo(o2.getValue());
                    }
                });

        //处理数据
        for(Map.Entry<String,Integer> entry : map.entrySet()){

            if(minHeap.size() < k){//让前 k 个数据入堆
                minHeap.add(entry);
            }else{//遍历后面的数据进行筛选
                Map.Entry<String,Integer> top = minHeap.peek();//取堆顶元素
                if(top != null && top.getValue().equals(entry.getValue())){//堆顶元素与待处理元素 value 相同
                    if(top.getKey().compareTo(entry.getKey()) > 0){//堆顶元素比待处理元素的 key 值的首字母大
                        minHeap.poll();
                        minHeap.add(entry);
                    }
                }else{//堆顶元素与待处理元素 value 不相同
                    if(top != null && top.getValue() < entry.getValue()){// value 大的被保留
                        minHeap.poll();
                        minHeap.add(entry);
                    }
                }
            }
        }
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < k;i++){
            String pop = minHeap.peek().getKey();
            list.add(0,pop);
            minHeap.poll();
        }
        return list;

    }



    public static void main(String[] args) {
        int[] array = {12,34,546,234,678,23,2956,456,98,78};
        Integer[] ret = findTopK(array,4);
        System.out.println(Arrays.toString(ret));
    }


}
