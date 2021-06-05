#ifndef ORANGE_H
#define ORANGE_H
#include <iostream>
#include <string>
#include <time.h>
#include "Food.h"
#include "Fruit.h"
using namespace std;

class Orange: public Fruit{
public:
    Orange(){cout<<"Orange()"<<endl;}
    Orange(time_t ripe): Food("Orange"){
      ripeDate=ripe;
      cout<<"Orange(date)"<<endl;
    }
    void prepare(){
        cout<<"Peel the Orange"<<endl;
    }
};


#endif
/*
public static class Orange extends Fruit {
    Orange(Date d) {
        super(d, "orange");
    }
    public void prepare() {
        System.out.println("Peel the orange");
    }
}

*/
