public class alarmaDesactivada implements Estado {
	@Override
	public void realizaAccion() {
		System.out.println("La alarma esta desactivada");
	}
}
