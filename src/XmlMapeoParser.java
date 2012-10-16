import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: fabricio
 * Date: 10/15/12
 * Time: 10:13 PM
 */
public class XmlMapeoParser {

    private DOMParser parser = new DOMParser();
    private String fileLocation="";
    private Document doc;
    private NodeList root;
    private Node xmlMapeoNode;
    private NamedNodeMap mapeoLists;

    public XmlMapeoParser(String fileLocation) throws IOException, SAXException {
        this.fileLocation = fileLocation;
        parser.parse(this.fileLocation);
        this.doc = parser.getDocument();
        this.root = doc.getChildNodes();
        this.xmlMapeoNode = XmlHelper.getNode("XmlMapeo", root);
        this.mapeoLists = XmlHelper.getNodesByName("MapeoList", xmlMapeoNode.getChildNodes());
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

    public Node getXmlMapeoNode() {
        return xmlMapeoNode;
    }

    public NamedNodeMap getMapeoLists() {
        return mapeoLists;
    }

    public void parse() {

        NodeList xmlMapeoNodeChildren = xmlMapeoNode.getChildNodes();
        XmlMapeo xmlMapeo = new XmlMapeo(xmlMapeoNode.getChildNodes());
        xmlMapeo.setMapeoLists(mapeoLists);

        System.out.println(xmlMapeo);

        for(int i=0;i<mapeoLists.getLength();i++){
            Node mapeoListNode = mapeoLists.item(i);
            NodeList mapeoChildren = mapeoListNode.getChildNodes();
            MapeoList mapeoList = new MapeoList(mapeoChildren);

            System.out.println(mapeoList);
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("|          Se parsearon un total de "+mapeoLists.getLength()+" MapeoLists                      |");
        System.out.println("-----------------------------------------------------------------------");
    }

}
