package test;

class Elem {
	int value;
	Elem next;

	public Elem(int x, Elem n) {
		next = n;
		value = x;
	}

	public Elem getNext() {
		return next;
	}

	public int getValue() {
		return value;
	}
}

public class MyStack {
	Elem top;

	MyStack() {
		top = null;
	}

	public Elem MyTop() {
		if (top == null)
			throw new NullPointerException();
		else
			return top;
	}

	public boolean IsNull() {
		if(top == null)
			return true;
		return false;
	}
	
	public void MyPush(int x) {
		Elem temp = new Elem(x, top);
		top = temp;
	}

	public void MyPop() {
		if (top != null) {
			top = top.getNext();
		} else {
			throw new NullPointerException(); 
		}
	}
}
