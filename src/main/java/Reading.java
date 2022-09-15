import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Reading {

    public StudentsList read (String filePath) {
        Workbook workbook;
        StudentsList studentsList = new StudentsList();

        try {
            workbook = Workbook.getWorkbook(this.getFileFromResource(filePath));
        }
        catch (Exception e) {
            return studentsList;
        }

        ArrayList students = new ArrayList();

        Sheet sheet = workbook.getSheet(0);
        int linhas = sheet.getRows();


        for (int i = 1; i < linhas; i++) {

            // Adaptar para um número variável de colunas
            String id = sheet.getCell(0, i).getContents();
            String name = sheet.getCell(1, i).getContents();
            String nickname = sheet.getCell(2, i).getContents();
            String laguages = sheet.getCell(3, i).getContents();
            String areasOfInterest = sheet.getCell(4, i).getContents();
            String dateOfBirth = sheet.getCell(5, i).getContents();

            if ((id + name + nickname + laguages + areasOfInterest + dateOfBirth).isEmpty()) {
                break;
            }

            Student s = new Student();
            int parseId;
            try {
                parseId = Integer.parseInt(id);
            }
            catch (NumberFormatException e) {
                parseId = 0;
//                System.out.println(e);
            }
            s.setId(parseId);
            // System.out.println(s.getId());

            s.setName(name);
            // System.out.println(s.getName());

            s.setNickname(nickname);
            // System.out.println(s.getNickname());

            s.setLanguages(laguages.split(","));
            // System.out.println(Arrays.toString(s.getLanguages()));

            s.setAreasOfInterest(areasOfInterest.split(","));
            //System.out.println(Arrays.toString(s.getAreasOfInterest()));

            String[] x = dateOfBirth.split("/");
            Collections.reverse(Arrays.asList(x));
            s.setDateOfBirth(String.join("-", x));
            //System.out.println(s.getDateOfBirth());

            students.add(s);

        }

        studentsList.setStudents(students);

        workbook.close();

        return studentsList;
    }

    private File getFileFromResource(String fileName) throws URISyntaxException {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {

            return new File(resource.toURI());
        }

    }
}
