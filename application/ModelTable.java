package application;

public class ModelTable {
	String food;
	int count;
	String checker;
	
	public ModelTable(String food,int count) {
		this.food = food;
		this.count = count;
	}
	public ModelTable(String checker) {
		this.checker = checker;
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
