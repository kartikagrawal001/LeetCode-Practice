class LRUCache {
    class Node{
        int key,value;
        Node prev,next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    Map<Integer,Node> cache;
    Node head,tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key) {
        if(!cache.containsKey(key))return -1;
        Node node = cache.get(key);
        remove(node);
        insert(node);
        return node.value;
    }
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            insert(node);
            return;
        }
        Node node = new Node(key,value);
        cache.put(key,node);
        insert(node);
        if(cache.size()>capacity){
            Node lru = tail.prev;
            int k = lru.key;
            remove(lru);
            cache.remove(k);
        }
    }
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void insert(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */