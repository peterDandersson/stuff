package com.company;

import com.sun.deploy.ref.Helpers;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipFile;

/**
 * Created by Laptop on 2017-01-31.
 */
public class RW {
    public RW() {
        char[] buffer = new char[8];
        int lenght;

        try (BufferedReader reader = new BufferedReader(new FileReader("myFile.txt"))) {
            int intVal;
            while ((intVal = reader.read()) >= 0){
                char charVal = (char) intVal;
                System.out.print(charVal);
                }
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
        }

        String[] data = {"Line1","Line2","Line3","Line4","Line5"};

        writeData((new String[] {"Hej","din","gamling"}));
        readData();
        readDataNIO();
        try {
            readAll();
        } catch (Exception e){

        }

        try (FileSystem zipfs = openZip(Paths.get("MyZipFile.zip"))){
            copyToZip(zipfs);
            writeToFileInZip1(zipfs,data);
            writeToFileInZip2(zipfs,data);
        } catch (Exception e){
            System.out.println(e.getClass().getName() + e.getMessage());
        }
        try {
            Path p = Paths.get("theFile.txt");
            System.out.println("size: " + Files.size(p));
        }catch (Exception e){
            System.out.println(e.getClass().getName() + e.getMessage());
        }

    }

    private static FileSystem openZip(Path zipPath) throws IOException, URISyntaxException {
        Map<String, String> providerProps = new HashMap<>();
        providerProps.put("create","true");

        URI zipUri = new URI("jar:file", zipPath.toUri().getPath(), null);
        FileSystem zipFs = FileSystems.newFileSystem(zipUri,providerProps);

        return zipFs;
    }

    private static void copyToZip(FileSystem zipFs) throws IOException {
        Path sourceFile = Paths.get("myFile.txt");
        Path destFile = zipFs.getPath("/myFileCopied.txt");

        Files.copy(sourceFile, destFile, StandardCopyOption.REPLACE_EXISTING);
    }

    private static void writeToFileInZip1(FileSystem zipFs, String[] data) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(zipFs.getPath("/newFile1.txt"))){
            for (String s: data) {
                writer.write(s);
                writer.newLine();
            }
        }
    }

    private static void writeToFileInZip2(FileSystem zipFs, String[] data) throws IOException {
        Files.write(zipFs.getPath("/newFile2.txt"), Arrays.asList(data), Charset.defaultCharset(), StandardOpenOption.CREATE);
    }

    void writeData(String[] data){
        try (BufferedWriter bf = new BufferedWriter(new FileWriter("theFile.txt"))){
            for (String s: data) {
                bf.write(s);
                bf.newLine();
            }
        } catch (IOException e){
            e.getMessage();
        }
    }

    void readData(){

        try (BufferedReader br = new BufferedReader(new FileReader("theFile.txt"))){
            String inValue;
            while ((inValue = br.readLine()) != null){
                System.out.println(inValue);
            }
        } catch (Exception e){
            e.getMessage();
        }
    }

    void readDataNIO(){
        try (BufferedReader br = Files.newBufferedReader(Paths.get("myFile.txt"))){
            String inValue;
            while ((inValue = br.readLine()) != null){
                System.out.println(inValue);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    void readAll() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("theFile.txt"));
        for (String line: lines){
            System.out.println(line);
        }
    }
}
