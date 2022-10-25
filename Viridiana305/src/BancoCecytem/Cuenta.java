package BancoCecytem;

import java.util.ArrayList;

public class Cuenta {
	String tipocuenta;
	double montoinicial;
	ArrayList<Movimiento> mismovimientos;

	public Cuenta() {
		mismovimientos = new ArrayList<Movimiento>();
	}

	public void addMovimiento(Movimiento m) {
		mismovimientos.add(m);
	}

	public ArrayList<Movimiento> getMismovimientos() {
		return mismovimientos;
	}

	public void setMismovimientos(ArrayList<Movimiento> mismovimientos) {
		this.mismovimientos = mismovimientos;
	}

	public String getTipocuenta() {
		return tipocuenta;
	}

	public void setTipocuenta(String tipocuenta) {
		this.tipocuenta = tipocuenta;
	}

	public double getMontoinicial() {
		return montoinicial;
	}

	public void setMontoinicial(double montoinicial) {
		this.montoinicial = montoinicial;
	}

}
