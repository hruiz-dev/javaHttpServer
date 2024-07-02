import java.io.File;

public class FileLoader {

    private static final String FILEPATH = "./public";

    public static File getRecurse(ClientData data) {
        System.out.println(data.getUrl());
        String path = data.getUrl();

        if (path.equals("/")) {
            path = FILEPATH + "/index.html";
        }
        File file =  new File(path);

        System.out.println(path);
        if (!file.exists()) {
            return new File(FILEPATH + "/404.html");
        }

        return file;
    }
}
