/**
 * User: fabricio
 * Date: 10/14/12
 * Time: 9:00 PM
 */
public class Image {
    private Campo idImagen;
    private Campo grado;
    private Campo codEst;

    public Campo getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Campo idImagen) {
        this.idImagen = idImagen;
    }

    public Campo getGrado() {
        return grado;
    }

    public void setGrado(Campo grado) {
        this.grado = grado;
    }

    public Campo getCodEst() {
        return codEst;
    }

    public void setCodEst(Campo codEst) {
        this.codEst = codEst;
    }

    public Image() {
    }

    public Image(Campo idImagen, Campo grado, Campo codEst) {
        this.idImagen = idImagen;
        this.grado = grado;
        this.codEst = codEst;
    }

    @Override
    public String toString() {
        return "\n|\t\tidImagen = " + idImagen +  '\n' +
                "|\t\tgrado = " + grado +  '\n' +
                "|\t\tcodEst = " + codEst;
    }
}
