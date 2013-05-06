/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mmstest;

import java.util.Hashtable;

/**lr
 *
 * @author Alkimake
 */
public class FileTypesToSend {

    public String ContentType;
    static Hashtable<String, FileType> types = new Hashtable<String, FileType>();

    public FileTypesToSend(String fileext) {
        if (types.isEmpty()) {
            createDictionary();
        }
        if (types.containsKey(fileext)) {
            switch (types.get(fileext)) {
                case VCS:
                    ContentType = "text/x-vCalendar";
                case MPG:
                    ContentType = "video/mpg";
                    break;
                case GIF:
                    ContentType = "image/gif";
                    break;
                case TXT:
                    ContentType = "text/plain; charset=UTF-8;";
                    break;
                case AMR:
                    ContentType = "audio/amr";
                    break;
                case AVI:
                    ContentType = "video/avi";
                    break;
                case MPEG:
                    ContentType = "video/mpg";
                    break;
                case MP3:
                    ContentType = "audio/mp3";
                    break;
                case x3GP:
                    ContentType = "video/3gp";
                    break;
                case AAC:
                    ContentType = "audio/aac";
                    break;
                case JPG:
                    ContentType = "";
                    break;
                case BMP:
                    ContentType = "image/x-bmp";
                    break;
                default :
                    ContentType = "";
                    break;
            }
        } else {
            ContentType = "";
        }
    }

    private void createDictionary() {
        types.put("mpg", FileType.MPG);
        types.put("gif", FileType.GIF);
        types.put("amr", FileType.AMR);
        types.put("avi", FileType.AVI);
        types.put("mpeg", FileType.MPEG);
        types.put("mp3", FileType.MP3);
        types.put("3gp", FileType.x3GP);
        types.put("txt", FileType.TXT);
        types.put("aac", FileType.AAC);
        types.put("jpg", FileType.JPG);
        types.put("jpeg", FileType.JPG);
        types.put("bmp", FileType.BMP);
    }
}
