package org.enset.app.beneficiaireservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "beneficiaire.params")
public record BeneficiaireConfigParams(int x , int y) {
}
