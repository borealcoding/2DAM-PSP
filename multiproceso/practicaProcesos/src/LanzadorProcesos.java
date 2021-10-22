/**
 * 
 */

/**
 * @author Eduardo Rua Chamorro
 *
 */
public class LanzadorProcesos {
	public void ejecutar(String ruta) {
		ProcessBuilder pb;
		try {
			pb = new ProcessBuilder(ruta);
			pb.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ruta = "C:\\Users\\edvard\\AppData\\Local\\Programs\\Hyper\\Hyper.exe";
		LanzadorProcesos lp = new LanzadorProcesos();
		lp.ejecutar(ruta);
		System.out.println("Finalizado!");
	}

}
