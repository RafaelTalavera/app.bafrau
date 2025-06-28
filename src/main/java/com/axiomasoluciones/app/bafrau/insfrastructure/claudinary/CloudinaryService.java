package com.axiomasoluciones.app.bafrau.insfrastructure.claudinary;

import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Map;

public interface CloudinaryService {

    Map<String, String> upload(MultipartFile mpf) throws IOException;

    Map<String, String> delete(String publicId) throws IOException;
}
