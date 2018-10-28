package org.elsys.netprog.rest;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class BullsAndCows{
	public static String targetStr;
	public static int bulls = 0;
	public static int cows = 0;
	public static boolean guessed;
	public static int guesses;
	public static void main(String guessString){
		Random gen= new Random();
		int target= 0;
		while(hasDupes(target= (gen.nextInt(9000) + 1000)));
		targetStr = target +"";
		guessed = false;
		Scanner input = new Scanner(System.in);
		guesses = 0;
		do{
			bulls = 0;
			cows = 0;
			int guess = Integer.parseInt(guessString);
			try{
				if(hasDupes(guess) || guess < 1000) continue;
			}catch(InputMismatchException e){
				continue;
			}
			guesses++;
			String guessStr = guess + "";
			for(int i= 0;i < 4;i++){
				if(guessStr.charAt(i) == targetStr.charAt(i)){
					bulls++;
				}else if(targetStr.contains(guessStr.charAt(i)+"")){
					cows++;
				}
			}
			if(bulls == 4){
				guessed = true;
			}else{
				System.out.println(cows+" Cows and "+bulls+" Bulls.");
			}
		}while(!guessed);
		System.out.println("You won after "+guesses+" guesses!");
	} 
	public static boolean hasDupes(int num){
		boolean[] digs = new boolean[10];
		while(num > 0){
			if(digs[num%10]) return true;
			digs[num%10] = true;
			num/= 10;
		}
		return false;
	}
}