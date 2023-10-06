import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.*;
//all required imports



public class Main {
    public static void main(String[] args) throws IOException {

        //System.getProperties().put("proxySet", "true");
        //System.getProperties().put("proxyHost", "152.78.255.75");
        //System.getProperties().put("proxyPort", "3128");
        //Meant to setup a proxy to get past the USO firewall, currently not working

        BufferedReader readerText = new BufferedReader(new InputStreamReader(System.in));
        //sets up the bufferreader to reader text inputted to the console
        System.out.println("Please enter an E-mail ID: ");
        String inputID = readerText.readLine();
        //reads a string from the console, in this case intended to be the E-mail ID of a user
        readerText.close();
        //closes the bufferreader

        String stringURL = "https://secure.ecs.soton.ac.uk/people/" + inputID;
        //concatinates the web address of the desired output page
        URI fullURI = URI.create(stringURL);
        //creates a URI using the web address, URI is used to create the URL
        URL fullURL = fullURI.toURL();
        //creates a URL using the URI. URL can be used to search the webpage
        System.out.println(fullURL);
        //prints the URL to ensure its the correct one <will be removed later>

        BufferedReader readerURL = new BufferedReader( new InputStreamReader(fullURL.openStream()));
        //creates a bufferreader to read the contents of the websearch using the URL
        String inputLine;
        while ((inputLine = readerURL.readLine()) != null)
            //cycles through every line of html on the webpage, will be used to search for the line wil the users name on
            System.out.println(inputLine);
        readerURL.close();
        //closes the buffer reader




    }
}