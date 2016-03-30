package mavenTest.Max;

import java.util.List;

public class MaxElemImpl implements MaxElem {

	public Integer GetMax(List<Integer> list) {
		Integer max = list.get(0);
		for(Integer a : list) {
			if (max < a)
				max = a;
		}
		return max;
	}

}
