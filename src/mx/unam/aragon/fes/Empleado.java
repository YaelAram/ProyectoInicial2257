package mx.unam.aragon.fes;

public class Empleado extends Persona {
    private int numeroEmpleado;
    private String departamento;
    private double sueldo;
    private int horasExtra;
    private Direccion direccion;

    public Empleado() {
    }

    public Empleado(int numeroEmpleado, String departamento, float sueldo, int horasExtra, Direccion direccion) {
        this.numeroEmpleado = numeroEmpleado;
        this.departamento = departamento;
        this.sueldo = sueldo;
        this.horasExtra = horasExtra;
        this.direccion = direccion;
    }

    public Empleado(String nombre, String apellidoPaterno, String apellidoMaterno, int edad, String curp, int numeroEmpleado, String departamento, float sueldo, int horasExtra, Direccion direccion) {
        super(nombre, apellidoPaterno, apellidoMaterno, edad, curp);
        this.numeroEmpleado = numeroEmpleado;
        this.departamento = departamento;
        this.sueldo = sueldo;
        this.horasExtra = horasExtra;
        this.direccion = direccion;
    }

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "numeroEmpleado=" + numeroEmpleado +
                ", departamento='" + departamento + '\'' +
                ", sueldo=" + sueldo + '\'' +
                ", horasExtra=" + horasExtra + '\'' +
                ", direccion=" + direccion.toString() +
                '}';
    }

    public double calcularSueldo(){
        return 30.0 * this.sueldo + (this.horasExtra * 150.0);
    }
}
