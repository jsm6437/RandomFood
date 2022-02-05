package application;

public class ModelTable {
	String food;
	int count;
	String checker;
	
	// login table
	String id;
	String pw;
	String phone;
	
	public ModelTable(String food,int count) {
		this.food = food;
		this.count = count;
	}
	public ModelTable(String checker) {
		this.checker = checker;
	}
	
	public ModelTable(String id, String pw, String phone) {
		this.id = id;
		this.pw = pw;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getChecker() {
		return checker;
	}
	public void setChecker(String checker) {
		this.checker = checker;
	}
	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
