import java.util.Stack;

public class MyTreeRealisation <T extends Comparable <? super T>> implements MyTree <T>{

    private  int size;
    private MyTreeContainer root;
    private int maxRow;

    MyTreeRealisation (){
        this.size=0;
        this.root=null;
        this.maxRow=3;
    }

    @Override
    public boolean add(T value) {

        if (isEmpty()){
            this.root=new MyTreeContainer(value, null, null, null);
            size++;
        } else {
            MyTreeContainer <T> toAdd = root.getPath(value,this.maxRow);
            if (toAdd==null) return false;
            if (toAdd.getRoot()==null) {
                toAdd.updateBranch(toAdd);
                return true;
            }
            if (toAdd.getRoot().updateBranch(toAdd)) size++;
        }
        return true;
    }


    @Override
    public boolean contains(T value) {
        if (isEmpty()) return false;
        MyTreeContainer <T> result = root.getPath(value,this.maxRow+1);
        if (result.getLeft()==null&&result.getRight()==null) return false;
        return true;
    }

    @Override
    public boolean remove(T value) {
        if (!contains(value)) return false;

        MyTreeContainer <T> result = root.getPath(value,this.maxRow);

        if (result.getRight()==null && result.getLeft()==null){
            if (result.getRoot()==null) this.root=null;
            else if (result.getRoot().getValue().compareTo(result.getValue())<0){
                result.getRoot().setRight(null);
            }else result.getRoot().setLeft(null);

        }else if (result.getRight()==null){
            if (result.getRoot()==null) {
                this.root=result.getLeft();
                result.getLeft().setRoot(null);
            } else {
                result.getRoot().updateBranch(result.getLeft());
                result.getLeft().setRoot(result.getRoot());
            }

        }else if (result.getLeft()==null){
            if (result.getRoot()==null) {
                this.root=result.getRight();
                result.getRight().setRoot(null);
            } else {
                result.getRoot().updateBranch(result.getRight());
                result.getRight().setRoot(result.getRoot());
            }

        }else if (result.getRight()!=null && result.getLeft()!=null){
            MyTreeContainer <T> newNode = findMinimum(result.getRight());
            if (newNode.getRight()!=null) {
                newNode.getRoot().setLeft(newNode.getRight());
                newNode.getRight().setRoot(newNode.getRoot());
            }else newNode.getRoot().setLeft(null);
            result.setValue(newNode.getValue());
        }
        this.size--;
        return true;
    }

    @Override
    public boolean isEmpty() {
        if(this.size!=0) return false;
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void display() {
        Stack<MyTreeContainer<T>> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<MyTreeContainer<T>> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                MyTreeContainer<T> tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeft());
                    localStack.push(tempNode.getRight());
                    if (tempNode.getLeft() != null || tempNode.getRight() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }

    @Override
    public void traverse(TraverseMode mode) {
        switch (mode) {
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Unknown traverse mode: " + mode);
        }
    }

    private void inOrder(MyTreeContainer<T> current) {
        if (current == null) {
            return;
        }

        inOrder(current.getLeft());
        System.out.println(current.getValue());
        inOrder(current.getRight());
    }

    private void preOrder(MyTreeContainer<T> current) {
        if (current == null) {
            return;
        }

        System.out.println(current.getValue());
        preOrder(current.getLeft());
        preOrder(current.getRight());
    }

    private void postOrder(MyTreeContainer<T> current) {
        if (current == null) {
            return;
        }

        postOrder(current.getLeft());
        postOrder(current.getRight());
        System.out.println(current.getValue());
    }

    private  MyTreeContainer <T> findMinimum (MyTreeContainer <T> start){
        if (start.getLeft()==null) return start;
        else return findMinimum(start.getLeft());
    }

    public boolean isBalanced (){
        if (isEmpty())return true;
        else if (root.getBalance()<0) return false;
        return true;
    }
}
