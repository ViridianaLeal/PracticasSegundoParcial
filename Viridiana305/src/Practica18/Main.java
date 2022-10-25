package Practica18;

public class Main {

	public static void main(String[]args){
		Celular poco = new Celular();
		poco.setMarca("Huawei");
		poco.setModelo("Y7 a");
		poco.setProcesador("HUAWEI kirin 710A");
		poco.setCamara("50Mp");
		poco.setRam(4);
		poco.setPantalla(6.7);
		poco.setRom(32);
		Celular x4=new Celular("xiaomi", "POCO x4 Pro", "SnapDragon", "108Mp", 8, 6.7, 256);
		x4.setMarca("LG");
		
		
		
		Celular mio =new Celular("HUAWEI", "PPA-LX3", "HUAWEI kirin 710A", "48MP", 4, 6.7, 32);
		System.out.println(poco.toString());
		System.out.println(x4.toString());
		System.out.println(mio.toString());
		System.out.println("ROM: "+x4.getRom());
	}
}
