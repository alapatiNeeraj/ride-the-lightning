package anotherexcelpractice;

import java.io.IOException;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) throws IOException {
		DataTest dt =new DataTest();
		ArrayList al =dt.gettestData("statement");
		for(int i=0;i<al.size();i++){
		System.out.println(al.get(i));
		}
		

	}

}
