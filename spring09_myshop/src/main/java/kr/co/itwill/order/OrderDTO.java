package kr.co.itwill.order;

public class OrderDTO {

	private String orderno; 		// char(15) primary key --주문서번호
	private String id; 				// varchar(15) not null --아이디
	private int    totalamount; 	// number --총결제금액
	private String payment; 		// varchar(10) not null --결제구분 (cash,card등)
	private String deliverynm; 		// varchar(100) not null --받는사람
	private String deliveryaddr; 	// varchar(2000) not null --받는주소
	private String deliverymsg; 	// varchar(2000) --배송메세지
	private String ordercheck;		// char(1) not null --결과상태(Y:배송완료, C:주문취소, I:진행
	private String orderdate; 		// date default sysdate --주문일

	
	
	public OrderDTO() {
		System.out.println("-----OrderDTO()객체 생성됨");
	}
	
	
	
	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(int totalamount) {
		this.totalamount = totalamount;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getDeliverynm() {
		return deliverynm;
	}

	public void setDeliverynm(String deliverynm) {
		this.deliverynm = deliverynm;
	}

	public String getDeliveryaddr() {
		return deliveryaddr;
	}

	public void setDeliveryaddr(String deliveryaddr) {
		this.deliveryaddr = deliveryaddr;
	}

	public String getDeliverymsg() {
		return deliverymsg;
	}

	public void setDeliverymsg(String deliverymsg) {
		this.deliverymsg = deliverymsg;
	}

	public String getOrdercheck() {
		return ordercheck;
	}

	public void setOrdercheck(String ordercheck) {
		this.ordercheck = ordercheck;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	@Override
	public String toString() {
		return "OrderDTO [orderno=" + orderno + ", id=" + id + ", totalamount=" + totalamount + ", payment=" + payment
				+ ", deliverynm=" + deliverynm + ", deliveryaddr=" + deliveryaddr + ", deliverymsg=" + deliverymsg
				+ ", ordercheck=" + ordercheck + ", orderdate=" + orderdate + "]";
	}

}// commetnDTO class end
