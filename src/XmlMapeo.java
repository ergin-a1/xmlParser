import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: fabricio
 * Date: 10/15/12
 * Time: 10:09 PM
 */
public class XmlMapeo {
    private String idIDC;
    private Date creationDate;
    private String status;
    private NamedNodeMap mapeoLists;

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

    public NamedNodeMap getMapeoLists() {
        return mapeoLists;
    }

    public void setMapeoLists(NamedNodeMap mapeoLists) {
        this.mapeoLists = mapeoLists;
    }

    public XmlMapeo() {
    }

    public XmlMapeo(String idIDC, Date creationDate, String status, NamedNodeMap mapeoLists) {
        this.idIDC = idIDC;
        this.creationDate = creationDate;
        this.status = status;
        this.mapeoLists = mapeoLists;
    }
    
    public XmlMapeo(NodeList nodes) {
        this.idIDC = XmlHelper.getNodeValue("IdIDC", nodes);
        String date = XmlHelper.getNodeValue("CreationDate", nodes);
        Date creationDate = null;
        try {
            creationDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.creationDate = creationDate;
        this.status = XmlHelper.getNodeValue("Status", nodes);
    }

    @Override
    public String toString() {
        return "XmlMapeo{" +
                "idIDC='" + idIDC + '\'' +
                ", creationDate=" + creationDate +
                ", status='" + status + '\'' +
                ", mapeoLists=" + mapeoLists +
                '}';
    }
}
