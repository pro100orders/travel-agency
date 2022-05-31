package com.pro100user.travelagencybackend.service.impl;

import com.pro100user.travelagencybackend.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;

@Service
public class ImageServiceImpl implements ImageService {

    private final String filepath;

    public ImageServiceImpl() {
        try {
            filepath = ResourceUtils.getFile("classpath:").getPath() + "/static/files/";
            File directory = new File(filepath);
            if (!directory.exists()) {
                Files.createDirectories(directory.toPath());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String save(MultipartFile file, Long hotelId) {
        try {
            File image = new File(filepath + hotelId.toString() + file.getOriginalFilename());
            if (!image.exists()) {
                image.createNewFile();
            }
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(image));
            bos.write(file.getBytes());
            bos.flush();
            bos.close();
            return hotelId.toString() + file.getOriginalFilename();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public boolean update(String filename, MultipartFile file) {
        try {
            File avatar = new File(filepath + filename);
            if (!avatar.exists()) {
                avatar.createNewFile();
            }
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(avatar));
            bos.write(file.getBytes());
            bos.flush();
            bos.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public boolean delete(String filename) {
        File avatar = new File(filepath + filename);
        if (avatar.exists()) {
            return avatar.delete();
        }
        return false;
    }
}
