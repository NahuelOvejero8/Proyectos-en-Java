package modelo;

import java.time.LocalDate;

public class Llamada {

	// ATRIBUTOS
	private int idLlamada;
	private Cliente cliente;
	private Empleado empleado;
	private LocalDate fecha;
	private int nivelSatisfaccion;

	// CONSTRUCTOR
	public Llamada(int idLlamada, Cliente cliente, Empleado empleado, LocalDate fecha, int nivelSatisfaccion)
			throws Exception {
		super();
		this.idLlamada = idLlamada;
		this.cliente = cliente;
		this.empleado = empleado;
		this.fecha = fecha;
		this.setNivelSatisfaccion(nivelSatisfaccion);
	}

	// GETTER Y SETTER
	public int getIdLlamada() {
		return idLlamada;
	}

	public void setIdLlamada(int idLlamada) {
		this.idLlamada = idLlamada;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getNivelSatisfaccion() {
		return nivelSatisfaccion;
	}

	public void setNivelSatisfaccion(int nivelSatisfaccion) throws Exception {
		if (!this.validarNivelSatisfaccion(nivelSatisfaccion))
			throw new Exception("El nivel de satisfaccion debe estar entre 1 y 5");
		this.nivelSatisfaccion = nivelSatisfaccion;
	}

	// 4).
	public boolean validarNivelSatisfaccion(int nivelSatisfaccion) {
		return nivelSatisfaccion >= 1 && nivelSatisfaccion <= 5;
	}

	// REDEFINICION DE TO STRING
	@Override
	public String toString() {
		return "\nLlamada [idLlamada=" + idLlamada + ", cliente=" + cliente + ", empleado=" + empleado + ", fecha="
				+ fecha + ", nivelSatisfaccion=" + nivelSatisfaccion + "]";
	}

}
