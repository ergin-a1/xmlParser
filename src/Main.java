/**
 * User: fabricio
 * Date: 10/14/12
 * Time: 6:42 PM
 */
public class Main {

    public static void main(String[] args) {
        try {

//            MetaParser metaParser = new MetaParser("Archivos/Meta.xml");
//            metaParser.parse();

              XmlMapeoParser mapeoParser = new XmlMapeoParser("Archivos/Mapeo.xml");
              mapeoParser.parse();

        } catch(Exception e) {
            e.printStackTrace();
        }


    }

}
