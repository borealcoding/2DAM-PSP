package es.florida.psp.a3;

public class Semaforo {
	public static class Semaforos {
		// declaraciones
		int semaforo = 1;
		int tiempoFuncionamiento = 5000;
	
		public void encenderSemaforo1() {
			while(true) {
				synchronized (this) {
					try {
						while (semaforo == 2) wait();
						System.err.print("Semaforo 2 ROJO");
						System.out.println(" -> Semaforo 1 VERDE durante "+tiempoFuncionamiento/1000+" segundos");
						Thread.sleep(tiempoFuncionamiento);
						semaforo = 2;
						notify();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} // end-try-catch
				} // end-synchronized
			} // end-while
		} // end-encenderSemaforo1
	
		public void encenderSemaforo2() {
			while (true) {
				synchronized (this) {
					try {
						while (semaforo == 1) wait();
						System.err.print("Semaforo 1 ROJO");
						System.out.println(" -> Semaforo 2 VERDE durante "+tiempoFuncionamiento/1000+" segundos");
						Thread.sleep(tiempoFuncionamiento);
						semaforo = 1;
						notify();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} // end-try-catch
				} // end-synchronized
			} // end-while
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Semaforos s = new Semaforos();
			// Hilo semaforo 1 encendido
			Thread hilo1 = new Thread(new Runnable() {
				@Override
				public void run() {
					s.encenderSemaforo1();
				} // end-run
			}); // end-Thread
			
			// Hilo semaforo 2 encendido
			Thread hilo2 = new Thread(new Runnable() {
				@Override
				public void run() {
					s.encenderSemaforo2();
				} // end-run
			}); // end-Thread
			hilo1.start();
			hilo2.start();
		} // end-main
	} // end-Semaforos
} // end-class
