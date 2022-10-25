package BancoCecytem;

public class Movimiento {
	String tipomovimiento;
	String fechamovimiento;
	double monto;

	public Movimiento() {

	}

	public String getTipomovimiento() {
		return tipomovimiento;
	}

	public void setTipomovimiento(String tipomovimiento) {
		this.tipomovimiento = tipomovimiento;
	}

	public String getFechamovimiento() {
		return fechamovimiento;
	}

	public void setFechamovimiento(String fechamovimiento) {
		this.fechamovimiento = fechamovimiento;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

}
