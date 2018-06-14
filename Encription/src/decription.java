
public class decription {

	public static String n_l(String msg) {
		String temp = "", newmsg = "";
		
		int num;
		char ch;

		for (int i = 0; i < msg.length(); i++) {
			temp += msg.charAt(i);
			
			if (temp.equals("0")  || temp.equals("1") || temp.equals("2")) {
				i++;
				temp = temp + msg.charAt(i);
				
				/*
				 * stringstream geek(temp); num=0; geek>>num; ch=96+num; newmsg=newmsg+ch;
				 */

				num = Integer.parseInt(temp);
				
				ch = (char) (96 + num);
				System.out.println("   " +ch);
				newmsg += ch;
				
				ch=' ';
				
			} else {
				newmsg = newmsg + temp;
				
			}
			temp="";
		}
		return newmsg;
	}

	public static String ceasar(int key ,String msg) {
		String temp = "";
		//int key = 2;
		// " enter the key :";
		// cin >> key;
		char ints;
		for (int i = 0; i < msg.length(); i++) {
			int a = (int) msg.charAt(i);
			int tn;
			if (a >= 97 && a <= 122) {
				tn = a - key;
				if (tn < 97) {
					tn = 123 + tn - 97;
				}
				// tn= 122-a+97;

			} else if (a >= 65 && a <= 90) {
	               tn=a-key;
                   if (tn <65)
                   {
                       tn= 91 +tn -65;
                   }

			}

			else {
				tn = a;
			}
			ints = (char) tn;
			temp = temp + ints;

		}
		return temp;

	}

}
