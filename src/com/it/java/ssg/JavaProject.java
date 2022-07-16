package com.it.java.ssg;//com.it.java.ssg ������θ� ��Ÿ���Եȴ�.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaProject {

	public static void main(String[] args) {
		System.out.println("==���α׷�����==");
		Scanner sc = new Scanner(System.in);

		List<Article> articles = new ArrayList<>();

		int lastid = 0;
		
		while (true) {

			System.out.println("��ɾ �Է��ϼ���");
			String command = sc.nextLine().trim();
			
			command = command.trim();// �翷�� ������ �����ϴ� �Լ�

			if (command.length() == 0) {
				continue;// ���� �Է����������� ���� ó������ ���ư�����
			}

			if (command.equals("system exit")) {
				break;
			}

			
			if (command.equals("article write")) {
				int id = lastid+1;
				lastid = id;
				System.out.printf("���� :");
				String title = sc.nextLine();
				System.out.printf("���� :");
				String body = sc.nextLine();

				Article article = new Article(id, title, body);

				articles.add(article);

				System.out.printf("%d��°�Խñ��� �ۼ�����ϴ�.\n", id);
			}

			else if (command.equals("article list ")) {

//				1���Խù����� �������Ե�				
//				 for (int i = 0; i < articles.size(); i++) { 					 
//					 Article article = articles.get(i);
//				  }
				for (int i = articles.size()-1; i >=0; i++) { 					 
					 Article article = articles.get(i);
					 System.out.printf("%d    |  %s\n", article.id, article.title);
				  }
				 
				

				if (articles.size() == 0) {
					System.out.println("�Խù��� �����ϴ�.");
				}
				continue;

			}
			
			else if(command.startsWith("article detail ")) {
				String[] commandbits = command.split(" ");
				int bit =Integer.parseInt(commandbits[2]);
				
				boolean found = false;
				Article foundarticle =null;
				for (int i =0; i<articles.size(); i++) { 					 
					 Article article = articles.get(i);
					 if(bit==article.id) {
						 foundarticle =article;
						 found = true;
						 break;
						 }
				
					 
					 
					 if(found==false) {
						 System.out.printf("%d���Խñ��� ���������ʽ��ϴ�.\n");
						 continue;
					 }
					 
					 System.out.printf("��ȣ:%d\n", article.id);
					 System.out.printf("��¥:%s\n","2022-07-16 12:41:15");
					 System.out.printf("����:%s\n",article.title);
					 System.out.printf("����:%s\n",article.body);						 
				}
				
			
			
				
			

			else {
				System.out.printf("%s�� ���������ʴ� ��ɾ��Դϴ�.\n", command);
			}

		}
		sc.close();

	}

}

class Article {
	String title;
	String body;
	int id;

	Article(int id, String title, String body) {
		this.title = title;
		this.body = body;
		this.id = id;

	}

}
