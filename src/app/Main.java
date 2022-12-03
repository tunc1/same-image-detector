package app;

import java.io.IOException;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        if(args.length==0)
            throw new IllegalArgumentException("Missing Args");
        String directory=args[0];
        SameImageDetector sameImageDetector=new SameImageDetector();
        List<SameImage> list;
        if(args.length==2)
        {
            String directory2=args[1];
            list=sameImageDetector.getSameImagesInDirectories(directory,directory2);
        }
        else
            list=sameImageDetector.getSameImagesInSameDirectory(directory);
        for(SameImage sameImage: list)
            System.out.println(sameImage);
    }
}