package app;

import java.io.File;

public record SameImage(File imageFile1,File imageFile2)
{
    public String toString()
    {
        return imageFile1.toString()+" - "+imageFile2.toString();
    }
}