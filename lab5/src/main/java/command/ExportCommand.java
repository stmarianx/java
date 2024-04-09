package command;

import repository.RepositoryService;
import repository.Repository;

public class ExportCommand implements Command {
    private final RepositoryService service;
    private final Repository repo;

    public ExportCommand(RepositoryService service, Repository repo) {
        this.service = service;
        this.repo = repo;
    }

    @Override
    public void execute(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: export <exportPath>");
            return;
        }
        service.export(repo, args[1]);
    }
}
