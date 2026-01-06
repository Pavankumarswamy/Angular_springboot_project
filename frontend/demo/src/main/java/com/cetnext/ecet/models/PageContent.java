package com.cetnext.ecet.models;

import jakarta.persistence.*;

@Entity
@Table(name = "page_content")
public class PageContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pageName; // "iphone", "android", "help", "company"
    private String sectionType; // "header", "intro", "feature", "timeline", etc.

    @Column(length = 500)
    private String title;

    @Column(length = 2000)
    private String description;

    @Column(length = 500)
    private String icon; // emoji or icon class

    private String year; // for timeline items
    private Integer displayOrder = 0;
    private Boolean isActive = true;

    // Constructors
    public PageContent() {
    }

    public PageContent(String pageName, String sectionType, String title, String description, String icon,
            Integer displayOrder) {
        this.pageName = pageName;
        this.sectionType = sectionType;
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.displayOrder = displayOrder;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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
