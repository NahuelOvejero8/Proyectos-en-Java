package modelo;

import java.time.LocalDate;
import java.util.*;

public class SistemaCallCenter {

	// ATRIBUTOS
	private List<Llamada> lstLlamadas;
	private List<Persona> lstPersonas;

	public SistemaCallCenter() {
		super();
		this.lstLlamadas = new ArrayList<Llamada>();
		this.lstPersonas = new ArrayList<Persona>();

	}

	// GETTER Y SETTER
	public List<Llamada> getLstLlamadas() {
		return lstLlamadas;
	}

	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}

	// 1).
	public Persona traerPersona(long dni) {
		int indice = 0;
		Persona persona = null;
		while (indice < lstPersonas.size() && persona == null) {
			if (lstPersonas.get(indice).getDni() == dni) {
				persona = lstPersonas.get(indice);
			}
			indice++;
		}

		return persona;
	}

	// 2).
	public boolean agregarCliente(String nombre, String apellido, long dni, boolean activo) throws Exception {
		if (this.traerPersona(dni) != null)
			throw new Exception("El dni ya se encuentra registrado");
		int idPersona = 1;
		if (!lstPersonas.isEmpty()) {
			idPersona = lstPersonas.get(lstPersonas.size() - 1).getIdPersona() + 1;
		}
		return lstPersonas.add(new Cliente(idPersona, nombre, apellido, dni, activo));
	}

	// 3).
	public boolean agregarEmpleado(String nombre, String apellido, long dni, int sueldoBase) throws Exception {
		if (this.traerPersona(dni) != null)
			throw new Exception("El dni ya se encuentra registrado");
		int idPersona = 1;
		if (!lstPersonas.isEmpty()) {
			idPersona = lstPersonas.get(lstPersonas.size() - 1).getIdPersona() + 1;
		}
		return lstPersonas.add(new Empleado(idPersona, nombre, apellido, dni, sueldoBase));
	}

	// 5)
	public boolean agregarLlamada(LocalDate fecha, Cliente cliente, Empleado empleado, int nivelSatisfaccion)
			throws Exception {
		int idLlamada = 1;
		if (!lstLlamadas.isEmpty()) {
			idLlamada = lstLlamadas.get(lstLlamadas.size() - 1).getIdLlamada() + 1;
		}
		return lstLlamadas.add(new Llamada(idLlamada, cliente, empleado, fecha, nivelSatisfaccion));
	}

	// 6).
	public List<Cliente> traerClientes() {
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		for (Persona indice : lstPersonas) {
			if (indice instanceof Cliente) {
				listaCliente.add((Cliente) indice);
			}
		}
		return listaCliente;
	}

	// 7).
	public List<Empleado> traerEmpleados() {
		List<Empleado> listaEmpleado = new ArrayList<Empleado>();
		for (Persona indice : lstPersonas) {
			if (indice instanceof Empleado) {
				listaEmpleado.add((Empleado) indice);
			}
		}
		return listaEmpleado;
	}

	// 8).
	public List<Llamada> traerLlamada(LocalDate desde, LocalDate hasta) {
		List<Llamada> llamadas = new ArrayList<Llamada>();
		for (Llamada indice : lstLlamadas) {
			if (indice.getFecha().isAfter(desde)
					|| indice.getFecha().isEqual(desde) && indice.getFecha().isBefore(hasta)
					|| indice.getFecha().isEqual(hasta)) {

				llamadas.add(indice);

			}
		}
		return llamadas;
	}

	// 9).
	public List<Llamada> traerLlamada(LocalDate desde, LocalDate hasta, int nivelSatisfaccion) {
		List<Llamada> llamadas = new ArrayList<Llamada>();
		for (Llamada indice : this.traerLlamada(desde, hasta)) {
			if (indice.getNivelSatisfaccion() == nivelSatisfaccion) {
				llamadas.add(indice);
			}
		}
		return llamadas;
	}

	// 10).
	public double calcularPorcentajeNivelSatisfaccionLlamada(LocalDate desde, LocalDate hasta, int nivelSatisfaccion) {

		return (this.traerLlamada(desde, hasta, nivelSatisfaccion).size() * 100)
				/ (this.traerLlamada(desde, hasta).size());
	}

	// 11).
	public List<Llamada> traerLlamada(LocalDate desde, LocalDate hasta, Empleado empleado) {
		List<Llamada> llamadas = new ArrayList<Llamada>();
		for (Llamada indice : this.traerLlamada(desde, hasta)) {
			if (indice.getEmpleado().equals(empleado)) {
				llamadas.add(indice);
			}
		}
		return llamadas;
	}

	// 12).
	public List<Llamada> traerLlamada(LocalDate desde, LocalDate hasta, Empleado empleado, int nivelSatisfaccion)

	{
		List<Llamada> llamadas = new ArrayList<Llamada>();
		for (Llamada indice : this.traerLlamada(desde, hasta, empleado)) {
			if (indice.getNivelSatisfaccion() == nivelSatisfaccion) {
				llamadas.add(indice);
			}
		}
		return llamadas;

	}

	// 13).
	public double calcularPorcentajeNivelSatisfaccionLlamada(LocalDate desde, LocalDate hasta, Empleado empleado,
			int nivelSatisfaccion) {
		return (this.traerLlamada(desde, hasta, empleado, nivelSatisfaccion).size() * 100)
				/ (this.traerLlamada(desde, hasta).size());
	}

}
