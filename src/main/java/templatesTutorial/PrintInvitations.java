package templatesTutorial;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class PrintInvitations {

	public static void main(String[] args) {

		try {

			FileInputStream f = new FileInputStream("friends.xml");
			XMLDecoder d = new XMLDecoder(new BufferedInputStream(f));
			Object result = d.readObject();
			d.close();

			// System.out.println(result);
			// System.out.println(result.getClass());

			ArrayList restulList = (ArrayList) result;

			FileWriter out = new FileWriter("letter.txt");

			for (int i = 0; i < restulList.size(); i++) {
				// System.out.println(restulList.get(i));
				// System.out.println(restulList.get(i).getClass());
				// System.out.println(((Person) restulList.get(i)).getName());
				// System.out.println(((Person) restulList.get(i)).getAddress().getStreet());

				VelocityContext context = new VelocityContext();

				context.put("person", (Person) restulList.get(i));

				Template template = Velocity.getTemplate("letter.vm");

				template.merge(context, out);

			}
			out.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
