package command;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import repository.Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand implements Command {
    private final Repository repository;

    public ReportCommand(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(String[] args) {
        Configuration cfg = new Configuration(new Version("2.3.31"));
        cfg.setClassForTemplateLoading(ReportCommand.class, "/templates");
        cfg.setDefaultEncoding("UTF-8");

        try {
            Template template = cfg.getTemplate("reportTemplate.html");
            Map<String, Object> templateData = new HashMap<>();
            templateData.put("repository", repository.getDocuments());

            File reportFile = new File("repositoryReport.html");
            try (Writer fileWriter = new FileWriter(reportFile)) {
                template.process(templateData, fileWriter);
            }
            System.out.println("Report generated: " + reportFile.getAbsolutePath());
        } catch (IOException | TemplateException e) {
            System.err.println("Failed to generate report: " + e.getMessage());
        }
    }
}
