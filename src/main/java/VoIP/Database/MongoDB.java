package VoIP.Database;

// MongoDB imports
import com.mongodb.client.*;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.descending;
import java.util.logging.Logger;
import java.util.logging.Level;
// PrintOut class import
import VoIP.Misc.PrintOut;

import javax.swing.JOptionPane;

public class MongoDB {
    // NOTE: Never Commit with a visible uri!!!!
        private static final String CONNECT_URI =
    "";

    public static void main(String[] args) {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        if (CONNECT_URI.equals("")) {
            PrintOut.printError("Empty URI string!");
        } else {
            try (MongoClient mongoClient = MongoClients.create(CONNECT_URI)) {
                PrintOut.printInfo("Database connection success!");
            } catch (Exception e){
                PrintOut.printError("Database connection failed!");
            }
        }
    }

    public static boolean checkLoginCred(String givenUser, String givenPass) {
        boolean correctPass = false;
        boolean correctUser = false;

        if (CONNECT_URI.equals("")) {
            PrintOut.printError("Empty URI string!");
        } else {
            Document queryUser = getEntry("username", givenUser);
            if (queryUser != null) {
                if (queryUser.get("username").equals(givenUser)) {
                    correctUser = true;
                }
                if (queryUser.get("password").equals(givenPass)) {
                    correctPass = true;
                }
            }
        }
        return (correctUser && correctPass);
    }

    public static boolean registerUser(String givenUser, String givenPass, String givenEmail) {
        boolean userExists = false;
        boolean emailExists = false;
        Document queryUser = getEntry("username", givenUser);
        Document queryEmail = getEntry("email", givenEmail);

        if (queryUser != null) {
            if (queryUser.get("username").equals(givenUser)) {
                userExists = true;
            }
        }

        if (queryEmail != null) {
            if (queryEmail.get("email").equals(givenEmail)) {
                emailExists = true;
            }
        }

        if (userExists || emailExists) {
            // The details are already in use
            JOptionPane.showMessageDialog(null, "Details already in use.");
        } else {
            // Do the registration
            if (newEntry(givenUser, givenPass, givenEmail)) {
                JOptionPane.showMessageDialog(null, "Registration success! Please Login.");
            } else {
                JOptionPane.showMessageDialog(null, "Registration failure! Please contact one of our system admins.");
            }
        }

        return !(userExists || emailExists);
    }

    private static Document getEntry(String field, String query) {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        try (MongoClient mongoClient = MongoClients.create(CONNECT_URI)) {
            // Make connection to the databse
            MongoDatabase testDB = mongoClient.getDatabase("Test_DB");

            // Get the required "collection"
            MongoCollection<Document> myCollection = testDB.getCollection("Test_Collection");

            // Save the required query in a "Document" object
            Document req = myCollection.find(new Document(field, query)).first();
            return req;
        } catch (Exception e) {
            return null;
        }
    }

    private static boolean newEntry(String givenUser, String givenPass, String givenEmail) {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        try (MongoClient mongoClient = MongoClients.create(CONNECT_URI)) {
            // Make connection to the databse
            MongoDatabase testDB = mongoClient.getDatabase("Test_DB");

            // Get the required "collection"
            MongoCollection<Document> myCollection = testDB.getCollection("Test_Collection");

            // Create the new Document object
            Document newUser = new Document("username", givenUser);
            newUser.append("password", givenPass).append("email", givenEmail);

            // Insert new user
            myCollection.insertOne(newUser);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
