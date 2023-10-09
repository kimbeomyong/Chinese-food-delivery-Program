package main;

import java.util.Scanner;

public class DeliveryMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);// 입력받기

		String name;// 이름
		int phoneNumber;// 전화번호
		int number;// 메뉴 번호 선택

		System.out.println("고객 정보 입력");
		System.out.println("이름 : ");
		name = scan.next();// 이름을 문자열로 입력받음

		System.out.println("전화번호 : ");
		phoneNumber = scan.nextInt();// 전화번호를 정수로 입력받음

		boolean quit = false;// 무한 반복

		// quit가 true 일때 반복문을 끝낸다.
		while (!quit) {
			menuIntroduction();

			System.out.println("번호를 선택해주세요>>");
			number = scan.nextInt();

			// 입력한 번호 결과
			if (number < 1 || number > 8) {
				System.out.print("1~8까지 숫자를 입력하세요.\n");// 번호를 잘못 입력했을경우
			} else {
				switch (number) {
				case 1:
					menuInformation(name, phoneNumber);
					break;
				case 2:
					menuList();
					break;
				case 3:
					menuClear();
					break;
				case 4:
					menuAdd();
					break;
				case 5:
					menuCutDown();
					break;
				case 6:
					menuDelete();
					break;
				case 7:
					menuBill();
					break;
				case 8:
					menuExit();
					quit = true;// while 문 종료
					break;
				}
			}
		}
	}

	public static void menuIntroduction() {
		System.out.println("----------------------------------------------");
		System.out.println("\t welcome to delivery program");
		System.out.println("----------------------------------------------");
		System.out.println("1. 고객 정보 확인하기  \t 2. 배달 목록 보기");
		System.out.println("3. 장바구니 비우기    \t 4. 장바구니에 항목 추가하기");
		System.out.println("5. 장바구니의 항목수량 줄이기  \t 6. 장바구니의 항목 삭제하기");
		System.out.println("7. 영수증 표시하기    \t 8. 종료");
		System.out.println("----------------------------------------------");
	}

	public static void menuInformation(String name, int phoneNumber) {
		System.out.println("현재 고객 정보");
		System.out.println("이름 : " + name + ", 연락처 : " + phoneNumber);
	}

	public static void menuList() {
		System.out.println("2. 배달 목록 보기 :");
	}

	public static void menuClear() {
		System.out.println("3. 장바구니 비우기 :");
	}

	public static void menuAdd() {
		System.out.println("4. 장바구니에 항목 추가하기 :");
	}

	public static void menuCutDown() {
		System.out.println("5. 장바구니의 항목 수량 줄이기");
	}

	public static void menuDelete() {
		System.out.println("6. 장바구니의 항목 삭제하기");
	}

	public static void menuBill() {
		System.out.println("7. 영수증 표시하기");
	}

	public static void menuExit() {
		System.out.println("8. 종료");
	}

}
