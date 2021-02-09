public class Main {
    public static void main(String[] args) {
        //Reversed reader test
        ReverseReader rr = new ReverseReader();
        rr.loadString("Трам пам пам!");
        System.out.println(rr.getReversedString());

        //Deque test
        MyDeque<Integer> deque = new MyDeque<Integer>(6);
        System.out.println("Пустая "+deque.isEmpty()+" Полная "+deque.isFull());
        System.out.println(deque.insertLeft(1));
        System.out.println(deque.insertLeft(2));
        System.out.println(deque.insertLeft(3));
        System.out.println("Пустая "+deque.isEmpty()+" Полная "+deque.isFull());
        System.out.println(deque.insertRight(11));
        System.out.println(deque.insertRight(12));
        System.out.println(deque.insertRight(13));
        System.out.println("Пустая "+deque.isEmpty()+" Полная "+deque.isFull());
        System.out.println(deque.insertRight(14));
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeLeft());
        System.out.println(deque.insertRight(15));
        System.out.println(deque.insertRight(16));
        System.out.println(deque.insertRight(17));
        System.out.println(deque.insertRight(18));
        System.out.println(deque.insertRight(19));

        //Stack test
        MyStack <Integer> stack = new MyStack<Integer>(5);
        System.out.println(stack.toString());
        System.out.println(stack.isEmpty());
        stack.push(5);
        System.out.println(stack.toString()+" stack size = "+stack.getSize());
        System.out.println(stack.push(5));
        System.out.println(stack.push(3));
        System.out.println(stack.push(4));
        System.out.println(stack.push(1));
        System.out.println(stack.push(2));
        System.out.println(" stack full  = "+ stack.isFull()+ " stack size = " +stack.getSize());
        System.out.println(stack.pop()+" stack full  = "+ stack.isFull()+ " stack size = " +stack.getSize());

        //Queue test
        MyQueue<Integer> queue = new MyQueue<Integer>(6);
        System.out.println("Пустая "+queue.isEmpty()+" Полная "+queue.isFull());
        System.out.println(queue.remove());
        System.out.println(queue.insert(1));
        System.out.println(queue.insert(2));
        System.out.println(queue.insert(3));
        System.out.println("Пустая "+queue.isEmpty()+" Полная "+queue.isFull());
        System.out.println(queue.remove());
        System.out.println(queue.insert(4));
        System.out.println(queue.insert(5));
        System.out.println(queue.insert(6));
        System.out.println(queue.insert(7));
        System.out.println(queue.insert(8));
        System.out.println("Пустая "+queue.isEmpty()+" Полная "+queue.isFull());
        System.out.println(queue.remove());


    }
}
