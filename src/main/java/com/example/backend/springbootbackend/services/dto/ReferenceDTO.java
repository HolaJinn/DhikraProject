package com.example.backend.springbootbackend.services.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ReferenceDTO {
    MultipartFile image;
}
