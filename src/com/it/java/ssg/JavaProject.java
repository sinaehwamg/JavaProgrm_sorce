package com.it.java.ssg;//com.it.java.ssg 폴더경로를 나타내게된다.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaProject {

	public static void main(String[] args) {
		System.out.println("==프로그램시작==");
		Scanner sc = new Scanner(System.in);

		List<Article> articles = new ArrayList<>();

		int lastid = 0;
		
		while (true) {

			System.out.println("명령어를 입력하세요");
			String command = sc.nextLine().trim();
			
			command = command.trim();// 양옆에 공백을 제거하는 함수

			if (command.length() == 0) {
				continue;// 값을 입력하지않으면 제일 처음으로 돌아가게함
			}

			if (command.equals("system exit")) {
				break;
			}

			
			if (command.equals("article write")) {
				int id = lastid+1;
				lastid = id;
				System.out.printf("제목 :");
				String title = sc.nextLine();
				System.out.printf("내용 :");
				String body = sc.nextLine();

				Article article = new Article(id, title, body);

				articles.add(article);

				System.out.printf("%d번째게시글이 작성됬습니다.\n", id);
			}

			else if (command.equals("article list ")) {

//				1번게시물부터 보여지게됨				
//				 for (int i = 0; i < articles.size(); i++) { 					 
//					 Article article = articles.get(i);
//				  }
				for (int i = articles.size()-1; i >=0; i++) { 					 
					 Article article = articles.get(i);
					 System.out.printf("%d    |  %s\n", article.id, article.title);
				  }
				 
				

				if (articles.size() == 0) {
					System.out.println("게시물이 없습니다.");
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
						 System.out.printf("%d번게시글은 존재하지않습니다.\n");
						 continue;
					 }
					 
					 System.out.printf("번호:%d\n", article.id);
					 System.out.printf("날짜:%s\n","2022-07-16 12:41:15");
					 System.out.printf("제목:%s\n",article.title);
					 System.out.printf("내용:%s\n",article.body);						 
				}
				
			
			
				
			

			else {
				System.out.printf("%s는 존재하지않는 명령어입니다.\n", command);
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
