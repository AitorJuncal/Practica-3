import java.util.Date;

public class Alarma {
	private final int id;
	private Estado estado;
	private Date hora;
	
	public Alarma(int id, Date hora) {
		this.id = id;
		this.hora = hora;
	}
	
	public int getId() {
		return id;
	}
	
	public Estado getEstado() {
		return this.estado;
	}
	
	public Date getHora() {
		return hora;
	}
	
	public void setEstado(Estado e) {
		this.estado = e;
	}
	
	public void realizaAccion() {
		estado.realizaAccion();
	}
}
