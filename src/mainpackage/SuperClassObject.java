package mainpackage;

public class SuperClassObject {
    public SubClassObject doop;

    public void doSomething(){
        doop = new SubClassObject();
        System.out.println("This is the thing it is doing.");
    }
}
