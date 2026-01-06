# Populate ALL Content for Certo Website

Write-Host "`n🔄 Populating ALL content from backend..." -ForegroundColor Cyan

$baseUrl = "http://localhost:8081/api/v1"

# Wait for server to be ready
Write-Host "`n⏳ Waiting for server to restart..." -ForegroundColor Yellow
Start-Sleep -Seconds 10

# ===== 1. HERO SECTION =====
Write-Host "`n🎯 Adding Hero Section..." -ForegroundColor Yellow

$hero = @{
    title = "Your mobile privacy is our mission"
    description = "Think your phone has been hacked? Our market-leading spyware detection for iPhone and Android has helped millions of people take back control of their digital lives."
    primaryButtonText = "Get Certo for iPhone →"
    primaryButtonLink = "iphone.html"
    secondaryButtonText = "Get Certo for Android"
    secondaryButtonLink = "android.html"
    imageUrl = "https://images.unsplash.com/photo-1556656793-08538906a9f8?w=500&h=600&fit=crop&q=80"
    imageAlt = "Certo Dashboard on iPhone"
    isActive = $true
}

Invoke-RestMethod -Uri "$baseUrl/content/hero" -Method POST -ContentType "application/json" -Body ($hero | ConvertTo-Json)
Write-Host "  ✓ Hero section added" -ForegroundColor Green

# ===== 2. MEDIA LOGOS (Featured In) =====
Write-Host "`n📰 Adding Media Logos..." -ForegroundColor Yellow

$logos = @(
    @{ name = "CNBC"; logoUrl = ""; link = "https://cnbc.com"; displayOrder = 1; isActive = $true },
    @{ name = "Forbes"; logoUrl = ""; link = "https://forbes.com"; displayOrder = 2; isActive = $true },
    @{ name = "ZDNet"; logoUrl = ""; link = "https://zdnet.com"; displayOrder = 3; isActive = $true },
    @{ name = "Wired"; logoUrl = ""; link = "https://wired.com"; displayOrder = 4; isActive = $true },
    @{ name = "Express"; logoUrl = ""; link = "https://express.co.uk"; displayOrder = 5; isActive = $true }
)

foreach ($logo in $logos) {
    Invoke-RestMethod -Uri "$baseUrl/content/media-logos" -Method POST -ContentType "application/json" -Body ($logo | ConvertTo-Json)
    Write-Host "  ✓ Added $($logo.name)" -ForegroundColor Green
}

# ===== 3. MISSION SECTION =====
Write-Host "`n🎯 Adding Mission Section..." -ForegroundColor Yellow

$mission = @{
    sectionType = "mission"
    title = "At Certo, mobile security is not an after-thought, it's what we do."
    description = "We've been protecting people's privacy for over a decade. Our expertise in mobile security is second to none, and we're committed to helping you stay safe in an increasingly connected world."
    buttonText = "Read our story →"
    buttonLink = "company.html"
    buttonStyle = "primary"
    imageUrl = "https://images.unsplash.com/photo-1573496359142-b8d87734a5a2?w=600&h=400&fit=crop&q=80"
    imageAlt = "Woman using smartphone"
    displayOrder = 1
    isActive = $true
}

Invoke-RestMethod -Uri "$baseUrl/content/sections" -Method POST -ContentType "application/json" -Body ($mission | ConvertTo-Json)
Write-Host "  ✓ Mission section added" -ForegroundColor Green

# ===== 4. CTA BLOCKS =====
Write-Host "`n📢 Adding CTA Blocks..." -ForegroundColor Yellow

$ctaBlocks = @(
    @{
        sectionType = "cta"
        title = "Read our story"
        description = ""
        buttonText = "About us"
        buttonLink = "company.html"
        buttonStyle = "secondary"
        backgroundColor = "yellow"
        displayOrder = 1
        isActive = $true
    },
    @{
        sectionType = "cta"
        title = "Help Center"
        description = ""
        buttonText = "Visit help center →"
        buttonLink = "help.html"
        buttonStyle = "primary"
        backgroundColor = "white"
        displayOrder = 2
        isActive = $true
    }
)

foreach ($cta in $ctaBlocks) {
    Invoke-RestMethod -Uri "$baseUrl/content/sections" -Method POST -ContentType "application/json" -Body ($cta | ConvertTo-Json)
    Write-Host "  ✓ Added CTA: $($cta.title)" -ForegroundColor Green
}

# ===== 5. BLOG POSTS / INSIGHTS =====
Write-Host "`n📝 Adding Blog Posts (Insights)..." -ForegroundColor Yellow

$posts = @(
    @{
        title = "Signs Your Ex is Spying On Your Phone"
        excerpt = "Learn the warning signs that someone may be monitoring your device without your knowledge."
        imageUrl = ""
        slug = "signs-ex-spying-phone"
        category = "Privacy"
        displayOrder = 1
        isActive = $true
    },
    @{
        title = "How to Remove a Hacker from Your iPhone"
        excerpt = "Step-by-step guide to removing malicious software and securing your iOS device."
        imageUrl = ""
        slug = "remove-hacker-iphone"
        category = "Security"
        displayOrder = 2
        isActive = $true
    },
    @{
        title = "Is Your Cell Phone Under Surveillance?"
        excerpt = "Discover the telltale signs that your phone might be compromised and what to do about it."
        imageUrl = ""
        slug = "cell-phone-surveillance"
        category = "Privacy"
        displayOrder = 3
        isActive = $true
    }
)

foreach ($post in $posts) {
    Invoke-RestMethod -Uri "$baseUrl/content/blog" -Method POST -ContentType "application/json" -Body ($post | ConvertTo-Json)
    Write-Host "  ✓ Added blog post: $($post.title)" -ForegroundColor Green
}

# ===== 6. FINAL CTA SECTION =====
Write-Host "`n🎯 Adding Final CTA Section..." -ForegroundColor Yellow

$finalCta = @{
    sectionType = "final-cta"
    title = "Is someone spying on your phone?"
    description = "Find out with Certo"
    buttonText = "Get Certo for iPhone →"
    buttonLink = "iphone.html"
    buttonStyle = "primary"
    displayOrder = 1
    isActive = $true
}

Invoke-RestMethod -Uri "$baseUrl/content/sections" -Method POST -ContentType "application/json" -Body ($finalCta | ConvertTo-Json)
Write-Host "  ✓ Final CTA section added" -ForegroundColor Green

Write-Host "`n✅ ALL CONTENT POPULATED SUCCESSFULLY!" -ForegroundColor Green
Write-Host "`n📊 Summary:" -ForegroundColor Cyan
Write-Host "  • Hero Section: 1 item" -ForegroundColor White
Write-Host "  • Media Logos: 5 items" -ForegroundColor White
Write-Host "  • Mission Section: 1 item" -ForegroundColor White
Write-Host "  • CTA Blocks: 2 items" -ForegroundColor White
Write-Host "  • Blog Posts: 3 items" -ForegroundColor White
Write-Host "  • Final CTA: 1 item" -ForegroundColor White
Write-Host "  • Testimonials: 3 items (already added)" -ForegroundColor White
Write-Host "  • Features: 6 items (already added)" -ForegroundColor White
Write-Host "`n🌐 Refresh http://localhost:8081/ to see fully dynamic content!`n" -ForegroundColor Cyan
