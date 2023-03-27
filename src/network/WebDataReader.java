package src.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;

public class WebDataReader extends Observable {

    private String data;

    //  REQUIRES: a valid URL string.
    //  MODIFIES: this.data, this.changed
    //  EFFECTS: reads data from the given URL and sets it as the data for the WebDataReader instance.
    public void readData(String url) throws MalformedURLException, IOException {
        BufferedReader br = null;
        try {
            URL u = new URL(url);
            br = new BufferedReader(new InputStreamReader(u.openStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            data = sb.toString();
            setChanged();
            notifyObservers();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    // EFFECTS: returns the data string of the WebDataReader instance
    public String getData() {
        return data;
    }

}
