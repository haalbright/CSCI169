#include <iostream>
#include <string>
#include <time.h>
#include "Vegetable.h"
#include "Tomato.h"
#include "Orange.h"
#include "Apple.h"
#include "Food.h"
#include "Fruit.h"
using namespace std;

int main(){
  time_t newTime;
  Fruit abc(time(0), "kiwi");
  cout<<endl;
  Orange fsadfg(time(0));
  fsadfg.prepare();
  cout<<endl;
  Tomato tom(time(0),time(&newTime));
  cout<<endl;
  tom.prepare();
  return 0;
}
