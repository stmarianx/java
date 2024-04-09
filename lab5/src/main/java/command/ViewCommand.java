package command;

import java.awt.Desktop;
import java.io.File;
import java.nio.file.Paths;

// View Command: Opens a document using the system's default application. utilizing the Desktop class to open files
public class ViewCommand implements Command {
    @Override
    public void execute(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: view <documentPath>");
            return;
        }
        File file = new File(args[1]);
        if (file.exists()) {
            Desktop.getDesktop().open(file);
        } else {
            System.out.println("File does not exist: " + args[1]);
        }
    }
}
