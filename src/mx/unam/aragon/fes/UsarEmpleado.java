package mx.unam.aragon.fes;

public class UsarEmpleado {
    public static void main(String[] args) {
        Empleado empleado = new Empleado();
        empleado.setNombre("Yael");
        empleado.setSueldo(1000.0);
        empleado.setHorasExtra(10);
        System.out.println("Total: " + empleado.calcularSueldo());
    }
}
