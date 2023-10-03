package templatesTutorial;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PrintInvitations {

	public static void main(String[] args) {

		try {

			FileInputStream f = new FileInputStream("friends.xml");
			XMLDecoder d = new XMLDecoder(new BufferedInputStream(f));
			Object result = d.readObject();
			d.close();

			System.out.println(result);
			System.out.println(result.getClass());

			ArrayList restulList = (ArrayList) result;

			for (int i = 0; i < restulList.size(); i++) {
				System.out.println(restulList.get(i));
				System.out.println(restulList.get(i).getClass());
				System.out.println(((Person) restulList.get(i)).getName());
				System.out.println(((Person) restulList.get(i)).getAddress().getStreet());
				
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
