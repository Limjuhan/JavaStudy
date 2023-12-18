package Mission;
import java.io.*;
public class prac_01 {
    public static void main(String[] args) {
        try {
            File file = new File("index22.html");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("<html><head>\n<meta charset=\"UTF-8\" />\n");
            writer.write("<style>\ntable { border-collapse: collapse; width: 100%; }\n");
            writer.write("th, td { border:solid 1px #000; }\n</style>\n</head>\n");

            writer.write("<body>\n<h1>자바 환경정보</h1>\n<table>\n");
            writer.write("<tr>\n<th>키</th>\n<th>값</th>\n</tr>\n");

            for (Object k : System.getProperties().keySet()) {
                String key = k.toString();
                String value = System.getProperty(key);

                writer.write("<tr>\n<td>" + key + "</td>\n<td>" + value + "</td>\n</tr>\n");
            }
            writer.write("\n</table>\n</body>\n</html>\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
