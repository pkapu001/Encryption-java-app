public class encription {
	
	
	
	
	
	public static String n_l(String msg)

	{
	    String temp = "" , n = "" ;
	    for(int i=0 ; i<msg.length();i++)
	    {
	    	
	    	if((int) msg.charAt(i)>64 && (int)msg.charAt(i)<91) 
	    	{
	    		int j ;
	    		j = (int) msg.charAt(i);
	    		
	    		j-=64;
	    		
	    		if(j<10)
	    		{
	    			n="0"+String.valueOf(j);
	    		}else
		    		n= String.valueOf(j);

	    		
	    		
	    	}else if((int) msg.charAt(i)>96 && (int)msg.charAt(i)<123) 
	    	{
	    		int j ;
	    		j = (int) msg.charAt(i);
	    		
	    		j-=96;
	    		if(j<10)
	    		{
	    			n="0"+String.valueOf(j);
	    		}else
		    		n= String.valueOf(j);
	    		
	    		
	    	}else
	    	{
	    		n ="" + msg.charAt(i);
	    		
	    	}
	        temp= temp + n;
	       
	    }

	    return temp;


	}

	public static String ceasar(int key ,String msg)
	{
	    String temp="";
	    //" enter the key :";
	    //cin >> key;
	    char ints;
	    for(int i=0 ; i<msg.length(); i++)
	    {
	        int a =(int) msg.charAt(i);
	        int tn;
	        if(a>=97 && a<=122  )
	           {
	                    tn=a+key;
	                    if (tn >122)
	                    {
	                        tn=tn - 122 +96;
	                    }
	                    //tn= 122-a+97;

	           }
	           else if(a>=65 && a<=90)
	           {
	               tn=a+key;
	                    if (tn >90)
	                    {
	                        tn=tn- 90 +64;
	                    }
	               
	           }
	          
	           else
	           {
	               tn=a;
	           }
	           ints = (char)tn;
	           temp=temp + ints;

	    }
	    return temp;

	}

	public static String atbash(String msg)
	{
	    String temp="";
	    char ints;
	    for(int i=0 ; i<msg.length(); i++)
	    {
	        int a = (int)msg.charAt(i);
	        int tn;
	        if(a>=97 && a<=122  )
	           {
	                    tn= 122-a+97;

	           }
	           else if(a>=65 && a<=90)
	           {
	               tn=90-a+65;
	           }
	           else if(a>=48 && a<=57)
	           {
	               tn = 57-a+48;
	           }
	           else
	           {
	               tn=a;
	           }
	           ints=(char) tn;
	           temp=temp + ints;

	    }
	    return temp;
	}
	
	


}
