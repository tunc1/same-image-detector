package app;

import java.io.File;

public class SameImage
{
    private final File imageFile1,imageFile2;
    public SameImage(File imageFile1,File imageFile2)
    {
        this.imageFile1=imageFile1;
        this.imageFile2=imageFile2;
    }
    public File getImageFile1()
    {
        return imageFile1;
    }
    public File getImageFile2()
    {
        return imageFile2;
    }
}