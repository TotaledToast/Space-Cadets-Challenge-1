import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.*;
import java.util.Objects;
//all required imports



public class Main {
    public static void main(String[] args) throws IOException {
        //This program takes an E-mail ID from a user and then finds the name of the corresponding person and prints it to the console. If no person corresponds to the E-mail ID the user is told there is no corresponding person.


        BufferedReader readerText = new BufferedReader(new InputStreamReader(System.in));
        //sets up the bufferreader to reader text inputted to the console
        System.out.println("Please enter an E-mail ID: ");
        String inputID = readerText.readLine();
        //reads a string from the console, in this case intended to be the E-mail ID of a user
        readerText.close();
        //closes the bufferreader

        String stringURL = "https://www.southampton.ac.uk/people/" + inputID;
        //concatinates the web address of the desired output page
        URI fullURI = URI.create(stringURL);
        //creates a URI using the web address, URI is used to create the URL
        URL fullURL = fullURI.toURL();
        //creates a URL using the URI. URL can be used to search the webpage

        BufferedReader readerURL = new BufferedReader( new InputStreamReader(fullURL.openStream()));
        //creates a bufferreader to read the contents of the websearch using the URL
        String outputLine;
        while ((outputLine = readerURL.readLine()) != null) {
            //cycles through every line of html on the webpage, will be used to search for the line wil the users name on
            if (outputLine.contains("og:title")) {
                //the html line containing the name of the use is a meta tag with the property "og:title", meaning we can search for this property tag to find the name
                String[] splitString = outputLine.split("content=\"");
                //Splits the line of html so that the begining of the second half of the split is the name of the professor. This is because the name of the professor is prefaced by "content="
                String Name = splitString[1].split("\"")[0];
                //splits the section with the professors name in it down to just the name, by removing everything after the quotation mark after the name
                if (Objects.equals(Name, "Find a person")){
                    //if the E-mail id doesnt correspond to a person the meta tag with property "og:title" will instead read "Find a person". In this case it instead tells the user that no person with this E-mail ID is available
                    System.out.println("There is no person corresponding with this E-mail ID on the Southampton website!");
                } else {
                    System.out.println(Name);
                    //prints out the found persons name
                }
                break;
            }
        }
        readerURL.close();
        //closes the buffer reader




    }
}