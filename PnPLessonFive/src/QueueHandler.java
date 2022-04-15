import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class QueueHandler {
    private Queue <String> queue;
    private List<Processor> processorList;

    QueueHandler(){
        this.processorList = new ArrayList<>();
        this.queue = new ArrayDeque<>();
    }

    public void registerProcessor (Processor processor){
        processorList.add(processor);
    }

    public void add (String string) {
        this.queue.add(string);
    }

    public void execute () {
        while (!queue.isEmpty()){
            for (Processor proc: processorList) {
                if (proc.isReady()){
                    proc.process(queue.poll());
                    break;
                }
            }
            System.out.println("No available processors");
        }
    }

}
