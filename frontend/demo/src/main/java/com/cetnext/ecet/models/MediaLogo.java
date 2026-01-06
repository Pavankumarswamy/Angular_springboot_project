package com.cetnext.ecet.models;

import jakarta.persistence.*;

@Entity
@Table(name = "media_logo")
public class MediaLogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 500)
    private String logoUrl;

    private String link;
    private Integer displayOrder = 0;
    private Boolean isActive = true;

    // Constructors
    public MediaLogo() {
    }

    public MediaLogo(String name, String logoUrl, String link, Integer displayOrder) {
        this.name = name;
        this.logoUrl = logoUrl;
        this.link = link;
        this.displayOrder = displayOrder;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
