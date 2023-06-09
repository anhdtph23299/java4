package utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author sktfk
 */
public class ImageHelper {
    public static Image resige(Image originalImage,int width,int height){
        Image resultingImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return resultingImage;
    }
    public static byte[] toByteArray(Image img,String type) throws IOException{
        BufferedImage bimage = new BufferedImage(img.getWidth(null),img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bimage.createGraphics();
        g.drawImage(img, 0, 0,null);
        g.dispose();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bimage, type, baos);
        byte[] imageInbyte = baos.toByteArray();
        return imageInbyte;
    }
    public static Image createFromByteArray(byte []data,String type) throws IOException{
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        BufferedImage bImage = ImageIO.read(bis);
        Image img = bImage.getScaledInstance(bImage.getWidth(), bImage.getHeight(), Image.SCALE_SMOOTH);
        return img;
    }
    public static ImageIcon getImageIcon(byte []anh,JLabel lbl) throws IOException{
        Image image = ImageHelper.createFromByteArray(anh, "png");
        return new ImageIcon(ImageHelper.resige(image, lbl.getWidth(), lbl.getHeight()));
    }
}

