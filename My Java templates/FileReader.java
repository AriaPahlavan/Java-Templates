/**
 * Template that opens and reads an input file.
 * @author Aria Pahlavan
 * @version 1.00 Spring 2016
 */

// TODO: enter valid package name
package package_name;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is a template with TODOs that needs to be
 * done before being used by other classes.
 *
 * Created by Aria Pahlavan on Spring 2016.
 */
public class FileReader {


    public ArrayList<String> readFile(String filename) {
        //Opening file and scanning the contents
        File file = new File(filename);

        // Instantiate scanner to null reference to allow for closing compatibility with try-catch block
        Scanner scan = null;
        ArrayList<String> lines = new ArrayList<String>();


        try {
            scan = new Scanner(file);

            while ( scan.hasNext() ) {

                //TODO: implement this loop to process the file.

            }
        } catch (FileNotFoundException fnfe) {
            // File name was not correct or not visible from its current position in file system hierarchy
            System.err.println("Error - File " + filename + " was not found.");
            System.exit(0);
        } finally {
            //Close the scanner safely.
            if ( scan != null ) {
                scan.close();
            }
        }

        return lines;
    }

}
