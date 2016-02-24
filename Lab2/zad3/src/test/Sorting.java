package test;

public class Sorting {

	Integer[] table;
	
	public Sorting(Integer[] tab){
		table = tab;
	}
	public void bubbleSort() {
		if (table == null)
			throw new IllegalArgumentException();
		if (table.length == 0)
			throw new NullPointerException();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length - 1; j++) {
                if (table[j] > table[j + 1]) {
                    int temp;
                    temp = table[j + 1];
                    table[j + 1] = table[j];
                    table[j] = temp;
                }
            }
        }
    }
}
