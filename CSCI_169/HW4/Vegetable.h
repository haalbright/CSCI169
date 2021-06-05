#ifndef VEGTABLE_H
#define VEGTABLE_H
#include <iostream>
#include <string>
#include <time.h>
#include "Food.h"
using namespace std;

class Vegetable: virtual public Food{
public:
    time_t expiration; //https://www.cplusplus.com/reference/ctime/localtime/
    Vegetable(){ cout << "Vegetable()" << endl; }
    Vegetable(string theName, time_t expired):Food(theName){
      cout<<"vegetable(string, date) "<<theName<<endl;
      expiration=expired;
    }
    time_t expireTime(){
      struct tm* expireT=localtime(&expiration);
      cout<<" You must eat before: "<<asctime(expireT)<<endl;
      return expiration;
    }
};


#endif
/*
public static class Vegetable extends Food {
    expireDate ripe;
    Vegetable() {}
    Vegetable(expireDate d, String S) {
       name=S;
       ripe = d;
    }
    void expireTime() {
        System.out.println("You can eat it on" + ripe);//note might be wrong
    }
}

*/
