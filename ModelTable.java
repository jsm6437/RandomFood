package application;

public class ModelTable {
	String food;
	int count;
	
	public ModelTable(String food,int count) {
		this.food = food;
		this.count = count;
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
