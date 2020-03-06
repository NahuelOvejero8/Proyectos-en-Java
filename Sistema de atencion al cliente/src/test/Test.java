package test;

import java.time.*;
import modelo.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SistemaCallCenter sistema = new SistemaCallCenter();

		try {

			System.out.println("Punto 1:");
			sistema.agregarEmpleado("Luis", "Lopez", 33333333, 10000);
			sistema.agregarEmpleado("Lucas", "Gomes", 44444444, 9000);
			sistema.agregarCliente("Pedro", "Perez", 11111111, true);
			sistema.agregarCliente("Pablo", "Pereyra", 22222222, true);
			System.out.println(sistema.getLstPersonas());

			System.out.println("\nPunto 2: ");
			System.out.println(sistema.traerPersona(11111111));

			System.out.println("\nPunto 3:");
			System.out.println(sistema.traerPersona(33333333));

			System.out.println("\nPunto 4");
			sistema.agregarCliente("Marcos", "Rios", 22222222, true);

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("\nPunto 5:");
			sistema.agregarEmpleado("Miguel", "Martinez", 44444444, 9500);

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {

			System.out.println("\nPunto 6:");
			sistema.agregarLlamada(LocalDate.of(2019, Month.DECEMBER, 1), (Cliente) sistema.traerPersona(11111111),
					(Empleado) sistema.traerPersona(33333333), 5);

			sistema.agregarLlamada(LocalDate.of(2019, Month.DECEMBER, 1), (Cliente) sistema.traerPersona(11111111),
					(Empleado) sistema.traerPersona(44444444), 5);

			sistema.agregarLlamada(LocalDate.of(2019, Month.DECEMBER, 1), (Cliente) sistema.traerPersona(22222222),
					(Empleado) sistema.traerPersona(33333333), 5);

			sistema.agregarLlamada(LocalDate.of(2019, Month.DECEMBER, 2), (Cliente) sistema.traerPersona(11111111),
					(Empleado) sistema.traerPersona(33333333), 4);

			sistema.agregarLlamada(LocalDate.of(2019, Month.DECEMBER, 2), (Cliente) sistema.traerPersona(11111111),
					(Empleado) sistema.traerPersona(33333333), 3);

			sistema.agregarLlamada(LocalDate.of(2019, Month.DECEMBER, 2), (Cliente) sistema.traerPersona(11111111),
					(Empleado) sistema.traerPersona(33333333), 2);

			sistema.agregarLlamada(LocalDate.of(2019, Month.DECEMBER, 3), (Cliente) sistema.traerPersona(11111111),
					(Empleado) sistema.traerPersona(33333333), 5);

			System.out.println(sistema.getLstLlamadas());

			System.out.println("\nPunto 7:");
			sistema.agregarLlamada(LocalDate.of(2019, Month.DECEMBER, 1), (Cliente) sistema.traerPersona(11111111),
					(Empleado) sistema.traerPersona(33333333), 6);

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("\nPunto 8:");
			System.out.println(sistema.traerClientes());

			System.out.println("\nPunto 9:");
			System.out.println(sistema.traerEmpleados());

			System.out.println("\nPunto 10:");
			System.out.println(sistema.traerLlamada(LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 3)));

			System.out.println("\nPunto 11:");
			System.out.println(sistema.traerLlamada(LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 3), 5));

			System.out.println("\nPunto 12:");
			System.out.println(sistema.calcularPorcentajeNivelSatisfaccionLlamada(LocalDate.of(2019, 12, 1),
					LocalDate.of(2019, 12, 3), 5));

			System.out.println("\nPunto 13:");
			System.out.println(sistema.traerLlamada(LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 3),
					(Empleado) sistema.traerPersona(33333333)));

			System.out.println("\nPunto 14:");
			System.out.println(sistema.traerLlamada(LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 3),
					(Empleado) sistema.traerPersona(33333333), 5));

			System.out.println("\nPunto 15:");
			System.out.println(sistema.calcularPorcentajeNivelSatisfaccionLlamada(LocalDate.of(2019, 12, 1),
					LocalDate.of(2019, 12, 3), (Empleado) sistema.traerPersona(33333333), 5));
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
