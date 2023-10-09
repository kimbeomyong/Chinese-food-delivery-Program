package Cart;

public class CartItem {

	private String[] menuItem = new String[5]; // 메뉴 정보의 개수
	private String menu; // menu
	private int quantity; // 메뉴 수량
	private int totalPrice; // 도서 합계 가격

	public CartItem() {
	}

	public CartItem(String[] menuItem) {
		this.menuItem = menuItem;
		this.menu = menuItem[0];
		this.quantity = 1;
		updateTotalPrice();
	}

	public String[] getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(String[] menuItem) {
		this.menuItem = menuItem;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
		this.updateTotalPrice();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this.updateTotalPrice();
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void updateTotalPrice() {
		totalPrice = Integer.parseInt(this.menuItem[3]) * this.quantity;
	}

}
