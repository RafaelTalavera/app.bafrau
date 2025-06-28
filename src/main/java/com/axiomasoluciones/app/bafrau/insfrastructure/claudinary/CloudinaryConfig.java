package com.axiomasoluciones.app.bafrau.insfrastructure.claudinary;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "djegexxka");
        config.put("api_key", "128372763782288");
        config.put("api_secret", "FnJh1WtprxFg_0CPUJBi-stsdx8");
        return new Cloudinary(config);
    }
}