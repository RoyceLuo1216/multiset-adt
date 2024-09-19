public class Tree {

    private Integer root;
    private List<Tree> subtrees;

    public new (){
        this.root = null;
        this.subtrees = new ArrayList<Tree>();
    }

    public new (Integer root, List<Tree> subtrees){
        this.root = root;
        if (subtrees == null){
            this.subtrees = new ArrayList<>();
        }
        else {
            this.subtrees = subtrees;
        }
    }

    public boolean is_empty(){
        return this.root == null;
    }

    public int size(){
        if (this.subtrees == null){
            return 0;
        }
        else {
            int size = 1;
            for (Tree subtree : this.subtrees) {
                size += subtree.size();
            }
        }
    }

    public int count(Integer item){
        if (this.subtrees == null){
            return 0;
        }
        else{
            int num = 0;
            if this.root == item{
                num ++;
            }
            for (Tree subtree : this.subtrees) {
                num += subtree.count(item);
            }
        }
        return num;
    }

    public String toString(){
        return this.toString_indented();
    }

    public String toString_indented(){
        if this.root == null{
            return "";
        }
        else {
            String s = toString(this.root) + '\n'
            for (Tree subtree : this.subtrees) {
                s += subtree.toString_indented(1);
            }
        }
        return s
    }

    public String toString_indented(Integer depth){
        if this.root == null{
            return "";
        }
        else {
            String s = ' ' * depth + toString(this.root) + '\n';
            for (Tree subtree : this.subtrees) {
                s += subtree.toString_indented(depth + 1);
            }
        }
        return s
    }

    public float average(){
        if (this.root == null){
            return 0;
        }
        else {
           return (float) this.average_helper_total() / this.average_helper_size();
        }
    }

    private int average_helper_total(){
        if (this.root == null){
            return 0;
        }
        else {
            int total = this.root;
            int size = 1;
            for (Tree subtree : this.subtrees) {
                int subtree_total = subtree.average_helper_total();
                total += subtree_total;
            }
            return total;
        }
    }

    private int average_helper_size(){
        if (this.root == null){
            return 0;
        }
        else {
            int size = 1;
            for (Tree subtree : this.subtrees) {
                int subtree_size = subtree.average_helper_size();
                size += subtree_size;
            }
            return size;
        }
    }

    public boolean equals(Tree other){
        if (this.root == null) & (other.root == null){
            return true;
        }
        elif (this.root == null) || (other.root == null){
            return false;
        }
        else{
            if (!this.root.equals(other.root)){
                return false;
            }

            elif (this.subtrees.size() != other.subtrees.size()){
                return false;
            }
            return this.subtrees.equals(other.subtrees);
        }
    }

    public boolean contains(Integer item){
        if (this.root == null){
            return false;
        }

        if this.root == item{
            return true;
        }
        else{
            for (Tree subtree : this.subtrees) {
                if (subtree.contains(item)){
                    return true;
                }
            }
            return false;
        }
    }

    public List<int> leaves(){
        if (this.root == null){
            return null;
        }
        else if (this.subtrees == null){
            List<int> leaves = new ArrayList<>();
            leaves.add(this.root);
            return leaves;
        }
        else{
            List<int> leaves = new ArrayList<>();
            for (Tree subtree : this.subtrees) {
                for (int leaf : subtree){
                    leaves.add(leaf);
                }
            }
            return leaves;
        }
    }

    public boolean delete_item(Integer item){
        if (this.root == null){
            return false;
        }
        else if (this.root == item){
            this.delete_root();
            return true;
        }
        else{
            for (Tree subtree : this.subtrees) {
                boolean deleted = subtree.delete_item(item);
                if (deleted & subtree.is_empty()){
                    boolean removed = this.subtrees.remove(subtree);
                    return true;
                }
                if (deleted){
                    return true;
                }
            }

            return false;
        }
    }

    private void delete_root(){
        if (this.subtrees == null){
            this.root = null;
        }
        else{
            Tree chosen_subtree = this.subtrees.remove(-1);

            this.root = chosen_subtree.root;
            for (Tree subtree : chosen_subtree.subtrees) {
                this.subtree.add(subtree)
            }
        }
    }

    private int extract_leaf(){
        if (this.subtrees == null){
            int old_root = this.root;
            this.root = null;
            return old_root;
        }
        else{
            int leaf = this.subtrees.get(0).extract_leaf();
            if first.is_empty(){
                this.subtrees.remove(0)
            }
            return leaf;
        }
    }

    public void insert(Integer item){
        if (this.root == null){
            this.root = item;
        }
        else if (this.subtrees == null){
            this.subtrees = new ArrayList<Tree>();
            Tree tree = new Tree(item)
            this.subtrees.add(tree)
        }
        else{
            Random rand = new Random();
            int random_int = rand.nextint(3);
            if (random_int == 0){
                Tree tree = new Tree(item);
                this.subtrees.add(tree)
            }
            else{
                int subtree_index = rand.nextint(this.subtrees.size());
                this.subtrees.get(subtree_index).insert(item);
            }
        }
    }

    public boolean insert_child(Integer item, Integer parent){
        if (this.root== null){
            return false;
        }
        else if (this.root == parent){
            Tree tree = new Tree(item)
            this.subtrees.add(tree);
            return true;
        }
        else{
            for (Tree subtree : this.subtrees) {
                if (subtree.insert_child(item, parent)){
                    return true;
                }
            }
            return false;
        }
    }
}
