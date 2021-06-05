#ifndef FRUIT_H
#define FRUIT_H
#include <iostream>
#include <string>
#include <time.h>
#include "Food.h"
using namespace std;

class Fruit: virtual public Food{
public:
    time_t ripeDate; //https://www.cplusplus.com/reference/ctime/localtime/
    Fruit(){ cout << "Fruit()" << endl; }
    Fruit(time_t ripe, string name):Food(name){
      cout<<"fruit(date,string) "<<name<<endl;
      ripeDate=ripe;
    }
    void ripeTime(){
      struct tm* ripeT;
      ripeT=localtime(&ripeDate);
      cout<<" You can eat it on: "<<asctime(ripeT)<<endl;
    }
};


#endif
/*
public static class Fruit extends Food {
    ripeDate ripe;
    Fruit() {}
    Fruit(ripeDate d, String S) {
       name=S;
       ripe = d;
    }
    void ripeTime() {
        System.out.println("You can eat it on" + ripe);//note might be wrong
    }
}

*/
