package com.axiomasoluciones.app.bafrau.domain.entities.utility;

import jakarta.persistence.*;

@Entity
@Table(name="styles-templates")
public class StyleTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String fontFamily;       // Tipo de fuente (Arial, Roboto, etc.)
    private String fontSize;         // Tamaño de fuente (ej: 14px, 1.2em)
    private String fontWeight;       // Grosor de fuente (normal, bold, 400, etc.)
    private String fontStyle;        // Estilo de fuente (normal, italic)
    private String color;            // Color del texto (ej: #000000, red)
    private String backgroundColor;  // Color de fondo del bloque o texto

    private String lineHeight;       // Altura de línea (espaciado entre líneas de texto)
    private String textAlign;        // Alineación del texto (left, center, right, justify)
    private String textDecoration;   // Decoración del texto (underline, line-through)

    private String marginTop;        // Espacio superior externo
    private String marginBottom;     // Espacio inferior externo
    private String marginLeft;       // Espacio izquierdo externo
    private String marginRight;      // Espacio derecho externo

    private String paddingTop;       // Espacio superior interno
    private String paddingBottom;    // Espacio inferior interno
    private String paddingLeft;      // Espacio izquierdo interno
    private String paddingRight;     // Espacio derecho interno

    private String border;           // Borde completo (ej: 1px solid black)
    private String borderRadius;     // Bordes redondeados (ej: 5px)

    public StyleTemplate() {
    }

    public StyleTemplate(Long id, String nombre, String fontFamily, String fontSize, String fontWeight, String fontStyle, String color, String backgroundColor, String lineHeight, String textAlign, String textDecoration, String marginTop, String marginBottom, String marginLeft, String marginRight, String paddingTop, String paddingBottom, String paddingLeft, String paddingRight, String border, String borderRadius) {
        this.id = id;
        this.nombre = nombre;
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
        this.fontWeight = fontWeight;
        this.fontStyle = fontStyle;
        this.color = color;
        this.backgroundColor = backgroundColor;
        this.lineHeight = lineHeight;
        this.textAlign = textAlign;
        this.textDecoration = textDecoration;
        this.marginTop = marginTop;
        this.marginBottom = marginBottom;
        this.marginLeft = marginLeft;
        this.marginRight = marginRight;
        this.paddingTop = paddingTop;
        this.paddingBottom = paddingBottom;
        this.paddingLeft = paddingLeft;
        this.paddingRight = paddingRight;
        this.border = border;
        this.borderRadius = borderRadius;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontWeight() {
        return fontWeight;
    }

    public void setFontWeight(String fontWeight) {
        this.fontWeight = fontWeight;
    }

    public String getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getLineHeight() {
        return lineHeight;
    }

    public void setLineHeight(String lineHeight) {
        this.lineHeight = lineHeight;
    }

    public String getTextAlign() {
        return textAlign;
    }

    public void setTextAlign(String textAlign) {
        this.textAlign = textAlign;
    }

    public String getTextDecoration() {
        return textDecoration;
    }

    public void setTextDecoration(String textDecoration) {
        this.textDecoration = textDecoration;
    }

    public String getMarginTop() {
        return marginTop;
    }

    public void setMarginTop(String marginTop) {
        this.marginTop = marginTop;
    }

    public String getMarginBottom() {
        return marginBottom;
    }

    public void setMarginBottom(String marginBottom) {
        this.marginBottom = marginBottom;
    }

    public String getMarginLeft() {
        return marginLeft;
    }

    public void setMarginLeft(String marginLeft) {
        this.marginLeft = marginLeft;
    }

    public String getMarginRight() {
        return marginRight;
    }

    public void setMarginRight(String marginRight) {
        this.marginRight = marginRight;
    }

    public String getPaddingTop() {
        return paddingTop;
    }

    public void setPaddingTop(String paddingTop) {
        this.paddingTop = paddingTop;
    }

    public String getPaddingBottom() {
        return paddingBottom;
    }

    public void setPaddingBottom(String paddingBottom) {
        this.paddingBottom = paddingBottom;
    }

    public String getPaddingLeft() {
        return paddingLeft;
    }

    public void setPaddingLeft(String paddingLeft) {
        this.paddingLeft = paddingLeft;
    }

    public String getPaddingRight() {
        return paddingRight;
    }

    public void setPaddingRight(String paddingRight) {
        this.paddingRight = paddingRight;
    }

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public String getBorderRadius() {
        return borderRadius;
    }

    public void setBorderRadius(String borderRadius) {
        this.borderRadius = borderRadius;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}