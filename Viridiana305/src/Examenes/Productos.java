package Examenes;

public class Productos {
   String fecha;
   String Producto;
   int Existencia;
   int Precio;
   String Descripcion;
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public String getProducto() {
	return Producto;
}
public void setProducto(String producto) {
	Producto = producto;
}
public int getExistencia() {
	return Existencia;
}
public void setExistencia(int existencia) {
	Existencia = existencia;
}
public int getPrecio() {
	return Precio;
}
public void setPrecio(int precio) {
	Precio = precio;
}
public String getDescripcion() {
	return Descripcion;
}
public void setDescripcion(String descripcion) {
	Descripcion = descripcion;
}
@Override
public String toString() {
	return "Productos [fecha=" + fecha + ", Producto=" + Producto + ", Existencia=" + Existencia + ", Precio=" + Precio
			+ ", Descripcion=" + Descripcion + "]";
}
   
}
