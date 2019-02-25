package javassistpackage;

import javassist.*;
import mainpackage.SubClassObject;
import mainpackage.SuperClassObject;

public class Driver {
    static {
        try {
            ClassPool pool = ClassPool.getDefault();
            CtClass mainClass = pool.get("mainpackage.SubClassObject");//get the class (in android we will use context.getPackage() )
            CtField f = CtField.make("public int z = 0;", mainClass); //add the field (will be the UnityPlayer)
            mainClass.addField(f);
            CtMethod m = CtNewMethod.make("public void doSomething() { System.out.println(\"Boogie!\" + z); }", mainClass); //add the method (will be the overrides required for unity)
            mainClass .addMethod(m);
            //mainClass.writeFile("out/production/JavassistPlayground"); //write it; this is the part that is a bit futsy atm
            mainClass.toClass();
            mainClass.detach(); //clear it for garbage collection
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        System.out.println("Initial load");
        SuperClassObject mainObject = new SuperClassObject();
        mainObject.doSomething();
        mainObject.doop.doSomething();
        //Note that if I directly construct a SubClassObject here and call its doSomething method, the JVM will load the SubClassObject class
        //That causes an exception as JVM doesn't allow reloading a class, which I would need to do after changing the method signature.
        //For Flutter I will have to hope that my plugin static code is executed prior to Flutter instantiating the MainActivity.
    }
}
