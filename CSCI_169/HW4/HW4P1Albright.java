import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.String;
import java.lang.Integer;
class HW4P1 {
    public static class Food {
        public String name;
        public Food() {
        }
        public Food(String n) {
            name = n;
        }
        public void prepare() {
            System.out.println("Prepare the " + name);
        }
    }
    public static class Fruit extends Food {
        Date ripe;
        Fruit() {}
        Fruit(Date d, String S) {
            name=S;
            ripe = d;
        }
        void ripeTime() {
            System.out.println("You can eat it on " + ripe);//note might be wrong
        }
    }

    public static class Orange extends Fruit {
        Orange(){}
        Orange(Date d) {
            super(d, "orange");
        }
        public void prepare() {
            System.out.println("Peel the orange");
        }
    }

    public static class Apple extends Fruit {
        Apple(){}
        Apple(Date d) {
            super(d, "apple");
        }
        public void prepare() {
            System.out.println("Core the apple");
        }
    }

    public static boolean isClassName(Object text) {
        if (!(text.getClass().isInstance(new String()))) return false;
        if (text.equals("Food")) return true;
        if (text.equals("Fruit")) return true;
        if (text.equals("Apple")) return true;
        if (text.equals("Orange")) return true;
        return false;
    }

    public static Date getDate(Object text) {
        if (text.getClass().isInstance(new String())) return new Date(); // This is the "now" case
        return new Date(new Long((Integer)text)); // This is an Integer
    }

    public static ArrayList<Food> buildList (ArrayList<Object> inputList) {
        ArrayList<Food> output= new ArrayList<Food>();
        int i=0;
        while (i<inputList.size()){
            String thisinput=inputList.get(i).toString();
            if (thisinput.equals("Food")){
                if (i+1<inputList.size() && !isClassName(inputList.get(i+1))) {
                    output.add(new Food((String)inputList.get(i+1)));
                    i += 2;
                }
                else {
                    output.add(new Food());
                    i += 1;
                }
            }
            else if (thisinput.equals("Fruit")){
                //while in bounds
                if (i+2<inputList.size() && !isClassName(inputList.get(i+1)) ){//check if its an object name, create with parameters
                    output.add(new Fruit(getDate(inputList.get(i+2)), (String) inputList.get(i+1)));
                    i += 3;
                }
                else { //if an object name use as a constructor parameter
                    output.add(new Fruit());
                    i += 1;
                }
            }
            else if (thisinput.equals( "Apple")){
                if (i+1<inputList.size() && !isClassName(inputList.get(i+1))) {
                    output.add(new Apple(getDate(inputList.get(i+1))));
                    i += 2;
                }
                else {
                    output.add(new Apple());
                    i += 1;
                }
            }
            else if (inputList.get(i).equals( "Orange")){
                if (i+1<inputList.size() && !isClassName(inputList.get(i+1))) {
                    output.add(new Orange(getDate(inputList.get(i+1))));
                    i += 2;
                }
                else {
                    output.add(new Orange());
                    i += 1;
                }
            }
            else {
                i = inputList.size(); // Messed up, avoid crashing
            }
        }
        return output;
    }

    public static void main(String args[])
    {
        System.out.println("Hello");
        ArrayList<Object> inputList = new ArrayList<Object>(Arrays.asList(
                "Food", "Orange", "Fruit", "Papaya",  new Integer(3932728), "Apple", "now", "Food", "sandwich"));
        ArrayList<Food> stuff = buildList(inputList);

        for (int i=0; i<stuff.size();i++) {
            stuff.get(i).prepare();
            System.out.println(stuff.get(i).getClass());
            Fruit f=new Fruit();
            if (f.getClass().isInstance(stuff.get(i))){
                ((Fruit)stuff.get(i)).ripeTime();
            }
        }
    }

}
//You’ll write a function which takes as input an ArrayList of Strings and Integers, and returns an ArrayList of objects from HW 3
//(to make it simpler, we’ll restrict it to Food, Fruit, Apple, and Orange objects), and a sensible main that tests it. The starting ArrayList
// should be formatted as follows: The name of the type of the next object, followed by parameter(s) that should be sent as input to the class’
//constructor (however if you should send a Date as input, you will be given either the string “now” if you should use Date’s constructor that takes
// no parameters, or an Integer if you should use the constructor that takes a long). So for instance, the input ArrayList could contain
// the following: “Food”, “Orange”, “Fruit”, “Papaya”, Integer(3932728), “Apple”, “now”, “Food”, “sandwich”, and the resulting ArrayList