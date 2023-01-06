package dto;

public class AccountDto {
	
	//항목들
	private String date; //날짜 -> 22/12/24
	private String use; //돈의 쓰임,용도 -> 영화관람
	private String classify; //수입 or 지출 -> 지출
	private int money; //금액 -> 16000
	private String memo; //내용 -> 아바타2
	
	//기본생성자
	public AccountDto(){
	}
	//매개변수가 있는 생성자
	public AccountDto(String date, String use, String classify, int money, String memo) {
		super();
		this.date = date;
		this.use = use;
		this.classify = classify;
		this.money = money;
		this.memo = memo;
	}
	
	//getter, setter
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	@Override
	public String toString() {
		return "AccountDto [date=" + date + ", use=" + use + ", classify=" + classify + ", money=" + money + ", memo="
				+ memo + "]";
	}
	
	
	

}
