package com.example.reforaccion;

public class user {

    private String ingre_nombre, ingre_correo, ingre_contra;

    public user(String ingre_nombre,String ingre_correo, String ingre_contra) {
        this.ingre_nombre = ingre_nombre;

        this.ingre_correo = ingre_correo;
        this.ingre_contra = ingre_contra;
    }

    public String getIngre_nombre() {
        return ingre_nombre;
    }

    public void setIngre_nombre(String ingre_nombre) {
        this.ingre_nombre = ingre_nombre;
    }
    public String getIngre_correo() {
        return ingre_correo;
    }

    public void setIngre_correo(String ingre_correo) {
        this.ingre_correo = ingre_correo;
    }

    public String getIngre_contra() {
        return ingre_contra;
    }

    public void setIngre_contra(String ingre_contra) {
        this.ingre_contra = ingre_contra;
    }
}
