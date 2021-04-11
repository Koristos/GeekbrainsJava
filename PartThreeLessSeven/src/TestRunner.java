import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


public class TestRunner {

    public static void start (String testClassName){
        try {
            Class toRun = Class.forName(testClassName);
            start(toRun);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No class found with this name "+e);
        }
    }

    public static void start(Class testToRun)  {
        Object test = null;
        try {
            test = testToRun.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("The current class object cann not be created" + e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Access to creating current class denied" + e);
        }
        Method[] methodList = testToRun.getMethods();
        ArrayList<PiorMethod> runList = makeRunList(methodList);
        for (int i = 11; i >= 0; i--) {
            for (PiorMethod m:runList) {
                if(m.getPriority()==i){
                    try {
                        m.getMethod().invoke(test);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Access to method denied" + e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException("SWW in method process " + e);
                    }
                }
            }
        }

    }
    
    private static ArrayList<PiorMethod> makeRunList (Method[] methods){
        ArrayList<PiorMethod> runList = new ArrayList<PiorMethod>();
        boolean aftSuite=false;
        boolean befSuite=false;
        for (Method a: methods) {
            if(a.isAnnotationPresent(BeforeSuite.class)){
                if (befSuite==false){
                    befSuite=true;
                    runList.add(new PiorMethod(a,11));
                }else throw new RuntimeException("There can be only one @BeforeSuite in one class.");
            }
            if(a.isAnnotationPresent(AfterSuite.class)){
                if (aftSuite==false){
                    aftSuite=true;
                    runList.add(new PiorMethod(a,0));
                }else throw new RuntimeException("There can be only one @AfterSuite in one class.");
            }
            if(a.isAnnotationPresent(Test.class)){
                Test current = a.getAnnotation(Test.class);
                int priority = current.priority();
                if (priority<1 || priority>10) throw new RuntimeException("Priority can be from 1 to 10 only");
                runList.add(new PiorMethod(a,priority));
            }
        }
        if(runList.isEmpty()) throw new RuntimeException("No authorised annotations found in class.");
        return runList;
    }
}

class PiorMethod {
    private Method method;
    private int priority;
    PiorMethod (Method method, int priority){
        this.method=method;
        this.priority=priority;
    }

    protected Method getMethod() {
        return method;
    }

    protected int getPriority() {
        return priority;
    }
}
