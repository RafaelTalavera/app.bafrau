package com.axiomasoluciones.app.bafrau.insfrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaAuditingConfig {
    // Con esto Spring levanta el AuditingEntityListener automáticamente
}