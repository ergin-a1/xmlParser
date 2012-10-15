import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: fabricio
 * Date: 10/14/12
 * Time: 8:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Meta {
    private String idIDC;
    private Date creationDate;
    private String status;
    private Image image;

    public String getIdIDC() {
        return idIDC;
    }

    public void setIdIDC(String idIDC) {
        this.idIDC = idIDC;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Meta() {
    }

    public Meta(String idIDC, Date creationDate, String status, Image image) {
        this.idIDC = idIDC;
        this.creationDate = creationDate;
        this.status = status;
        this.image = image;
    }
}
