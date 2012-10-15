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
        try {

            MetaParser metaParser = new MetaParser("Archivos/Meta.xml");
            metaParser.parse();

        } catch(Exception e) {
            e.printStackTrace();
        }


    }

}
