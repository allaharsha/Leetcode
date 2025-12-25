import java.util.HashMap;
import java.util.Map;

class LRUCache {
    int capacity;
    Node first;
    Node last;
    Map<Integer,Node> lruMap = new HashMap<>();
    Map<Integer,Integer> cacheMap = new HashMap<>();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Integer value = cacheMap.get(key);
        if(value == null){
            return -1;
        } else {
            updateUsage(key);
            return value;
        }
    }
    
    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            cacheMap.remove(key);
            updateUsage(key);
        } else if (cacheMap.size() < capacity){
            addInLruMap(key);
        } else {
            removeLeastUsed();
            addInLruMap(key);
        }
        cacheMap.put(key,value);
    }
    
    private void addInLruMap(int key){
        Node node = new Node();
        node.key = key;
        if(first == null && last == null){
            first = node;
            last = node;
            node.next = node;
            node.prev = node;
        } else {
            node.next = first;
            node.prev = last;
            
            last.next = node;
            first.prev = node;
            
            first = node;
        }
        lruMap.put(key,node);
    }
    
    private void removeLeastUsed(){
        Node current = last.prev;
        first.prev = current;
        current.next = first;
        
        lruMap.remove(last.key);
        cacheMap.remove(last.key);
        last = current;
    }
    
    private void updateUsage(int key){
        if(capacity == 2){
            if(last.key == key){
                Node temp = first;
                first = last;
                last = temp;
            }
        } else {
            if(last.key == key){
                first = last;
                last = last.prev;
            } else if(first.key != key){
                Node current = lruMap.get(key);
                current.prev.next = current.next;
                current.next.prev = current.prev;

                current.next = first;
                current.prev = last;
                first.prev = current;
                last.next = current;

                first = current;
                if(last.key == current.key)
                    last = last.prev;
            }
        }
    }
    

class Node{
    int key;
    Node prev;
    Node next;
}
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */