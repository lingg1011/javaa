package untils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class OutFile {

    public static void writeExcel(JTable data, String path) throws IOException {
        writeExcel(data, path, false);
    }

    public static void writeExcel(JTable data, String path, Boolean fileName) throws FileNotFoundException, IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();

        int rownum = 0;
        Cell cell;
        Row row;

        HSSFCellStyle style = createStyleForTitle(workbook);
        row = sheet.createRow(rownum);

        TableModel model = data.getModel();
        for (int i = 0; i < model.getColumnCount(); i++) {
            cell = row.createCell(i, CellType.STRING);
            cell.setCellValue(model.getColumnName(i));
            cell.setCellStyle(style);
        }

        for (int i = 0; i < model.getRowCount(); i++) {
            rownum++;
            row = sheet.createRow(rownum);
            for (int j = 0; j < model.getColumnCount(); j++) {
                cell = row.createCell(j, CellType.STRING);
                if (model.getValueAt(i, j) == null) {
                    cell.setCellValue("");
                } else {
                    cell.setCellValue(model.getValueAt(i, j).toString());
                }
                cell.setCellStyle(style);
            }
        }

        if (fileName) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy-MM-dd-HH-mm-ss");
            LocalDateTime now = LocalDateTime.now();
            path = path + dtf.format(now) + ".xls";
        }

        File file = new File(path);
        file.getParentFile().mkdirs();
        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
    }

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public static DefaultTableModel readExcel(String path) throws FileNotFoundException, IOException {
        FileInputStream inputStream = new FileInputStream(new File(path));

        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);

        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        DefaultTableModel defaultTableModel = null;
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if (row.getRowNum() == 0) {
                int hehe = 0;
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    hehe++;
                    Cell cell = cellIterator.next();
                }
                String header[] = new String[hehe];
                int i = 0;
                cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    String cellValue = dataFormatter.formatCellValue(cell);
                    header[i] = cellValue;
                    i++;
                }
                defaultTableModel = new DefaultTableModel(header, 0);
            } else {
                int hehe = 0;
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    hehe++;
                    Cell cell = cellIterator.next();
                }
                String header[] = new String[hehe];
                int i = 0;
                cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    String cellValue = dataFormatter.formatCellValue(cell);
                    header[i] = cellValue + "";
                    i++;
                }
                defaultTableModel.addRow(header);
            }
        }
        return defaultTableModel;
    }

    public static String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("").replace('đ', 'd').replace('Đ', 'D') + "";
    }

    public static File createFilePDF(String path) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy-MM-dd-HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        path = path + dtf.format(now) + ".pdf";
        File file = new File(path);
        file.getParentFile().mkdirs();
        return file;
    }
}
