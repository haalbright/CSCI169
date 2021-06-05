#ifndef FOOD_H
#define FOOD_H
#include <iostream>
#include <string>
using namespace std;

class Food{
public:
    string name;
    Food(){ cout << "Food()" << endl; }
    Food(string thename){
      cout<<"food(string) "<<thename<<endl;
      name=thename;
    }
    virtual void prepare(){cout<<"Prepare the "<< name <<endl;}
};


#endif
/*
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

*/
