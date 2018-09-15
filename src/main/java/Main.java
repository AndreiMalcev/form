import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JsonDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws JRException, FileNotFoundException {
        File reportFile = new File("data/template.jrxml");
        JasperDesign jasperDesign = JRXmlLoader.load(reportFile);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(),
                new JsonDataSource(new File("data/election.json"), "elections"));
        JasperExportManager.exportReportToHtmlFile(jasperPrint, "result/result.html");
    }
}