package es.florida.psp.a3;

public class Ejercicio5 implements Runnable {
	int alitasDisponibles = 100;
	static int alitasConsumidas = 0;

	synchronized public void consumirAlita(String nombre, int alitas) {
	//public void consumirAlita(String nombre, int alitas) {
		if (alitasDisponibles >= alitas) {
			System.out.println(nombre + ": " + alitas + " alitas consumidas");
			alitasDisponibles -= alitas;
			alitasConsumidas += alitas;
			System.out.println("\tQUEDAN "+alitasDisponibles+" ALITAS DISPONIBLES");
		} else {
			System.out.println(nombre+" quiere "+alitas+" alitas, pero no quedan suficientes :((");
		} // end-if
	} // end-consumirAlita

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ejercicio5 ejercicio5 = new Ejercicio5();
		Thread t;
		for (int i = 0; i < 30; i++) {
			t = new Thread(ejercicio5);
			t.setName("Amigo "+(i+1));
			t.start();
		} // end-for
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} // end-try-catch
		System.out.println("Total alitas consumidas: "+alitasConsumidas);
	} // end-main

	public void run () {
		String nombre = Thread.currentThread().getName();
		int alitas = (int) (Math.random() * 10 + 1);
		consumirAlita(nombre, alitas);
	} // end-run

}
