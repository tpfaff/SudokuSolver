
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		phone p=new phone(4.0f,"htc","android");
		tablet t=new tablet(7.0f,"asus","android");
		
		base[] arr=new base[2];
		arr[0]=p;
		arr[1]=t;
		
		for(base b:arr){
			b.setCpu("a9");
			
			
		}
	}

}
