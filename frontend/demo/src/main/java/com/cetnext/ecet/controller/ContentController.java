package com.cetnext.ecet.controller;

import com.cetnext.ecet.models.*;
import com.cetnext.ecet.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/content")
@CrossOrigin(origins = "*")
public class ContentController {

    @Autowired
    private HeroRepository heroRepository;

    @Autowired
    private ContentSectionRepository contentSectionRepository;

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private MediaLogoRepository mediaLogoRepository;

    // ===== HERO ENDPOINTS =====

    @GetMapping("/hero")
    public ResponseEntity<?> getActiveHero() {
        return heroRepository.findFirstByIsActiveTrue()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/hero")
    public ResponseEntity<String> addHero(@RequestBody Hero hero) {
        heroRepository.save(hero);
        return ResponseEntity.ok("Hero added successfully");
    }

    @PutMapping("/hero/{id}")
    public ResponseEntity<String> updateHero(@PathVariable Long id, @RequestBody Hero hero) {
        return heroRepository.findById(id)
                .map(existing -> {
                    hero.setId(id);
                    heroRepository.save(hero);
                    return ResponseEntity.ok("Hero updated successfully");
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // ===== CONTENT SECTION ENDPOINTS =====

    @GetMapping("/sections/{type}")
    public ResponseEntity<List<ContentSection>> getSectionsByType(@PathVariable String type) {
        List<ContentSection> sections = contentSectionRepository
                .findBySectionTypeAndIsActiveTrueOrderByDisplayOrderAsc(type);
        return ResponseEntity.ok(sections);
    }

    @GetMapping("/sections")
    public ResponseEntity<List<ContentSection>> getAllActiveSections() {
        List<ContentSection> sections = contentSectionRepository
                .findByIsActiveTrueOrderByDisplayOrderAsc();
        return ResponseEntity.ok(sections);
    }

    @PostMapping("/sections")
    public ResponseEntity<String> addSection(@RequestBody ContentSection section) {
        contentSectionRepository.save(section);
        return ResponseEntity.ok("Section added successfully");
    }

    @PutMapping("/sections/{id}")
    public ResponseEntity<String> updateSection(@PathVariable Long id, @RequestBody ContentSection section) {
        return contentSectionRepository.findById(id)
                .map(existing -> {
                    section.setId(id);
                    contentSectionRepository.save(section);
                    return ResponseEntity.ok("Section updated successfully");
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // ===== BLOG POST ENDPOINTS =====

    @GetMapping("/blog/latest")
    public ResponseEntity<List<BlogPost>> getLatestBlogPosts(@RequestParam(defaultValue = "3") int limit) {
        List<BlogPost> posts = blogPostRepository.findByIsActiveTrueOrderByPublishedDateDesc();
        return ResponseEntity.ok(posts.stream().limit(limit).toList());
    }

    @GetMapping("/blog/all")
    public ResponseEntity<List<BlogPost>> getAllBlogPosts() {
        List<BlogPost> posts = blogPostRepository.findByIsActiveTrueOrderByDisplayOrderAsc();
        return ResponseEntity.ok(posts);
    }

    @PostMapping("/blog")
    public ResponseEntity<String> addBlogPost(@RequestBody BlogPost post) {
        blogPostRepository.save(post);
        return ResponseEntity.ok("Blog post added successfully");
    }

    @PutMapping("/blog/{id}")
    public ResponseEntity<String> updateBlogPost(@PathVariable Long id, @RequestBody BlogPost post) {
        return blogPostRepository.findById(id)
                .map(existing -> {
                    post.setId(id);
                    blogPostRepository.save(post);
                    return ResponseEntity.ok("Blog post updated successfully");
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // ===== MEDIA LOGO ENDPOINTS =====

    @GetMapping("/media-logos")
    public ResponseEntity<List<MediaLogo>> getActiveMediaLogos() {
        List<MediaLogo> logos = mediaLogoRepository.findByIsActiveTrueOrderByDisplayOrderAsc();
        return ResponseEntity.ok(logos);
    }

    @PostMapping("/media-logos")
    public ResponseEntity<String> addMediaLogo(@RequestBody MediaLogo logo) {
        mediaLogoRepository.save(logo);
        return ResponseEntity.ok("Media logo added successfully");
    }

    @PutMapping("/media-logos/{id}")
    public ResponseEntity<String> updateMediaLogo(@PathVariable Long id, @RequestBody MediaLogo logo) {
        return mediaLogoRepository.findById(id)
                .map(existing -> {
                    logo.setId(id);
                    mediaLogoRepository.save(logo);
                    return ResponseEntity.ok("Media logo updated successfully");
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/media-logos/{id}")
    public ResponseEntity<String> deleteMediaLogo(@PathVariable Long id) {
        return mediaLogoRepository.findById(id)
                .map(logo -> {
                    mediaLogoRepository.delete(logo);
                    return ResponseEntity.ok("Media logo deleted successfully");
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // ===== PAGE CONTENT ENDPOINTS =====

    @Autowired
    private PageContentRepository pageContentRepository;

    @GetMapping("/pages/{pageName}")
    public ResponseEntity<List<PageContent>> getPageContent(@PathVariable String pageName) {
        List<PageContent> content = pageContentRepository
                .findByPageNameAndIsActiveTrueOrderByDisplayOrderAsc(pageName);
        return ResponseEntity.ok(content);
    }

    @GetMapping("/pages/{pageName}/{sectionType}")
    public ResponseEntity<List<PageContent>> getPageContentBySection(
            @PathVariable String pageName,
            @PathVariable String sectionType) {
        List<PageContent> content = pageContentRepository
                .findByPageNameAndSectionTypeAndIsActiveTrueOrderByDisplayOrderAsc(pageName, sectionType);
        return ResponseEntity.ok(content);
    }

    @PostMapping("/pages")
    public ResponseEntity<String> addPageContent(@RequestBody PageContent content) {
        pageContentRepository.save(content);
        return ResponseEntity.ok("Page content added successfully");
    }

    @PutMapping("/pages/{id}")
    public ResponseEntity<String> updatePageContent(@PathVariable Long id, @RequestBody PageContent content) {
        return pageContentRepository.findById(id)
                .map(existing -> {
                    content.setId(id);
                    pageContentRepository.save(content);
                    return ResponseEntity.ok("Page content updated successfully");
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
