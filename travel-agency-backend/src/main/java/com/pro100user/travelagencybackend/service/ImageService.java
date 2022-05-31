package com.pro100user.travelagencybackend.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {

    String save(MultipartFile file, Long hotelId);

    boolean update(String filepath, MultipartFile file);

    boolean delete(String filepath);
}
