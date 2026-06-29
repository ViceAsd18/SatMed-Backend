package com.satmed.alergias.models.dto;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VersionInfo {
    private String name;
    private String version;
}
=======
public record VersionInfo(
    String nombre,
    String version
) {}
>>>>>>> desarrollo
