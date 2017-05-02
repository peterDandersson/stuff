package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Laptop on 2017-02-01.
 */
public class Splitter {
    private int numberOfFragments;
    private Path pathToFile;
    private boolean zip;

    public Splitter(int numberOfFragments, Path pathToFile, boolean zip) {
        this.numberOfFragments = numberOfFragments;
        this.pathToFile = pathToFile;
        this.zip = zip;
    }

    private void split() throws IOException {
        long fragmentSize = (Files.size(pathToFile) / numberOfFragments) + 1;
        ByteBuffer buffer = ByteBuffer.allocate(Math.toIntExact(fragmentSize));
        RandomAccessFile aFile = new RandomAccessFile(String.valueOf(pathToFile.getFileName()),"rw");
        FileChannel inChannel = aFile.getChannel();

        int bytesRead = inChannel.read(buffer);

        while (bytesRead != 0){
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.println((char) buffer.get());
            }
            buffer.clear();
            bytesRead = inChannel.read(buffer);
        }
        aFile.close();
    }
}
