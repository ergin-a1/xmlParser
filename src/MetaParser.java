import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

/**
 * User: fabricio
 * Date: 10/15/12
 * Time: 11:50 AM
 */
public class MetaParser {

    private DOMParser parser = new DOMParser();
    private String fileLocation="";
    private Document doc;
    private NodeList root;
    private Node xmlMeta;
    private NamedNodeMap metas;

    public MetaParser(String fileLocation) throws IOException, SAXException {
        this.fileLocation = fileLocation;
        parser.parse(this.fileLocation);
        this.doc = parser.getDocument();
        this.root = doc.getChildNodes();
        this.xmlMeta = XmlHelper.getNode("XmlMetas", root);
        this.metas = XmlHelper.getNodesByName("Meta", xmlMeta.getChildNodes());
    }

    public DOMParser getParser() {
        return parser;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public Document getDoc() {
        return doc;
    }

    public NodeList getRoot() {
        return root;
    }

    public Node getXmlMeta() {
        return xmlMeta;
    }

    public NamedNodeMap getMetas() {
        return metas;
    }

    public void parse(){
        for(int i=0;i<metas.getLength();i++){
            Node metaNode = metas.item(i);
            NodeList metaChildren = metaNode.getChildNodes();
            Meta meta = new Meta(metaChildren);
            System.out.println(meta.toString(i));
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("|             Se parsearon un total de "+metas.getLength()+" Metas                      |");
        System.out.println("-----------------------------------------------------------------------");
    }

}
