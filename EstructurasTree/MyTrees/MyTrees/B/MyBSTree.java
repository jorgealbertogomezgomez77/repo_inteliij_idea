package MyTrees.B;

import java.util.*;

public class MyBSTree<K,V> implements MyTree<K,V>{
    private BSTNode<K,V> _root;
    private int _size;
    private Comparator<K> _comparator;
    private int mod = 0;

    public MyBSTree(Comparator<K> comparator){
        _comparator = comparator;
    }

    public Node<K,V> root(){
        return _root;
    }

    public int size(){
        return _size;
    }

    public boolean containsKey(K key){
        if(_root == null){
            return false;
        }

        BSTNode<K,V> node = _root;

        while (node != null){
            int comparison = compare(key, node.key());

            if(comparison == 0){
                return true;
            }else if(comparison <= 0){
                node = node._left;
            }else {
                node = node._right;
            }
        }

        return false;
    }

    private int compare(K k1, K k2){
        if(_comparator != null){
            return _comparator.compare(k1,k2);
        }
        else {
            Comparable<K> comparable = (Comparable<K>)k1;
            return comparable.compareTo(k2);
        }
    }


    public V get(K key){
        Node<K,V> node = node(key);

        return node != null ? node.value() : null;
    }

    private BSTNode<K,V> node(K key){
        if(_root != null){
            BSTNode<K,V> node = _root;

            while (node != null){
                int comparison = compare(key, node.key());

                if(comparison == 0){
                    return node;
                }else if(comparison <= 0){
                    node = node._left;
                }else {
                    node = node._right;
                }
            }
        }

        return null;
    }

    public void add(K key, V value){
        if(key == null){
            throw new IllegalArgumentException("key");
        }

        if(_root == null){
            _root = new BSTNode<K, V>(key, value);
        }

        BSTNode<K,V> prev = null, curr = _root;
        boolean lastChildLeft = false;
        while(curr != null){
            int comparison = compare(key, curr.key());
            prev = curr;

            if(comparison == 0){
                curr._value = value;
                return;
            }else if(comparison < 0){
                curr = curr._left;
                lastChildLeft = true;
            }
            else{
                curr = curr._right;
                lastChildLeft = false;
            }
        }

        mod++;
        if(lastChildLeft){
            prev._left = new BSTNode<K, V>(key, value);
        }else {
            prev._right = new BSTNode<K, V>(key, value);
        }
    }

    private void removeNode(BSTNode<K,V> curr){
        if(curr.left() == null && curr.right() == null){
            if(curr == _root){
                _root = null;
            }else{
                if(curr.isLeft()) curr._parent._left = null;
                else curr._parent._right = null;
            }
        }
        else if(curr._left == null && curr._right != null){
            curr._key = curr._right._key;
            curr._value = curr._right._value;
            curr._left = curr._right._left;
            curr._right = curr._right._right;
        }
        else if(curr._left != null && curr._right == null){
            curr._key = curr._left._key;
            curr._value = curr._left._value;
            curr._right = curr._left._right;
            curr._left = curr._left._left;
        }
        else { // both left & right exist
            BSTNode<K,V> x = curr._left;
            // find right-most node of left sub-tree
            while (x._right != null){
                x = x._right;
            }
            // move that to current
            curr._key = x._key;
            curr._value = x._value;
            // delete duplicate data
            removeNode(x);
        }
    }


    public V remove(K key){
        BSTNode<K,V> curr = _root;
        V val = null;
        while(curr != null){
            int comparison = compare(key, curr.key());
            if(comparison == 0){
                val = curr._value;
                removeNode(curr);
                mod++;
                break;
            }else if(comparison < 0){
                curr = curr._left;
            }
            else{
                curr = curr._right;
            }
        }

        return val;
    }

    public Iterator<MyTree.Node<K,V>> iterator(){
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Node<K,V>>{
        int _startMod;
        Stack<BSTNode<K,V>> _stack;

        public MyIterator(){
            _startMod = MyBSTree.this.mod;
            _stack = new Stack<BSTNode<K, V>>();

            BSTNode<K,V> node = MyBSTree.this._root;
            while (node != null){
                _stack.push(node);
                node = node._left;
            }
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }

        public boolean hasNext(){
            if(MyBSTree.this.mod != _startMod){
                throw new ConcurrentModificationException();
            }

            return !_stack.empty();
        }

        public Node<K,V> next(){
            if(MyBSTree.this.mod != _startMod){
                throw new ConcurrentModificationException();
            }

            if(!hasNext()){
                throw new NoSuchElementException();
            }

            BSTNode<K,V> node = _stack.pop();
            BSTNode<K,V> x = node._right;
            while (x != null){
                _stack.push(x);
                x = x._left;
            }

            return node;
        }
    }

    @Override
    public String toString(){
        if(_root == null) return "[]";

        return _root.toString();
    }

    private static class BSTNode<K,V> implements Node<K,V>{
        K _key;
        V _value;
        BSTNode<K,V> _left, _right, _parent;

        public BSTNode(K key, V value){
            if(key == null){
                throw new IllegalArgumentException("key");
            }

            _key = key;
            _value = value;
        }

        public K key(){
            return _key;
        }

        public V value(){
            return _value;
        }

        public Node<K,V> left(){
            return _left;
        }

        public Node<K,V> right(){
            return _right;
        }

        public Node<K,V> parent(){
            return _parent;
        }

        boolean isLeft(){
            if(_parent == null) return false;

            return _parent._left == this;
        }

        boolean isRight(){
            if(_parent == null) return false;

            return _parent._right == this;
        }

        @Override
        public boolean equals(Object o){
            if(o == null){
                return false;
            }

            try{
                BSTNode<K,V> node = (BSTNode<K,V>)o;
                return node._key.equals(_key) && ((_value == null && node._value == null) || (_value != null && _value.equals(node._value)));
            }catch (ClassCastException ex){
                return false;
            }
        }

        @Override
        public int hashCode(){
            int hashCode = _key.hashCode();

            if(_value != null){
                hashCode ^= _value.hashCode();
            }

            return hashCode;
        }

        @Override
        public String toString(){
            String leftStr = _left != null ? _left.toString() : "";
            String rightStr = _right != null ? _right.toString() : "";
            return "["+leftStr+" "+_key+" "+rightStr+"]";
        }
    }
}
