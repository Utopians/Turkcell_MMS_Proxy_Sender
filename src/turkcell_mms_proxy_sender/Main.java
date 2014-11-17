package turkcell_mms_proxy_sender;

import com.turkcell.soapmmsproxy.mm7.SubmitReqBindingStub;
import com.turkcell.soapmmsproxy.mm7.SubmitReqServiceLocator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.axis.attachments.AttachmentPart;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/*
 * @author Recep Cinet
 */

public class Main {
    public static String getCharacterDataFromElement(Element e) {
    Node child = e.getFirstChild();
    if (child instanceof CharacterData) {
      CharacterData cd = (CharacterData) child;
      return cd.getData();
    }
    return "";
  }

    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("Parametresiz çağırmayın.");
            return;
        }

        String hata="";
        try {
            //TODO: parametre yoksa hata veriyor!
            String icerik = args[1];
            SubmitReqServiceLocator locator = new SubmitReqServiceLocator();
            locator.setSubmitReqPortEndpointAddress("http://stargate.turkcell.com.tr/Mmsgroup/services/SubmitReq");
            SubmitReqBindingStub port = (SubmitReqBindingStub) locator.getSubmitReqPort();
            File dir = new File(icerik); //windows ise  + "//" ekle;
            AttachmentPart part;
            File[] files = dir.listFiles();
            String smilpath = icerik + "smil.smil";
            part = new AttachmentPart(new DataHandler(
                    new FileDataSource(new File(smilpath))));
            part.addMimeHeader("Content-Disposition",
                    "attachment; filename=smil.smil");
            part.setContentType("application/smil;");
            port.addAttachment(part);
            if (files == null) {
                hata = "-999|Klasor bulunamadi";
                //System.out.println("Klasör bulunamadı!");
            } else {
                for (File file : files) {
                    String filename = file.getName();
                    int xmldenfarkli = filename.indexOf(".xml");
                    if (filename.equals("Thumbs.db") || filename.equals(".DS_Store") || filename.equals("smil.smil") || xmldenfarkli>-1) {     // xml adi args[0]
                        // yapma bisi
                    } else {
                        String fileext = filename.substring(filename.lastIndexOf(".") + 1);
                        DataHandler dh = new DataHandler(new FileDataSource(new File(file.getPath())));
                        FileTypesToSend filetype = new FileTypesToSend(fileext);
                        part = new AttachmentPart(dh);
                        part.addMimeHeader("Content-Disposition",
                                "attachment; filename=" + filename);
                        if (fileext.equalsIgnoreCase("txt")) {
                            String str = new String(part.getContent().toString().getBytes(), "UTF-8");
                            part.setContent(str, filetype.ContentType);
                        }
                        // if (!filetype.ContentType.isEmpty()) {
                        part.setContentType(filetype.ContentType);
                        // }
                        port.addAttachment(part);
                    }
                }
            }
            String xdoc = "";
            try {
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                InputStream inputStream = new FileInputStream(new File(icerik + args[0])); // xml adi
                org.w3c.dom.Document doc = documentBuilderFactory.newDocumentBuilder().parse(inputStream);
                StringWriter stw = new StringWriter();
                Transformer serializer = TransformerFactory.newInstance().newTransformer();
                serializer.transform(new DOMSource(doc), new StreamResult(stw));
                xdoc = xdoc + stw.toString();
            } catch (IOException e) {
                if (hata!=""){
                System.out.println(hata);
                System.exit(0);
                }
                if (hata==""){
                System.out.println("-900|HATA!");
                }
            }
            String response = port.submitReq(xdoc.toString());
            int bir1 = response.indexOf("<StatusCode>") + 12;
            int bir2 = response.indexOf("</StatusCode>");
            int iki1 = response.indexOf("<StatusText>") + 12;
            int iki2 = response.indexOf("</StatusText>");  
             String xmlRecords = response;
    DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    InputSource is = new InputSource();
    is.setCharacterStream(new StringReader(xmlRecords));
    Document doc = db.parse(is);
    NodeList nodes = doc.getElementsByTagName("Response");
    int uzunluk=nodes.getLength();
    int nerden=0;
    String cikis;
    if (uzunluk==0)  {
    System.out.println("NOK," + response.substring(bir1, bir2) + "|" + response.substring(iki1, iki2));
    }
    else
    {
    for (int i = nerden; i < uzunluk; i++) {
      Element element = (Element) nodes.item(i);
      cikis="";
      NodeList name1 = element.getElementsByTagName("Recepient");
      Element line = (Element) name1.item(0);
      cikis+=getCharacterDataFromElement(line) + "|";
      NodeList name2 = element.getElementsByTagName("StatusCode");
      line = (Element) name2.item(0);
      //System.out.println("StatusCode: " + getCharacterDataFromElement(line));
      cikis+=getCharacterDataFromElement(line) + "|";
      NodeList title = element.getElementsByTagName("StatusText");
      line = (Element) title.item(0);
      //System.out.println("StatusText: " + getCharacterDataFromElement(line));
      cikis+=getCharacterDataFromElement(line);
      System.out.println(cikis);
    }
    }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
