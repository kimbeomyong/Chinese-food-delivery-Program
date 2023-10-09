package main;

import java.util.Scanner;

public class DeliveryMain {

	static final int NUM_MENU = 3;// 메뉴 갯수
	static final int NUM_ITEM = 5;// 매뉴 정보 갯수

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);// 입력받기

		String name;// 이름
		int phoneNumber;// 전화번호
		String adress; // 주소
		int number;// 메뉴 번호 선택
		String[][] menu = new String[NUM_MENU][NUM_ITEM];

		System.out.println("고객 정보 입력");
		System.out.println("이름 : ");
		name = scan.next();// 이름을 문자열로 입력받음

		System.out.println("전화번호 : ");
		phoneNumber = scan.nextInt();// 전화번호를 정수로 입력받음

		System.out.println("주소 : ");
		adress = scan.next();

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
					menuInformation(name, phoneNumber, adress);
					break;
				case 2:
					menuItemList();
					break;
				case 3:
					menuClear();
					break;
				case 4:
					menuAdd(menu);
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
		System.out.println("\t  환영합니다. JAVA짜장면 입니다~");
		System.out.println("----------------------------------------------");
		System.out.println("1. 고객 정보 확인하기  \t 2. 배달 목록 보기");
		System.out.println("3. 장바구니 비우기    \t 4. 장바구니에 항목 추가하기");
		System.out.println("5. 장바구니의 항목수량 줄이기  \t 6. 장바구니의 항목 삭제하기");
		System.out.println("7. 영수증 표시하기    \t 8. 종료");
		System.out.println("----------------------------------------------");
	}

	public static void menuInformation(String name, int phoneNumber, String adress) {
		System.out.println("현재 고객 정보");
		System.out.println("이름 : " + name + ", 연락처 : " + phoneNumber + ",주소 : " + adress);
	}

	public static void menuItemList() {
		System.out.println("2. 배달 목록 보기 :");
	}

	public static void menuClear() {
		System.out.println("3. 장바구니 비우기 :");
	}

	public static void menuAdd(String[][] menu) {
		menuList(menu); // 메뉴 정보가 저장되어 있는 메서드 호출
		// 메뉴 정보 출력
		for (int i = 0; i < NUM_MENU; i++) {
			for (int j = 0; j < NUM_ITEM; j++)
				System.out.print(menu[i][j] + " | ");
			System.out.println("");
		}
		boolean quit = false;
		while (!quit) {
			Scanner input = new Scanner(System.in);
			System.out.print("장바구니에 추가할 메뉴를 입력하세요 :");
			String inputStr = input.nextLine();
			boolean flag = false; // 일치 여부
			int num = -1; // 인덱스 번호
			for (int i = 0; i < NUM_MENU; i++) {
				if (inputStr.equals(menu[i][0])) {
					num = i;
					flag = true;
					break;
				}
			}
			// 일치하면 장바구니 추가 여부를 묻는다.
			if (flag) {
				System.out.println("장바구니에 추가하겠습니까? Y | N ");
				inputStr = input.nextLine();
				if (inputStr.toUpperCase().equals("Y") || inputStr.toUpperCase().equals("y")) {
					System.out.println(menu[num][0] + " 메뉴가 장바구니에추가되었습니다.");
				}
				quit = true;

			} else
				System.out.println("다시 입력해 주세요");
		}
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

	public static void menuList(String[][] menu) {
		menu[0][0] = "짜장면";
		menu[0][1] = "별점 : 4.9점";
		menu[0][2] = "호로록 끊임없이 넘어가는 단맛이 덜한 옛날짜장";
		menu[0][3] = "7,000 원";
		menu[0][4] = "배달시간 : 31~ 46분 소요 예상";

		menu[1][0] = "짬뽕";
		menu[1][1] = "별점 : 4.2점";
		menu[1][2] = "강한불에 해물과 야채가 만나 시원함 UP!!UP!!";
		menu[1][3] = "8,000 원";
		menu[1][4] = "배달시간 : 31 ~ 46분 소요 예상";

		menu[2][0] = "탕수육";
		menu[2][1] = "별점 : 4.8점";
		menu[2][2] = "★ 사장님이 강력 추천하는 메뉴!! ★";
		menu[2][3] = "22,000 원";
		menu[2][4] = "배달시간 : 31 ~ 46분 소요 예상";
	}
}
