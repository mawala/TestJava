package test;

public class NWD {
	int nwd(int a, int b){
		if (a < 0 || b < 0)
			throw new IllegalArgumentException();
		if (a == 0 && b == 0)
			throw new IllegalArgumentException();
		if (b == 0)
			return a;
		return nwd(b, (a%b));
	}
}
