package com.market.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.market.cart.Cart;
import com.market.delivery.Delivery;
import com.market.member.Admin;
import com.market.member.Customer;
import com.market.member.User;

public class DeliveryMain {

	static final int NUM_MENU = 3;// 메뉴 갯수
	static final int NUM_ITEM = 6;// 메뉴 정보 갯수
	static Cart cart = new Cart();
	static User user;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);// 입력받기

		String name;// 이름
		int phoneNumber;// 전화번호
		int number;// 메뉴 번호 선택
		Delivery[] menu = new Delivery[NUM_MENU];

		System.out.println("고객 정보 입력");
		System.out.println("이름 : ");
		name = scan.next();// 이름을 문자열로 입력받음

		System.out.println("전화번호 : ");
		phoneNumber = scan.nextInt();// 전화번호를 정수로 입력받음

		user = new User(name, phoneNumber);// 사용자 정보 저장

		boolean quit = false;// 무한 반복

		// quit가 true 일때 반복문을 끝낸다.
		while (!quit) {
			menuIntroduction();

			System.out.println("번호를 선택해주세요>>");
			number = scan.nextInt();

			// 입력한 번호 결과
			if (number < 1 || number > 9) {
				System.out.print("1~9까지 숫자를 입력하세요.\n");// 번호를 잘못 입력했을경우
			} else {
				switch (number) {
				case 1:
					menuInformation(name, phoneNumber);
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
				case 9:
					menuAdminLogin();
					break;
				}
			}
		}
	}

	public static void menuIntroduction() {
		System.out.println("----------------------------------------------");
		System.out.println("\t  중식 메뉴");
		System.out.println("----------------------------------------------");
		System.out.println("1. 고객 정보 확인하기  \t 2. 배달 메뉴 목록 보기");
		System.out.println("3. 장바구니 비우기    \t 4. 장바구니에 항목 추가하기");
		System.out.println("5. 장바구니의 항목수량 줄이기  \t 6. 장바구니의 항목 삭제하기");
		System.out.println("7. 영수증 표시하기    \t 8. 종료");
		System.out.println("9. 관리자 로그인");
		System.out.println("----------------------------------------------");
	}

	public static void menuInformation(String name, int phoneNumber) {
		Customer ct = new Customer(name, phoneNumber);
		System.out.println("현재 고객 정보");
		System.out.println("이름 : " + ct.getName() + ", 연락처 : " + ct.getPhone());
	}

	public static void menuItemList() {
		if (cart.cartCount >= 0) {
			cart.printCart();
		}
	}

	public static void menuClear() {
		if (cart.cartCount == 0) {
			System.out.println("장바구니에 항목이 없습니다");
		} else {
			System.out.println("장바구니에 모든 항목을 삭제하겠습니까? Y | N ");
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();
			if (str.toUpperCase().equals("Y") || str.toUpperCase().equals("y")) {
				System.out.println("장바구니에 모든 항목을 삭제했습니다");
				cart.deleteDelivery();
			}
		}
	}

	public static void menuAdd(Delivery[] delivery) {
		menuList(delivery); // 메뉴 정보가 저장되어 있는 메서드 호출

		cart.printDeliveryList(delivery);
		boolean quit = false;

		while (!quit) {
			Scanner input = new Scanner(System.in);
			System.out.print("장바구니에 추가할 메뉴를 입력하세요 :");
			String inputStr = input.nextLine();
			boolean flag = false; // 일치 여부
			int num = -1; // 인덱스 번호
			for (int i = 0; i < NUM_MENU; i++) {
				if (inputStr.equals(delivery[i].getMenu())) {
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
					System.out.println(delivery[num] + " 메뉴가 장바구니에추가되었습니다.");
					// 장바구니에 넣기
					if (!isCartInMenu(delivery[num].getMenu())) {
						cart.insertDelivery(delivery[num]);
					}
				}
				quit = true;
			} else {
				System.out.println("다시 입력해 주세요");
			}
		}
	}

	public static void menuCutDown() {
		System.out.println("5. 장바구니의 항목 수량 줄이기");
	}

	public static void menuDelete() {
		if (cart.cartCount == 0) {
			System.out.println("장바구니에 항목이 없습니다");
		} else {
			menuItemList();
			boolean quit = false;
			while (!quit) {

				System.out.print("장바구니에서 삭제할 메뉴를 입력하세요 :");
				Scanner input = new Scanner(System.in);
				String str = input.nextLine();
				boolean flag = false;
				int numId = -1;
				for (int i = 0; i < cart.cartCount; i++) {
					if (str.equals(cart.cartItem[i].getMenu())) {
						numId = i;
						flag = true;
						break;
					}
				}
				if (flag) {
					System.out.println("장바구니의 항목을 삭제하겠습니까? Y | N ");
					str = input.nextLine();
					if (str.toUpperCase().equals("Y") || str.toUpperCase().equals("y")) {
						System.out.println(cart.cartItem[numId].getMenu() + "장바구니에서 메뉴가 삭제되었습니다.");
						cart.removeCart(numId);
					}

					quit = true;
				} else {
					System.out.println("다시 입력해 주세요");
				}
			}
		}
	}

	public static void menuBill() {
		if (cart.cartCount == 0) {
			System.out.println("장비구니에 항목이 없습니다");
		} else {
			System.out.println("배송받을 분은 고객정보와 같습니까? Y | N ");
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();
			if (str.toUpperCase().equals("Y") || str.toUpperCase().equals("y")) {
				System.out.print("배송지를 입력해주세요 ");
				String address = input.nextLine();
				// 주문 처리 후 영수증 출력 메서드 호출
				printBill(user.getName(), String.valueOf(user.getPhone()), address);
			} else {
				System.out.print("배송받을 고객명을 입력하세요 ");
				String name = input.nextLine();
				System.out.print("배송받을 고객의 연락처를 입력하세요 ");
				String phone = input.nextLine();
				System.out.print("배송받을 고객의 배송지를 입력해주세요 ");
				String address = input.nextLine();
				// 주문 처리 후 영수증 출력 메서드 호출
				printBill(name, phone, address);
			}
		}
	}

	public static void menuExit() {
		System.out.println("8. 종료");
	}

	public static void menuList(Delivery[] delivery) {
		delivery[0] = new Delivery("짜장면", "별점 : 4.9점", 7000, "배달시간 : 31~ 46분 소요 예상");
		delivery[0].setIntroduction("호로록 끊임없이 넘어가는 단맛이 덜한 옛날짜장");
		delivery[0].setSize("1인분");

		delivery[1] = new Delivery("짬뽕", "별점 : 4.2점", 8000, "배달시간 : 31~ 46분 소요 예상");
		delivery[1].setIntroduction("강한불에 해물과 야채가 만나 시원함 UP!!UP!!");
		delivery[1].setSize("1인분");

		delivery[2] = new Delivery("탕수육", "별점 : 4.8점", 22000, "배달시간 : 31~ 46분 소요 예상");
		delivery[2].setIntroduction("★ 사장님이 강력 추천하는 메뉴!! ★");
		delivery[2].setSize("2인분");

	}

	public static boolean isCartInMenu(String menu) {
		return cart.isCartInDelivery(menu);
	}

	// 관리자 로그인 정보 확인 메서드
	public static void menuAdminLogin() {
		System.out.println("관리자 정보를 입력하세요");
		Scanner input = new Scanner(System.in);
		System.out.print("아이디 : ");
		String adminId = input.next();
		System.out.print("비밀번호 : ");
		String adminPW = input.next();
		Admin admin = new Admin(user.getName(), user.getPhone());
		if (adminId.equals(admin.getId()) && adminPW.equals(admin.getPassword())) {
			System.out.println("이름 : " + admin.getName() + ", 연락처 : " + admin.getPhone());
			System.out.println("아이디 : " + admin.getId() + ", 비밀번호 : " + admin.getPassword());
		} else {
			System.out.println("관리자 정보가 일치하지 않습니다.");
		}
	}

	//
	public static void printBill(String name, String phone, String address) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String strDate = formatter.format(date);
		System.out.println();
		System.out.println("---------------배송 받을 고객 정보----------------");
		System.out.println("고객명 : " + name + " \t\t 연락처 : " + phone);
		System.out.println("배송지 : " + address + "\t 발송일 : " + strDate);
		// 장바구니에 담긴 항목 출력
		cart.printCart();
		// 장바구니에 담긴 항목의 총 금액 계산
		int sum = 0;
		for (int i = 0; i < cart.cartCount; i++) {
		sum += cart.cartItem[i].getTotalPrice();
		}
		System.out.println("\t\t\t 주문 총금액 : " + sum + "원\n");
		System.out.println("----------------------------------------------");
		System.out.println();
		
	}
	
}
