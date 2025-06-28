package com.axiomasoluciones.app.bafrau.insfrastructure.claudinary;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {

    private final Cloudinary cloudinary;

    @Autowired
    public CloudinaryServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public Map<String, String> upload(MultipartFile mpf) throws IOException {
        String originalFilename = mpf.getOriginalFilename();
        String filename = Paths.get(originalFilename).getFileName().toString();

        Map<String, Object> uploadParams = ObjectUtils.asMap(
                "resource_type", "raw",
                "public_id", "ficha_tecnica/" + filename
        );

        return cloudinary.uploader().upload(mpf.getBytes(), uploadParams);
    }

    @Override
    public Map<String, String> delete(String publicId) throws IOException {
        return cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
    }
}