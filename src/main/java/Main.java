
import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {

        Gson gson = new Gson();

        Reading reading = new Reading();
        StudentsList studentsList = reading.read("exemplo.xls");



        String json = gson.toJson(studentsList);
        System.out.println(json);
    }

}

