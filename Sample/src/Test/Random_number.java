package Test;

import java.util.Random;

public class Random_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Random value between 1000 and 9999 : " + getRandomInteger(1699999999, 1600000000));

	}
	
	public static int getRandomInteger(int maximum, int minimum){ return ((int) (Math.random()*(maximum - minimum))) + minimum; }

}



