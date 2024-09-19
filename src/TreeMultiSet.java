public class TreeMultiSet extends MultiSet {

    // TODO add a Tree object as a private instance variable for this class.
    /**
     * Add the given item to this multiset.
     *
     * @param item the item to add
     */
    private Tree tree;

    @Override
    void add(Integer item) {
        this.tree.insert(item);
    }

    void new(){
        tree = new Tree();
    }

    void remove(Integer item) {
        this.tree.delete_item(item);
    }

    boolean contains(Integer item) {
        return this.tree.contains(item);
    }

    boolean is_empty(){
        return this.tree.is_empty();
    }

    int count(int item){
        return this.tree.count(item);
    }

    int size(){
        return this.tree.size();
    }
}
