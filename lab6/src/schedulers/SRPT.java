package schedulers;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;


public class SRPT extends CommonScheduler {
    public SRPT(){
        super();
    }
    @Override
    public Task getPriorTask(Set<Task> tasks){
        Optional<Task> t=tasks.stream().min(Comparator.comparing(Task::getRemProcTime));
        /*if(t.isPresent()){
            System.out.println("SRPT@getPriorTask: task is "+t.get().getTaskID()+" remaining time "+t.get().getRemProcTime());
        }else{
            System.out.println("SRPT@getPriorTask: task is null");
        }*/
        Task thisTask=t.isPresent()?t.get():null;
        if(thisTask!=null) {
            thisTask.release(getTime());
        }
        return thisTask;
    }
}
