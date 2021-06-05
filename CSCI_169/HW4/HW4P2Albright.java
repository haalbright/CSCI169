import java.util.Collections;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.String;
import java.lang.Integer;
class HW4P2Albright {
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
    public static class Fruit extends Food implements Comparable<Fruit> {
        Date ripe;
        Fruit() {}
        Fruit(Date d, String S) {
            name=S;
            ripe = d;
        }
        void ripeTime() {
            System.out.println("You can eat it on " + ripe);//note might be wrong
        }

        @Override
        public int compareTo(Fruit o) {
            return ripe.compareTo(o.ripe);
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
    public static void main(String[] args) {
        ArrayList<Fruit> inputList = new ArrayList<Fruit>();
        inputList.add(new Fruit(new Date(), "kiwi"));
        inputList.add(new Fruit(new Date(4932728), "grape"));
        inputList.add(new Fruit(new Date(3932729), "yuzu"));
        for (Fruit fruit: inputList){
            fruit.ripeTime();
        }
        System.out.println("Sorting now....");
        Collections.sort(inputList);
        for (Fruit fruit: inputList){
            fruit.ripeTime();
        }
    }
}