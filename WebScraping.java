import java.net.*;
import java.io.*;

import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class WebScraping {

    public static void main(String[] args) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;

        try {
            /*url = new URL("https://weather.yahoo.com/");
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                if(line.contains("temperature")) {
                    System.out.println(line);
                }
            }*/
            Document doc;
            doc = Jsoup.connect("http://weather.yahoo.com/").get();

        	// get page title
        	String title = doc.title();
        	System.out.println("title : " + title);

        	// get all links
        	Elements links = doc.select("a[href]");
        	for (Element link : links) {

        		// get the value from href attribute
        		System.out.println("\nlink : " + link.attr("href"));
        		System.out.println("text : " + link.text());

        	}
        } catch (MalformedURLException mue) {
             mue.printStackTrace();
        } catch (IOException ioe) {
             ioe.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                // exception
            }
        }
    }

}
