package Test_something;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 */
public class Experson implements Comparable<Experson> {
    private String name;
    private double age;

    public Experson() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    @Override
    public int compareTo(Experson o) {
       if (o.getAge()<getAge()){
           return 1;
       }else if(o.getAge()==getAge()){
           return 0;
       }else {
           return -1;
       }
    }

    public static void main(String[] args) {
        ArrayList<Experson> list=new ArrayList<>();
        Experson e1=new Experson();
        e1.setName("aaas");
        e1.setAge(0.6);
        Experson e2=new Experson();
        e2.setName("aaas");
        e2.setAge(0.5);
        Experson e3=new Experson();
        e3.setName("aaas");
        e3.setAge(0.0);
        list.add(e1);
        list.add(e2);
        list.add(e3);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).getAge());
        }
        Collections.sort(list);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).getAge());
        }
    }

    @Test
    public void Test(){

    }
}
