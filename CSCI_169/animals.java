		System.out.println();
		ArrayList<Object> a = new ArrayList<Object>();
		a.add(animal);
		a.add(bird);
		a.add(dog);
		a.add(new Animal());
		a.add(new Integer(5));
		//int x = 5;
		a.add(4);
		//Can only call methods defined on Object

		for (Object i : a) {
			System.out.println(i.getClass());

		}
    //Then:  call the eat function for the dogs and birds.
		int birds = 0;
		int dogs = 0;
		int other = 0;

		for(Object i : a) {
            if (i.getClass().equals(Bird.getClass())){
                birds++;
								Bird b=(Bird)i;
								b.eat();
            }
            else if (i.getClass().equals(Dog.getClass){
                dog++;
								Dog b=(Dog)i;
								b.eat();
            }
            else{
                other++;
            }
		}
		System.out.print("Birds: ");
		System.out.println(birds);
		System.out.print("Dogs: ");
		System.out.println(dogs);
		System.out.print("Other: ");
		System.out.println(other);
