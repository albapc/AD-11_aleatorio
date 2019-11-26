package aleatorio;

/**
 *
 * @author Alba
 */
public class Products {

    private String codigo, descricion;
    private int prezo;

    public Products() {
        this.codigo = null;
        this.descricion = null;
        this.prezo = 0;
    }

    public Products(String codigo, String descricion, int prezo) {
        this.codigo = codigo;
        this.descricion = descricion;
        this.prezo = prezo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    public double getPrezo() {
        return prezo;
    }

    public void setPrezo(int prezo) {
        this.prezo = prezo;
    }

    @Override
    public String toString() {
        return codigo + "\n" + descricion + "\n"
                + prezo;

    }

}
