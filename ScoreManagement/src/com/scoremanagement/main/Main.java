package com.scoremanagement.main;

import java.util.Scanner;

import com.scoremanagement.service.ServiceAdmin;
import com.scoremanagement.service.ServiceInstructor;
import com.scoremanagement.service.ServiceStudent;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("---------------------------------------------------------------");
		System.out.println("���� ó�� �ý��� v6.0");
		System.out.println("---------------------------------------------------------------");
		System.out.println("���� ó�� �ý��� v6.0");
		System.out.println("1. ������ �α���  2. ���� �α���  3. ������ �α���");
		System.out.print("���� > ");
		int selectNum = sc.nextInt();
		
		switch(selectNum) {
		
		case 1:
			new ServiceStudent().login(sc);
			break;
			
		case 2:
			new ServiceInstructor().login(sc);
			break;
			
		case 3:
			new ServiceAdmin().login(sc);
			break;
			
		default:
			break;
		}
		
		sc.close();
	}
}
