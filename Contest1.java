import java.util.ArrayList;
import java.util.List;

public class Contest1 {

	public static List<String> splitString(String str, char esc) {
		List<String> res = new ArrayList<String>();

		// Your Logic goes here

		String current = "";
		for(char a: str.toCharArray()) {
			if(a == esc) {
				res.add(current);
				current = "";
				continue;
			}
			current += a;
		}

		if(!(current.equals(""))) {
			res.add(current);
		}

		return res;
	}

	public static void main(String[] args) {
		String str = "My name is 'Ashok Kumar Gowda' I have 12+ years of experience I work for 'IBM India Pvt Ltd' ";

		List<String> result = splitString(str, '\'');

		for (String a : result) {
			System.out.println(a);
		}
	}
}
