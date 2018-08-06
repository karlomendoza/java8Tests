import java.util.Arrays;
import java.util.List;

public class ForEachLoop {
	public static void main(String args[]){
		
		List<String> myList = Arrays.asList("apple", "coconut", "pear", "melon");
		
		for (String fruit : myList) {
			if(!fruit.equals("apple")){
				System.out.println("My favorite fruit is: " + fruit);
			} else {
				System.out.println("I do not like: " + fruit);
			}
		}
	}
}
