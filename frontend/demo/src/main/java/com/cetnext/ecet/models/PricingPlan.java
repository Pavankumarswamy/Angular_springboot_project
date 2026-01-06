package com.cetnext.ecet.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class PricingPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String planName;

    private Double price;

    private String duration;

    @Column(length = 2000)
    private String features;

    private Boolean isPopular;

    private Boolean isActive;

    private String buttonText;

    private String buttonLink;

    // Constructors
    public PricingPlan() {
        super();
    }

    public PricingPlan(Integer id, String planName, Double price, String duration, String features,
            Boolean isPopular, Boolean isActive, String buttonText, String buttonLink) {
        super();
        this.id = id;
        this.planName = planName;
        this.price = price;
        this.duration = duration;
        this.features = features;
        this.isPopular = isPopular;
        this.isActive = isActive;
        this.buttonText = buttonText;
        this.buttonLink = buttonLink;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public Boolean getIsPopular() {
        return isPopular;
    }

    public void setIsPopular(Boolean isPopular) {
        this.isPopular = isPopular;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
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
}
