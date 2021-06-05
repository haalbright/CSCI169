#ifndef TOMATO_H
#define TOMATO_H
#include <iostream>
#include <string>
#include <time.h>
#include "Vegetable.h"
#include "Fruit.h"
using namespace std;

class Tomato: public Fruit, public Vegetable{
public:
  Tomato(){ cout << "Tomato()" << endl; }
  Tomato(time_t eDate, time_t ripe): Food("Tomato"){
      cout<<"tomato(date ,date)"<<endl;
      expiration=eDate;
      ripeDate=ripe;
    }
    //using Fruit::prepare;
};


#endif
/*
public static class Tomato extends Fruit {
    Tomato(Date d) {
        super(d, "Tomato");
    }
    public void prepare() {
        System.out.println("Peel the Tomato");
    }
}

*/
