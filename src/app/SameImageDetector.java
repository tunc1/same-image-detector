package app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.awt.Color;

public class SameImageDetector
{
    public List<SameImage> getSameImagesInDirectories(String directory1Path,String directory2Path) throws IOException
    {
        List<SameImage> sameImages=new LinkedList<>();
        File directory1=new File(directory1Path);
        File directory2=new File(directory2Path);
        for(File file1:directory1.listFiles())
        {
            if(file1.isFile())
            {
                for(File file2:directory2.listFiles())
                {
                    if(file2.isFile())
                    {
                        if(equals(file1,file2))
                            sameImages.add(new SameImage(file1,file2));
                    }
                }
            }
        }
        return sameImages;
    }
    public List<SameImage> getSameImagesInSameDirectory(String directoryPath) throws IOException
    {
        List<SameImage> sameImages=new LinkedList<>();
        File directory1=new File(directoryPath);
        List<File> images=new ArrayList<>();
        Stream.of(directory1.listFiles()).filter(file->file.isFile()).forEach(images::add);
        for(int i=0;i<images.size();i++)
        {
            File file1=images.get(i);
            for(int j=i+1;j<images.size();j++)
            {
                File file2=images.get(j);
                if(equals(file1,file2))
                    sameImages.add(new SameImage(file1,file2));
            }
        }
        return sameImages;
    }
    private boolean equals(File imageFile1,File imageFile2) throws IOException
    {
        BufferedImage image1=ImageIO.read(imageFile1);
        BufferedImage image2=ImageIO.read(imageFile2);
        if(image1.getWidth()==image2.getWidth()&&image1.getHeight()==image2.getHeight())
        {
            for(int y=0;y<image1.getHeight();y++)
            {
                for(int x=0;x<image1.getWidth();x++)
                {
                    Color pixel1=new Color(image1.getRGB(x,y),true);
                    Color pixel2=new Color(image2.getRGB(x,y),true);
                    if(!pixel1.equals(pixel2))
                        return false;
                }
            }
            return true;
        }
        return false;
    }
}