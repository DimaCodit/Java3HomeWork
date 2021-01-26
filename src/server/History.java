package server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class History {

    public static String loadHistory(Integer userId) {
        if (userId == null) {
            return "";
        }
        else {
            String msg = "";

            try(BufferedReader bufferedReader = new BufferedReader(new FileReader("history/" + userId + "_" + "history.txt"))) {

                List<String> msgs = new ArrayList<>();
                while ((msg = bufferedReader.readLine()) != null) {
                    msgs.add(msg);
                }
                if (msgs.size()>100) {
                    msgs = msgs.subList(msgs.size()-100, msgs.size()-1);
                }
                msg = "";
                for (String str : msgs) {
                    msg += str + System.lineSeparator();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return msg;
        }

    }
}