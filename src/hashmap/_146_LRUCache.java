package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shengwei_Wang on 9/29/16.
 */
public class _146_LRUCache {
    Node head;
    Node end;
    Map<Integer, Node> map;
    int capacity;
    public _146_LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        head = new Node(0, 0);
        end = new Node(0, 0);
        head.next = end;
        end.pre = head;
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
            cur.pre = head;
            cur.next = head.next;
            head.next.pre = cur;
            head.next = cur;
            if(map.size() > capacity){
                map.remove(end.pre.key);
                end.pre = end.pre.pre;
                end.pre.next = end;
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
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        cur.next = head.next;
        cur.pre = head;
        head.next.pre = cur;
        head.next = cur;
    }
}
