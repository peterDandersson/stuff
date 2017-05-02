package chapter4;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * Created by Solidbeans on 2017-01-17.
 */
public class Reflect {


    public static void main(String[] args) {
        String[] myClasses = {"ClassA","ClassB","ClassC"};
        try {


            for (int i =0; i<myClasses.length;i++) {
          //      ClassBase myClass = (ClassBase) Class.forName("chapter4.ClassBase" ).newInstance();
                ClassBase myClass = (ClassBase) Class.forName("chapter4." +myClasses[i]).newInstance();
                myClass.myMethod();

                Method method = myClass.getClass().getMethod("myMethod");
                method.invoke(myClass);


                Method[] methodArray = myClass.getClass().getMethods();
                for(Method m: methodArray ){
                    System.out.println("Method; " +  m.getName());
                }

                Field[] fieldArray = myClass.getClass().getFields();
                for(Field f: fieldArray ){
                    System.out.println("Field; " +  f.getName());
                    System.out.println("Fields; " + f.getClass().getMethods().length);
                }
                System.out.println("...");
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class ClassBase{
    public int id;
    public String str;
    public void myMethod() {
        System.out.println(this.getClass().getName());
    }
}
class ClassA extends ClassBase {  }
class ClassB extends ClassBase { public String str2; }
class ClassC extends ClassBase { }
