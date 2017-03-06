package schedulers;


import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

public class DM extends CommonScheduler{
    public DM(){
        super();
    }
    @Override
    public Task getPriorTask(Set<Task> tasks){
        Optional<Task> t=tasks.stream().min(Comparator.comparing(Task::getRelDeadline));
        Task thisTask=t.isPresent()?t.get():null;
        if(thisTask!=null) {
            thisTask.release(getTime());
        }
        return thisTask;
    }
}
