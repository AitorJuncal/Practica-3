import java.util.ArrayList;
import java.util.Date;


public class GestionAlarmas {
	private ArrayList<Alarma> alarmas = new ArrayList<Alarma>();
	private ArrayList<Alarma> alarmasActivas = new ArrayList<Alarma>();
	private ArrayList<Alarma> alarmasDesactivadas = new ArrayList<Alarma>();
	private alarmaActivada activa = new alarmaActivada();
	private alarmaDesactivada desactivada = new alarmaDesactivada();
	private Date fecha = new Date();
	
	public void anhadeAlarma(Alarma alarma) {
		if (existeAlarma(alarma)) {
			System.exit(0);
		}
		ActivaAlarma(alarma);
		alarmas.add(alarma);
	}
	
	public void eliminaAlarma(Alarma alarma) {
		if (!existeAlarma(alarma)) {
			System.exit(0);
		}
		alarmas.remove(alarma);
	}
	
	public Alarma buscaAlarma(int id) {
		for (Alarma a : alarmas) {
			if(a.getId() == id) {
				return a;
			}
		}
		return null;
	}
	
	private boolean existeAlarma(Alarma alarma) {
		for (Alarma a : alarmas) {
			if (a.equals(alarma)) {
				return true;
			}
		}
		return false;
	}
	
	public void ActivaAlarma(Alarma alarma) {
		if (!existeAlarma(alarma)) {
			System.exit(0);
		}
		if (alarmasActivas.contains(alarma)) {
			System.exit(0);
		}
		if (alarmasDesactivadas.contains(alarma)) {
			alarmasDesactivadas.remove(alarma);
		}
		alarmasActivas.add(alarma);
		alarma.setEstado(activa);
		alarma.getEstado().realizaAccion();
		while(fecha != alarma.getHora()) {
			System.out.println("Esperando a que llegue la hora");
		}
		activarMelodia();
	}
	
	public void desactivaAlarma(Alarma alarma) {
		if (!existeAlarma(alarma)) {
			System.exit(0);
		}
		if (alarmasDesactivadas.contains(alarma)) {
			System.exit(0);
		}
		alarmasDesactivadas.add(alarma);
		alarmasActivas.remove(alarma);
		alarma.setEstado(desactivada);
		alarma.getEstado().realizaAccion();
		desactivarMelodia();
	}
	
	public ArrayList<Alarma> alarmasActivas() {
		return alarmasActivas;
	}
	
	public ArrayList<Alarma> alarmasDesactivadas() {
		return alarmasDesactivadas;
	}
	
	private void activarMelodia() {
		System.out.println("La melodia esta activada");
	}
	
	private void desactivarMelodia() {
		System.out.println("La melodia esta desactivada");
	}
}
