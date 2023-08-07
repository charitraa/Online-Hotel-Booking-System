package Middleware;

public class BookingMiddleWare {
	private int bookingid;
	 private String checkInDate , checkOutdate,bookingStatus,numberOfGuest,type;
	
	public BookingMiddleWare() {
		
		this.bookingid = 0;
		this.numberOfGuest = "";
		this.checkInDate = "";
		this.checkOutdate = "";
		this.bookingStatus = "";
		this.type="";
	}
	public BookingMiddleWare( int bookingid,String numberOfGuest, String checkInDate, String checkOutdate,
			String bookingStatus,String type) {
		super();
		this.bookingid = bookingid;
		this.numberOfGuest = numberOfGuest;
		this.checkInDate = checkInDate;
		this.checkOutdate = checkOutdate;
		this.bookingStatus = bookingStatus;
		this.type = type;
	}
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutdate() {
		return checkOutdate;
	}
	public void setCheckOutdate(String checkOutdate) {
		this.checkOutdate = checkOutdate;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public String getNumberOfGuest() {
		return numberOfGuest;
	}
	public void setNumberOfGuest(String numberOfGuest) {
		this.numberOfGuest = numberOfGuest;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "BookingMiddleWare [bookingid=" + bookingid + ", checkInDate=" + checkInDate + ", checkOutdate="
				+ checkOutdate + ", bookingStatus=" + bookingStatus + ", numberOfGuest=" + numberOfGuest + ", type="
				+ type + "]";
	}

	
	

	
}