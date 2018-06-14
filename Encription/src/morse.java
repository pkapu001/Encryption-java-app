import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

final public class morse {

	String c;
	String symbol;

	public static void load(ArrayList<morse> mkey) throws FileNotFoundException {

		Scanner f = new Scanner(ResourceLoader.rload("morse key.txt"));
		// int i=0;
		String s;
		String[] ss;
		while (f.hasNext()) {
			morse temp = new morse();
			s = f.nextLine();

			ss = s.split(" ");
			temp.c = ss[0];
			temp.symbol = ss[1];
			mkey.add(temp);
			// System.out.println(mkey.get(i).c + mkey.get(i).symbol );

			// i++;

		}
		f.close();
	}

	public static String e_morse(String code, ArrayList<morse> mkey) {
		String[] ch;
		String temp = "", msg = "";

		ch = code.split("");
		for (String each : ch) {

			temp = "";
			for (morse m : mkey) {
				if (m.c.equals(each)) {
					temp = m.symbol + " ";
					break;
				}else {
					temp="";
				}
			}
			//System.out.println("...");
			if (temp == "") {
				//System.out.println("..." + each + "..." + each.equals(" "));
				if (each.equals(" ")) {
					System.out.println("+| ");
					temp = "| ";
				} else {
					temp = each;
				}
			}
			msg += temp;
			System.out.println(msg);
		}
		return msg;
	}

	public static String d_morse(String code, ArrayList<morse> mkey) {
		String[] sy;
		String temp = "",msg="";
		sy = code.split(" ");
		for (String each : sy) {
			temp="";
			if (each.equals("|")) {
				temp = " ";
			} else {
				for (morse m : mkey) {
					if (m.symbol.equals(each)) {
						temp = m.c;
						break;
					}

				}
				if(temp=="")
				{
					temp=each;
				}
			}
			msg += temp;
		}
		return msg;
	}

}
