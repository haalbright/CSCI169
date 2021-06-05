#ifndef APPLE_H
#define APPLE_H
#include <iostream>
#include <string>
#include <time.h>
#include "Fruit.h"
using namespace std;

class Apple: public Fruit{
public:
    Apple(){cout<<"Apple()"<<endl;}
    Apple(time_t ripe): Food("Apple"){
      ripeDate=ripe;
      cout<<"Apple(date)"<<endl;
    }
    void prepare(){
      cout<<"Core the apple"<<endl;
    }
};


#endif
/*
public static class Apple extends Fruit {
    Apple(Date d) {
        super(d, "apple");
    }
    public void prepare() {
        super.prepare();
        System.out.println("Core the apple");
    }
}
*/
