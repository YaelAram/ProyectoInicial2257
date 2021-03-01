package mx.unam.aragon.fes.conector;

import mx.unam.aragon.fes.Empleado;

public class Conector {
    private static final Empleado empleado = new Empleado();

    public Conector(){

    }

    public static Empleado getEmpleado() {
        return empleado;
    }

    public static boolean PersonaDireccionEmpleadoNoVacio(){
        return empleado.PersonaNoVacio() && empleado.EmpleadoNoVacio() && empleado.getDireccion().DireccionNoVacio();
    }
}
