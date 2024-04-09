package repository;

import model.Document;
import model.Person;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;

public class Repository {
    private final String directory;
    private final Map<Person, List<Document>> documents = new HashMap<>();

    public Repository(String directory) {
        this.directory = directory;
        loadDocuments();
    }

    public Map<Person, List<Document>> getDocuments() {
        return documents;
    }

    private void loadDocuments() {
        try {
            Files.walk(Path.of(directory))
                    .filter(Files::isDirectory)
                    .forEach(dir -> {
                        String dirName = dir.getFileName().toString();
                        if (!dirName.equals(directory)) {
                            // Assuming the directory name is in the format "Name_ID"
                            String[] parts = dirName.split("_");
                            if (parts.length == 2) {
                                String name = parts[0];
                                int id = Integer.parseInt(parts[1]);
                                Person person = new Person(id, name);

                                List<Document> personDocuments = new ArrayList<>();
                                try {
                                    Files.walk(dir)
                                            .filter(Files::isRegularFile)
                                            .forEach(file -> {
                                                String fileName = file.getFileName().toString();
                                                String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
                                                personDocuments.add(new Document(fileName, fileType));
                                            });
                                } catch (IOException e) {
                                    System.err.println("Error reading files for " + name + ": " + e.getMessage());
                                }

                                documents.put(person, personDocuments);
                            }
                        }
                    });
        } catch (IOException e) {
            System.err.println("Error walking through the repository directory: " + e.getMessage());
        }
    }
}
