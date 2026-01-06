package com.cetnext.ecet.models;

import jakarta.persistence.*;

@Entity
@Table(name = "hero")
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String title;

    @Column(length = 1000)
    private String description;

    private String primaryButtonText;
    private String primaryButtonLink;
    private String secondaryButtonText;
    private String secondaryButtonLink;

    @Column(length = 500)
    private String imageUrl;

    private String imageAlt;
    private Boolean isActive = true;

    // Constructors
    public Hero() {
    }

    public Hero(String title, String description, String primaryButtonText, String primaryButtonLink,
            String secondaryButtonText, String secondaryButtonLink, String imageUrl, String imageAlt) {
        this.title = title;
        this.description = description;
        this.primaryButtonText = primaryButtonText;
        this.primaryButtonLink = primaryButtonLink;
        this.secondaryButtonText = secondaryButtonText;
        this.secondaryButtonLink = secondaryButtonLink;
        this.imageUrl = imageUrl;
        this.imageAlt = imageAlt;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPrimaryButtonText() {
        return primaryButtonText;
    }

    public void setPrimaryButtonText(String primaryButtonText) {
        this.primaryButtonText = primaryButtonText;
    }

    public String getPrimaryButtonLink() {
        return primaryButtonLink;
    }

    public void setPrimaryButtonLink(String primaryButtonLink) {
        this.primaryButtonLink = primaryButtonLink;
    }

    public String getSecondaryButtonText() {
        return secondaryButtonText;
    }

    public void setSecondaryButtonText(String secondaryButtonText) {
        this.secondaryButtonText = secondaryButtonText;
    }

    public String getSecondaryButtonLink() {
        return secondaryButtonLink;
    }

    public void setSecondaryButtonLink(String secondaryButtonLink) {
        this.secondaryButtonLink = secondaryButtonLink;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
