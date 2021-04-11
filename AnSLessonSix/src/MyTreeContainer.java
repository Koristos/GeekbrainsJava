public class MyTreeContainer <T extends Comparable <? super T>> {
    private T value;
    private MyTreeContainer<T> left;
    private MyTreeContainer<T> right;
    private MyTreeContainer<T> root;

    MyTreeContainer(T value,  MyTreeContainer<T> left, MyTreeContainer<T> right, MyTreeContainer<T> root){
        this.value=value;
        this.left=left;
        this.root=root;
    }

    protected MyTreeContainer<T> getPath (T value, int maxRow) {
        if (maxRow==0)return null;
        MyTreeContainer <T> result=null;
        if (value.compareTo(this.value)==0) return this;
        if (value.compareTo(this.value)<0) {
            if (this.left!=null) result=this.left.getPath(value, maxRow-1);
            else result=new MyTreeContainer<T>(value, null, null, this);
        }
        if (value.compareTo(this.value)>0) {
            if (this.right!=null) result=this.right.getPath(value, maxRow-1);
            else result=new MyTreeContainer<T>(value, null, null, this);
        }
        return result;
    }

    protected boolean updateBranch (MyTreeContainer<T> toAdd){
        if(toAdd.getValue().compareTo(this.value)==0) {
            this.value=toAdd.getValue();
            return false;
        }
        else if (toAdd.getValue().compareTo(this.value)<0) this.left=toAdd;
        else if (toAdd.getValue().compareTo(this.value)>0) this.right=toAdd;
        return true;
    }

    public int getBalance (){
        int right=0;
        int left=0;
        if (this.getRight()!=null){
            int branchBalance=this.getRight().getBalance();
            if (branchBalance<0) return -1;
            right+=1+branchBalance;
        }
        if (this.getLeft()!=null){
            int branchBalance=this.getLeft().getBalance();
            if (branchBalance<0) return -1;
            left+=1+branchBalance;
        }
        if (Math.abs((right-left))>1) return -1;
        return right+left;
    }

    public T getValue() {
        return value;
    }

    public MyTreeContainer<T> getLeft() {
        return left;
    }

    public MyTreeContainer<T> getRight() {
        return right;
    }

    public MyTreeContainer<T> getRoot() {
        return root;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setLeft(MyTreeContainer<T> left) {
        this.left = left;
    }

    public void setRight(MyTreeContainer<T> right) {
        this.right = right;
    }

    public void setRoot(MyTreeContainer<T> root) {
        this.root = root;
    }
}
