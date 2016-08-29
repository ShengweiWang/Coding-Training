import jdk.internal.util.xml.impl.Pair;

import java.util.*;


/**
 * Created by Shengwei_Wang on 8/28/16.
 */
public class _146_LRUCache {
    Node head;
    Node end;
    HashMap<Integer, Node> hashMap;
    int capacity;

    public _146_LRUCache(int capacity) {
        this.capacity = capacity;
        head = null;
        end = null;
        hashMap = new HashMap<>();
    }

    public int get(int key){
        Node cur = hashMap.getOrDefault(key, null);
        if(cur == null)
            return -1;
        else {
            moveNodeToHead(cur);
            return cur.value;
        }
    }

    public void set(int key, int value){
        Node cur = hashMap.getOrDefault(key, null);
        if (cur != null){
            cur.value = value;
            moveNodeToHead(cur);
            return;
        }
        Node temp = new Node();
        temp.key = key;
        temp.value = value;
        temp.pre = null;
        temp.next = head;


        if (hashMap.size() == capacity){
            hashMap.remove(end.key);
            end = end.pre;
            if(end != null)
                end.next = null;
        }
        head = temp;
        hashMap.put(key, temp);
        if (end == null){
            end = head;
        }

    }

    public void moveNodeToHead(Node cur){

        if(head != cur) {
            if (cur == end) {
                end = cur.pre;
                cur.pre.next = null;
            } else {
                cur.pre.next = cur.next;
                cur.next.pre = cur.pre;
            }
            cur.next = head;
            cur.pre = null;
            head.pre = cur;
            head = cur;
        }
    }

    public class Node{
        Node pre;
        Node next;
        int key;
        int value;
    }
}
