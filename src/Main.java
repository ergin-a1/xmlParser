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
