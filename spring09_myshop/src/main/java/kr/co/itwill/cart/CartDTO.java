package kr.co.itwill.cart;

public class CartDTO {
	
	private int cartno;       //number      primary key     --장바구니 번호
	private int product_code; //number      not null        --상품코드
	private long price;        //number      not null        --상품가격
	private int qty;          //number      default 0       --상품수량
	private String id;        //varchar(15) not null        --아이디
	private String regdate;   //date        default sysdate --작성일
	private String filename;  //varchar(255)				--파일이름
	private String product_name;  //varchar(255)				--파일이름
                                                                                      	
	
	public int getCartno() {
		return cartno;
	}
	public void setCartno(int cartno) {
		this.cartno = cartno;
	}
	public int getProduct_code() {
		return product_code;
	}
	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "CartDTO [cartno=" + cartno + ", product_code=" + product_code + ", price=" + price + ", qty=" + qty
				+ ", id=" + id + ", regdate=" + regdate + ", filename=" + filename + "]";
	}
		
	
	
	
	
	
	
	
	
}// CartDTO class end
