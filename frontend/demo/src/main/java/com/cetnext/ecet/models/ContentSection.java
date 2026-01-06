package com.cetnext.ecet.models;

import jakarta.persistence.*;

@Entity
@Table(name = "content_section")
public class ContentSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sectionType; // "mission", "cta", "final-cta"

    @Column(length = 500)
    private String title;

    @Column(length = 2000)
    private String description;

    private String buttonText;
    private String buttonLink;
    private String buttonStyle; // "primary", "secondary"

    @Column(length = 500)
    private String imageUrl;

    private String imageAlt;
    private String backgroundColor; // For CTA blocks
    private Integer displayOrder = 0;
    private Boolean isActive = true;

    // Constructors
    public ContentSection() {
    }

    public ContentSection(String sectionType, String title, String description, String buttonText,
            String buttonLink, String buttonStyle, String imageUrl, String backgroundColor) {
        this.sectionType = sectionType;
        this.title = title;
        this.description = description;
        this.buttonText = buttonText;
        this.buttonLink = buttonLink;
        this.buttonStyle = buttonStyle;
        this.imageUrl = imageUrl;
        this.backgroundColor = backgroundColor;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSectionType() {
        return sectionType;
    }

    public void setSectionType(String sectionType) {
        this.sectionType = sectionType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getButtonLink() {
        return buttonLink;
    }

    public void setButtonLink(String buttonLink) {
        this.buttonLink = buttonLink;
    }

    public String getButtonStyle() {
        return buttonStyle;
    }

    public void setButtonStyle(String buttonStyle) {
        this.buttonStyle = buttonStyle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageAlt() {
        return imageAlt;
    }

    public void setImageAlt(String imageAlt) {
        this.imageAlt = imageAlt;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
