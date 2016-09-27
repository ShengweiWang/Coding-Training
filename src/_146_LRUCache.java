import jdk.internal.util.xml.impl.Pair;

import java.util.*;


/**
 * Created by Shengwei_Wang on 8/28/16.
 */
public class _146_LRUCache {
    Node head;
    Node end;
    Map<Integer, Node> map;
    int capacity;
    public _146_LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        head = null;
        end = null;
    }

    public int get(int key){
        if(!map.containsKey(key))
            return -1;
        else {
            Node cur = map.get(key);
            moveNodeToHead(cur);
            return cur.val;
        }
    }

    public void set(int key, int value){
        if(map.containsKey(key)){
            Node cur = map.get(key);
            cur.val = value;
            moveNodeToHead(cur);
            return;
        } else {
            Node cur = new Node(key, value);
            map.put(key, cur);
            cur.next = head;
            if(head == null){
                head = cur;
                end = cur;
            } else {
                head.pre = cur;
                head = cur;
            }
            if(map.size() > capacity){
                map.remove(end.key);
                end = end.pre;
                end.next = null;
            }

        }
    }


    class Node{
        int val;
        int key;
        Node pre;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }

    public void moveNodeToHead(Node cur){
        if(head != cur){
            if(cur == end)
                end = cur.pre;
            if(cur.pre != null)
                cur.pre.next = cur.next;
            if(cur.next != null)
                cur.next.pre = cur.pre;
            cur.next = head;
            cur.pre = null;
            head.pre = cur;
            head = cur;
        }
    }

    public void print(){
        Node cur = head;
        while(cur != null) {
            System.out.println(cur.key + " " + cur.val);
            cur = cur.next;
        }
        System.out.println("tail is " + end.key + "  "  + end.val);
    }
}
