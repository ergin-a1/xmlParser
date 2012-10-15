import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: fabricio
 * Date: 10/14/12
 * Time: 6:42 PM
 */
public class Main {

    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            DOMParser parser = new DOMParser();
            parser.parse("Archivos/Meta.xml");
            Document doc = parser.getDocument();
            NodeList root = doc.getChildNodes();
            Node xmlMeta = XmlHelper.getNode("XmlMetas", root);
            NamedNodeMap metas = XmlHelper.getNodesByName("Meta", xmlMeta.getChildNodes());

            for(int i=0;i<metas.getLength();i++){
                Node metaNode = metas.item(i);
                NodeList metaChildren = metaNode.getChildNodes();
                String idIDC=XmlHelper.getNodeValue("IdIDC", metaChildren);
                String creationDate=XmlHelper.getNodeValue("CreationDate", metaChildren);
                Date date = null;
                try {
                    date = dateFormat.parse(creationDate);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String status=XmlHelper.getNodeValue("Status", metaChildren);
                Node imageNode=XmlHelper.getNode("Image",metaChildren);
                NamedNodeMap campos = XmlHelper.getNodesByName("Campo", imageNode.getChildNodes());

                Campo campoIdImagen = new Campo(campos.item(0));
                Campo campoGrado = new Campo(campos.item(1));
                Campo campoCodEst = new Campo(campos.item(2));

                Image image = new Image(campoIdImagen, campoGrado, campoCodEst);

                Meta meta = new Meta(idIDC, date, status, image);

                System.out.println(meta.toString(i));
            }

            System.out.println("-----------------------------------------------------------");
            System.out.println("| Se parsearon un total de "+metas.getLength()+" Metas");
            System.out.println("-----------------------------------------------------------");

        } catch(Exception e) {
            e.printStackTrace();
        }


    }

}
