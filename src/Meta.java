import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: fabricio
 * Date: 10/14/12
 * Time: 8:58 PM
 */

public class Meta {
    private String idIDC;
    private Date creationDate;
    private String status;
    private Image image;

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

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

    public Meta(NodeList nodes){
        String idIDC=XmlHelper.getNodeValue("IdIDC", nodes);
        String creationDate=XmlHelper.getNodeValue("CreationDate", nodes);
        Date date = null;
        try {
            date = dateFormat.parse(creationDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String status=XmlHelper.getNodeValue("Status", nodes);
        Node imageNode=XmlHelper.getNode("Image",nodes);
        NamedNodeMap campos = XmlHelper.getNodesByName("Campo", imageNode.getChildNodes());
        Campo campoIdImagen = new Campo(campos.item(0));
        Campo campoGrado = new Campo(campos.item(1));
        Campo campoCodEst = new Campo(campos.item(2));
        Image image = new Image(campoIdImagen, campoGrado, campoCodEst);

        this.idIDC = idIDC;
        this.creationDate = date;
        this.status = status;
        this.image = image;
    }

    public String toString(int id) {
        return "-----------------------------------------------------------------------\n"+
                "|                              META "+(id+1)+"                               |\n"+
                "-----------------------------------------------------------------------\n"+
                "|\tidIDC = '" + idIDC + "\'\n" +
                "|\tcreationDate = " + creationDate + '\n' +
                "|\tstatus = '" + status + '\'' + '\n' +
                "|\timage = " + image.toString();
    }
}
