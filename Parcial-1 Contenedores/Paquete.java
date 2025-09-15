public class Paquete{

    private int IdPaquete;
    private String Destinatario;
    private String Fechaingreso;

    public Paquete(int idPaquete, String destinatario, String fechaingreso) {
        IdPaquete = idPaquete;
        Destinatario = destinatario;
        Fechaingreso = fechaingreso;
    }

    public int getIdPaquete() {
        return IdPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        IdPaquete = idPaquete;
    }

    public String getDestinatario() {
        return Destinatario;
    }

    public void setDestinatario(String destinatario) {
        Destinatario = destinatario;
    }

    public String getFechaingreso() {
        return Fechaingreso;
    }

    public void setFechaingreso(String fechaingreso) {
        Fechaingreso = fechaingreso;
    }

    @Override
    public String toString() {
        return "Paquete [ID del Paquete = " + IdPaquete 
        + ", Destinatario = " + Destinatario + 
        ", Fecha de ingreso = " +  Fechaingreso
                + "]";
    }

    

    

}