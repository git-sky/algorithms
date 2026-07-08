package cn.com.sky.algorithms.searching.dynamics.btree;
import java.util.HashMap;
import java.util.Map;


/**
 * <pre>
 * B+树（B+ Tree）【Hard】
 *
 * 题目：实现B+树的插入、查找操作
 *
 * 算法原理：
 * 1. B树的变体，所有数据存储在叶子节点
 * 2. 内部节点只存储索引（关键字）
 * 3. 叶子节点通过双向链表连接
 * 4. 叶子节点按关键字有序排列
 *
 * B+树 vs B树：
 * - B+树：查询稳定（必须到叶子），范围查询效率高（链表顺序访问）
 * - B树：查询不稳定（可能提前命中），范围查询需要回溯
 *
 * 为什么数据库选择B+树？
 * 1. 查询性能稳定：每次查询都走相同路径长度
 * 2. 范围查询高效：叶子节点链表支持顺序扫描
 * 3. 缓存友好：内部节点只存索引，一个页能放更多索引
 *
 * 应用：MySQL InnoDB索引、MongoDB索引
 *
 * 时间复杂度：查找 O(log n)，范围查询 O(log n + k)
 * 空间复杂度：O(n)
 *
 * 参考：http://en.wikipedia.org/wiki/B%2B_tree
 *
 * @author bo.fangbo
 * </pre>
 */
public class BPlusTree <T extends Comparable<T>, V> {

    /**
     * the branching factor of the tree, measuring the capacity of nodes.
     * 
     * a) the number of children for internal node must be in scope [ Math.ceil(factor/2), factor ].
     * b) the number of children for leaf node must be in scope [ Math.floor(factor/2), factor-1 ]
     */
    private int factor;
    
    private static final int DEFAULT_FACTOR = 5;
    
    private int MIN_CHILDREN_FOR_INTERNAL;
    private int MAX_CHILDREN_FOR_INTERNAL;
    private int MIN_FOR_LEAF;
    private int MAX_FOR_LEAF;
    
    private Node<T, V> root = null;
    
    public BPlusTree() {
        this(DEFAULT_FACTOR);
    }
    
    public BPlusTree(int factor) {
        this.factor = factor;
        
        this.MIN_CHILDREN_FOR_INTERNAL = Double.valueOf(Math.ceil(1.0 * this.factor / 2)).intValue();
        this.MAX_CHILDREN_FOR_INTERNAL = this.factor;
        this.MIN_FOR_LEAF = Double.valueOf(Math.floor(1.0 * this.factor / 2)).intValue();
        this.MAX_FOR_LEAF = this.factor - 1;
        
        this.root = new LeafNode<T, V>();
    }
    
    public void set(T key, V value) {
        if (key == null)    throw new NullPointerException("must not be null for key.");
        Node node = this.root.insert(key, value);
        
        if (node != null) this.root = node;
    }
    
    public V get(T key) {
        return this.root.get(key);
    }
    
    public int height() {
        int height = 1;
        Node node = this.root;
        while( !(node instanceof LeafNode)) {
            height++;
            node = ((InternalNode)node).pointers[0];
        }
        
        return height;
    }
    
    /**
     * the abstract node definition, define the operation of leaf node and internal node.
     * 
     * @author bo.fangbo
     *
     * @param <T>
     * @param <V>
     */
    abstract class Node<T extends Comparable<T>, V> {
        
        protected Node<T, V> parent;
        
        protected Object[] keys;
        
        protected int size;
        
        
        /**
         * if new parent node is created when insert the key-value, the created parent node is returned,
         * in other case, this method return null.
         * 
         * @param key
         * @param value
         * @return
         */
        abstract Node<T, V> insert(T key, V value);
        
        abstract V get(T key);
    }
    
    /**
     * the internal node which manages the pointers.
     * 
     * @author bo.fangbo
     *
     * @param <T>
     * @param <V>
     */
    class InternalNode<T extends Comparable<T>, V> extends Node<T, V> {
        private Node<T, V>[] pointers;
        
        public InternalNode() {
            this.size = 0;
            this.pointers = new Node[MAX_CHILDREN_FOR_INTERNAL + 1];
            this.keys = new Object[MAX_CHILDREN_FOR_INTERNAL];
        }
        
        public Node<T, V> insert(T key, V value) {
            int i = 0;
            for (; i < this.size; i++) {
                if ( key.compareTo( (T)this.keys[i] ) < 0 )  break;
            }
            
            return this.pointers[i].insert(key, value);
        }
        
        public V get(T key) {
            int i = 0;
            for (; i < this.size; i++) {
                if ( key.compareTo( (T)this.keys[i] ) < 0)  break;
            }
            
            return this.pointers[i].get(key);
        }
        
        /**
         * 
         * @param key
         * @param leftChild
         * @param rightChild
         * @return
         */
        private Node<T, V> insert(T key, Node<T, V> leftChild, Node<T, V> rightChild){
            if (this.size == 0) {
                this.size++;
                this.pointers[0] = leftChild;
                this.pointers[1] = rightChild;
                this.keys[0] = key;
                
                leftChild.parent = this;
                rightChild.parent = this;
                
                return this;
            }
            
            Object[] newKeys = new Object[MAX_CHILDREN_FOR_INTERNAL + 1];
            Node[] newPointers = new Node[MAX_CHILDREN_FOR_INTERNAL + 2];
            
            int i = 0;
            for(; i < this.size; i++) {
                T curKey = (T)this.keys[i];
                if (curKey.compareTo(key) > 0) break;
            }
            
            System.arraycopy(this.keys, 0, newKeys, 0, i);
            newKeys[i] = key;
            System.arraycopy(this.keys, i, newKeys, i + 1, this.size - i);
            
            System.arraycopy(this.pointers, 0, newPointers, 0, i + 1);
            newPointers[i + 1] = rightChild;
            System.arraycopy(this.pointers, i + 1, newPointers, i + 2, this.size - i);

            this.size++;
            if(this.size <= MAX_CHILDREN_FOR_INTERNAL) {
                System.arraycopy(newKeys, 0, this.keys, 0, this.size);
                System.arraycopy(newPointers, 0, this.pointers, 0, this.size + 1);
                return null;
            }
            
            int m = (this.size / 2);
            
            // split the internal node
            InternalNode<T, V> newNode = new InternalNode<T, V>();
            
            newNode.size = this.size - m - 1;
            System.arraycopy(newKeys, m + 1, newNode.keys, 0, this.size - m - 1);
            System.arraycopy(newPointers, m + 1, newNode.pointers, 0, this.size - m);
            
            // reset the children's parent to the new node.
            for(int j = 0; j <= newNode.size; j++) {
                newNode.pointers[j].parent = newNode;
            }
            
            this.size = m;
            this.keys = new Object[MAX_CHILDREN_FOR_INTERNAL];
            this.pointers = new Node[MAX_CHILDREN_FOR_INTERNAL];
            System.arraycopy(newKeys, 0, this.keys, 0, m);
            System.arraycopy(newPointers, 0, this.pointers, 0, m + 1);
            
            if (this.parent == null) {
                this.parent = new InternalNode<T, V>();
            }
            newNode.parent = this.parent;
            
            return ((InternalNode<T, V>)this.parent).insert((T)newKeys[m], this, newNode);
        }
    }
    
    /**
     * leaf node, store the keys and actual values.
     * 
     * @author bo.fangbo
     *
     * @param <T>
     * @param <V>
     */
    class LeafNode<T extends Comparable<T>, V> extends Node<T, V> {
        private Object[] values;
        
        public LeafNode() {
            this.size = 0;
            this.keys = new Object[MAX_FOR_LEAF];
            this.values = new Object[MAX_FOR_LEAF];
            this.parent = null;
        }
        
        public Node<T, V> insert(T key, V value) {
            Object[] newKeys = new Object[MAX_FOR_LEAF + 1];
            Object[] newValues = new Object[MAX_FOR_LEAF + 1];
            
            int i = 0;
            for (; i < this.size; i++) {
                T curKey = (T) this.keys[i];
                
                if (curKey.compareTo(key) == 0) {
                    this.values[i] = value;
                    return null;
                }
                
                if (curKey.compareTo(key) > 0) break;
            }
            
            System.arraycopy(this.keys, 0, newKeys, 0, i);
            newKeys[i] = key;
            System.arraycopy(this.keys, i, newKeys, i + 1, this.size - i);
            
            System.arraycopy(this.values, 0, newValues, 0, i);
            newValues[i] = value;
            System.arraycopy(this.values, i, newValues, i + 1, this.size - i);
            
            this.size++;
            
            if (this.size <= MAX_FOR_LEAF){
                System.arraycopy(newKeys, 0, this.keys, 0, this.size);
                System.arraycopy(newValues, 0, this.values, 0, this.size);
                return null;
            }

            // need split this node
            int m = this.size / 2;
            
            this.keys = new Object[MAX_FOR_LEAF];
            this.values = new Object[MAX_FOR_LEAF];
            System.arraycopy(newKeys, 0, this.keys, 0, m);
            System.arraycopy(newValues, 0, this.values, 0, m);
            
            LeafNode<T, V> newNode = new LeafNode<T, V>();
            newNode.size = this.size - m;
            System.arraycopy(newKeys, m, newNode.keys, 0, newNode.size);
            System.arraycopy(newValues, m, newNode.values, 0, newNode.size);
            
            this.size = m;
            
            if (this.parent == null) {
                this.parent = new InternalNode<T, V>();
            }
            newNode.parent = this.parent;
            
            return ((InternalNode<T, V>)this.parent).insert((T)newNode.keys[0], this, newNode);
        }
        
        public V get(T key) {
            // two branch search
            if (this.size == 0) return null;
            
            int start = 0;
            int end = this.size;
            
            int middle = (start + end) / 2;
            
            while (start < end) {
                T middleKey = (T)this.keys[middle];
                if (key.compareTo(middleKey) == 0){
                    break;
                }
                
                if (key.compareTo(middleKey) < 0) {
                    end = middle;
                } else {
                    start = middle;
                }
                
                middle = (start + end) / 2;
            }
            
            T middleKey = (T) this.keys[middle];
            
            return middleKey.compareTo(key) == 0 ? (V) this.values[middle] : null;
        }
    }
    

    public static void main(String[] args) {
        BPlusTree<Integer, String> myTree = new BPlusTree<Integer, String>(8);
        
        int max = 1000000;
        long start = System.currentTimeMillis();
        for(int i = 0; i < max; i++) {
            myTree.set(i, String.valueOf(i));
        }
        System.out.println("time cost with BPlusTree: " + (System.currentTimeMillis() - start));
        System.out.println("Data has been inserted into tree");
        
        System.out.println("height: " + myTree.height());
        
        start = System.currentTimeMillis();
        Map<Integer, String> hashMap = new HashMap<Integer, String>();
        for (int i = 0; i < max; i++) {
            hashMap.put(i, String.valueOf(i));
        }
        System.out.println("time cost with HashMap: " + (System.currentTimeMillis() - start));
        
        for (int i = 0; i < max; i++) {
            if (!String.valueOf(i).equals(myTree.get(i))) {
                System.err.println("error for: " + i);
            }
        }
        
        System.out.println("Success");
    }
}