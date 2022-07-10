package com.it.java.ssg;
import java.util.Scanner;

public class JavaProject {

	public static void main(String[] args) {
		System.out.println("==프로그램시작==");
		Scanner sc = new Scanner(System.in);
		System.out.println("명령어를 입력하세요");
		String command = sc.nextLine();
		System.out.println("1번째 입력된 입력어:"+command);
		
		System.out.println("명령어를 입력하세요");
		int num = sc.nextInt();
		System.out.println("1번째 숫자출력"+num);
		sc.close();
		System.out.println("==프로그램끝==");
		
	}

}
