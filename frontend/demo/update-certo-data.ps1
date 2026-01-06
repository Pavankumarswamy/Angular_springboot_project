# Certo Data Update Script

Write-Host "`n🔄 Updating backend data for Certo..." -ForegroundColor Cyan

# Update Testimonials with Certo-specific reviews
Write-Host "`n📝 Updating Testimonials..." -ForegroundColor Yellow

$testimonials = @(
    @{
        studentName = "colinandmandy94"
        studentImage = "https://randomuser.me/api/portraits/men/32.jpg"
        designation = "Verified User"
        review = "Certo found spyware on my phone that I had no idea was there. Easy to use and gave me peace of mind."
        rating = 5
        isApproved = $true
        examYear = "2024"
    },
    @{
        studentName = "Jennifer Black"
        studentImage = "https://randomuser.me/api/portraits/women/44.jpg"
        designation = "iPhone User"
        review = "Finally feel safe using my phone again. Certo detected tracking apps I didn't know existed. Highly recommend!"
        rating = 5
        isApproved = $true
        examYear = "2024"
    },
    @{
        studentName = "Phillip Colligan"
        studentImage = "https://randomuser.me/api/portraits/men/67.jpg"
        designation = "Android User"
        review = "Best investment for mobile security. Found a keylogger and removed it safely. The app is incredibly thorough."
        rating = 5
        isApproved = $true
        examYear = "2024"
    }
)

# Delete old testimonials
$oldTestimonials = Invoke-RestMethod -Uri "http://localhost:8081/api/v1/testimonials/all"
foreach ($t in $oldTestimonials) {
    Invoke-RestMethod -Uri "http://localhost:8081/api/v1/testimonials/delete/$($t.id)" -Method DELETE
}

# Add new testimonials
foreach ($t in $testimonials) {
    $body = $t | ConvertTo-Json
    Invoke-RestMethod -Uri "http://localhost:8081/api/v1/testimonials/add" -Method POST -ContentType "application/json" -Body $body
    Write-Host "  ✓ Added testimonial from $($t.studentName)" -ForegroundColor Green
}

# Update Pricing Plans
Write-Host "`n💰 Updating Pricing Plans..." -ForegroundColor Yellow

$pricingPlans = @(
    @{
        planName = "iPhone Protection"
        price = 4.99
        duration = "per month"
        features = "Spyware detection,Keylogger scanning,Tracking app alerts,OS integrity check,Threat removal guide,24/7 support"
        isPopular = $false
        isActive = $true
        buttonText = "Get for iPhone"
        buttonLink = "/checkout/iphone"
    },
    @{
        planName = "Android Protection"
        price = 4.99
        duration = "per month"
        features = "Complete spyware scan,Malware detection,App permission audit,Network monitoring,Threat removal,Priority support"
        isPopular = $true
        isActive = $true
        buttonText = "Get for Android"
        buttonLink = "/checkout/android"
    },
    @{
        planName = "Family Plan"
        price = 9.99
        duration = "per month"
        features = "Up to 5 devices,iPhone and Android,All security features,Family dashboard,Parental controls,Premium support"
        isPopular = $false
        isActive = $true
        buttonText = "Protect Family"
        buttonLink = "/checkout/family"
    }
)

# Delete old pricing plans
$oldPlans = Invoke-RestMethod -Uri "http://localhost:8081/api/v1/pricing/all"
foreach ($p in $oldPlans) {
    Invoke-RestMethod -Uri "http://localhost:8081/api/v1/pricing/delete/$($p.id)" -Method DELETE
}

# Add new pricing plans
foreach ($p in $pricingPlans) {
    $body = $p | ConvertTo-Json
    Invoke-RestMethod -Uri "http://localhost:8081/api/v1/pricing/add" -Method POST -ContentType "application/json" -Body $body
    Write-Host "  ✓ Added $($p.planName)" -ForegroundColor Green
}

# Update FAQs
Write-Host "`n❓ Updating FAQs..." -ForegroundColor Yellow

$faqs = @(
    @{
        question = "What is Certo?"
        answer = "Certo is a mobile security application that helps detect and remove spyware, malware, and other threats from your iPhone or Android device. We provide comprehensive protection for your mobile privacy."
        category = "General"
        displayOrder = 1
        isActive = $true
    },
    @{
        question = "How does Certo detect spyware?"
        answer = "Certo uses advanced scanning technology to analyze your device for suspicious apps, unusual permissions, network activity, and signs of tampering. Our algorithms can detect even hidden spyware and tracking software."
        category = "Features"
        displayOrder = 2
        isActive = $true
    },
    @{
        question = "Is Certo safe to use?"
        answer = "Yes, Certo is completely safe. We don't collect your personal data, and our app only scans for threats without accessing your private information. Thousands of users trust Certo to protect their mobile privacy."
        category = "Safety"
        displayOrder = 3
        isActive = $true
    },
    @{
        question = "Can Certo remove spyware automatically?"
        answer = "Certo will detect threats and provide you with clear, step-by-step instructions on how to safely remove them. For some threats, we can guide you through the removal process to ensure your device is clean."
        category = "Features"
        displayOrder = 4
        isActive = $true
    }
)

# Delete old FAQs
$oldFaqs = Invoke-RestMethod -Uri "http://localhost:8081/api/v1/faq/all"
foreach ($f in $oldFaqs) {
    Invoke-RestMethod -Uri "http://localhost:8081/api/v1/faq/delete/$($f.id)" -Method DELETE
}

# Add new FAQs
foreach ($f in $faqs) {
    $body = $f | ConvertTo-Json
    Invoke-RestMethod -Uri "http://localhost:8081/api/v1/faq/add" -Method POST -ContentType "application/json" -Body $body
    Write-Host "  ✓ Added FAQ: $($f.question)" -ForegroundColor Green
}

Write-Host "`n✅ All Certo data updated successfully!" -ForegroundColor Green
Write-Host "`n🌐 Refresh http://localhost:8081/ to see the changes`n" -ForegroundColor Cyan
