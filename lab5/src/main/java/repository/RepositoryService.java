package repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Document;
import model.Person;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class RepositoryService {

    // Print the contents of the repository
    public void print(Repository repo) {
        Map<Person, List<Document>> documents = repo.getDocuments(); // Ensure Repository provides this method.

        System.out.println("Repository Contents:");
        documents.forEach((person, docs) -> {
            System.out.println(person + " has the following documents:");
            docs.forEach(doc -> System.out.println("\t- " + doc.getName() + " (" + doc.getFileType() + ")"));
        });
    }

    // Export the repository to a JSON file
    public void export(Repository repo, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Assuming Repository class has a method to get the entire documents map or adjust accordingly
        Map<Person, List<Document>> documents = repo.getDocuments(); // Ensure Repository provides this method.

        // Writing the map to the specified file path
        objectMapper.writeValue(new File(path), documents);
    }

    // You might need additional methods here based on your application's requirements.
}
