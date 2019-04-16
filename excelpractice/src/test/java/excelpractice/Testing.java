package excelpractice;

import java.io.IOException;
import java.util.ArrayList;

public class Testing {

	public static void main(String[] args) throws IOException {
		DataDrivenTest da = new DataDrivenTest();
		ArrayList ar= da.getData("payment");
		for(int i=0; i<ar.size();i++){
			System.out.println(ar.get(i));
		}
		

	}

}
