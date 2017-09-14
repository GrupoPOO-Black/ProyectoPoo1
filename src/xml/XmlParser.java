package xml;

import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.*;

/**
 * 
 * @author Keneth, Caleb, Lery
 *
 */

public class XmlParser {
	/**
	 * 
	 * @param f
	 * @param filename
	 * @throws Exception
	 */
    public static void write(Object f, String filename) throws Exception{
    	XMLEncoder e = new XMLEncoder(
                new BufferedOutputStream(
                    new FileOutputStream(filename)));
    	e.writeObject(f);
    	e.close();
    }
    
    /**
     * 
     * @param filename
     * @return
     * @throws Exception
     */
    public static Object read(String filename) throws Exception {
        XMLDecoder decoder =
            new XMLDecoder(new BufferedInputStream(
                new FileInputStream(filename)));
        Object o = decoder.readObject();
        decoder.close();
        return o;
    }

}
