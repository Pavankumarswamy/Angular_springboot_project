# Quick API Test Commands

## 🚀 Test All Endpoints Quickly

Copy and paste these commands in PowerShell or use in Postman.

---

## 1️⃣ Features

### Add Feature
```powershell
curl -X POST http://localhost:8081/api/v1/features/add `
  -H "Content-Type: application/json" `
  -d '{\"title\":\"Expert Faculty\",\"description\":\"Learn from experienced teachers\",\"iconUrl\":\"https://example.com/icon.png\",\"isActive\":true,\"displayOrder\":1}'
```

### Get Active Features
```powershell
curl http://localhost:8081/api/v1/features/active
```

---

## 2️⃣ Testimonials

### Add Testimonial
```powershell
curl -X POST http://localhost:8081/api/v1/testimonials/add `
  -H "Content-Type: application/json" `
  -d '{\"studentName\":\"Rajesh Kumar\",\"studentImage\":\"https://randomuser.me/api/portraits/men/1.jpg\",\"designation\":\"ECET Rank 12\",\"review\":\"Excellent platform!\",\"rating\":5,\"isApproved\":true,\"examYear\":\"2024\"}'
```

### Get Approved Testimonials
```powershell
curl http://localhost:8081/api/v1/testimonials/approved
```

---

## 3️⃣ Pricing Plans

### Add Pricing Plan
```powershell
curl -X POST http://localhost:8081/api/v1/pricing/add `
  -H "Content-Type: application/json" `
  -d '{\"planName\":\"Premium Plan\",\"price\":5999.00,\"duration\":\"6 Months\",\"features\":\"All features included\",\"isPopular\":true,\"isActive\":true,\"buttonText\":\"Get Started\",\"buttonLink\":\"/checkout\"}'
```

### Get Active Plans
```powershell
curl http://localhost:8081/api/v1/pricing/active
```

---

## 4️⃣ FAQ

### Add FAQ
```powershell
curl -X POST http://localhost:8081/api/v1/faq/add `
  -H "Content-Type: application/json" `
  -d '{\"question\":\"What is ECET?\",\"answer\":\"ECET is an entrance exam for diploma holders\",\"category\":\"General\",\"displayOrder\":1,\"isActive\":true}'
```

### Get Active FAQs
```powershell
curl http://localhost:8081/api/v1/faq/active
```

---

## 5️⃣ Newsletter

### Subscribe
```powershell
curl -X POST http://localhost:8081/api/v1/newsletter/subscribe `
  -H "Content-Type: application/json" `
  -d '{\"email\":\"student@example.com\",\"source\":\"homepage\"}'
```

### Get Active Subscriptions
```powershell
curl http://localhost:8081/api/v1/newsletter/active
```

---

## 6️⃣ Contact

### Submit Contact Form
```powershell
curl -X POST http://localhost:8081/api/v1/contact/submit `
  -H "Content-Type: application/json" `
  -d '{\"name\":\"John Doe\",\"email\":\"john@example.com\",\"phone\":\"+91-9876543210\",\"subject\":\"Inquiry\",\"message\":\"I want to know more about courses\"}'
```

### Get All Contacts
```powershell
curl http://localhost:8081/api/v1/contact/all
```

---

## 7️⃣ Footer

### Add Footer Link
```powershell
curl -X POST http://localhost:8081/api/v1/footer/add `
  -H "Content-Type: application/json" `
  -d '{\"sectionTitle\":\"Company\",\"linkText\":\"About Us\",\"linkUrl\":\"/about\",\"displayOrder\":1,\"category\":\"company\",\"description\":\"Learn about us\",\"isActive\":true}'
```

### Get Active Footer Items
```powershell
curl http://localhost:8081/api/v1/footer/active
```

---

## 🧪 Test All at Once

Run this script to populate sample data for all sections:

```powershell
# Features
curl -X POST http://localhost:8081/api/v1/features/add -H "Content-Type: application/json" -d '{\"title\":\"Expert Faculty\",\"description\":\"Learn from experts\",\"iconUrl\":\"icon.png\",\"isActive\":true,\"displayOrder\":1}'

# Testimonials
curl -X POST http://localhost:8081/api/v1/testimonials/add -H "Content-Type: application/json" -d '{\"studentName\":\"Rajesh\",\"studentImage\":\"img.jpg\",\"designation\":\"Rank 12\",\"review\":\"Great!\",\"rating\":5,\"isApproved\":true,\"examYear\":\"2024\"}'

# Pricing
curl -X POST http://localhost:8081/api/v1/pricing/add -H "Content-Type: application/json" -d '{\"planName\":\"Premium\",\"price\":5999,\"duration\":\"6 Months\",\"features\":\"All features\",\"isPopular\":true,\"isActive\":true,\"buttonText\":\"Buy\",\"buttonLink\":\"/buy\"}'

# FAQ
curl -X POST http://localhost:8081/api/v1/faq/add -H "Content-Type: application/json" -d '{\"question\":\"What is ECET?\",\"answer\":\"Entrance exam\",\"category\":\"General\",\"displayOrder\":1,\"isActive\":true}'

# Newsletter
curl -X POST http://localhost:8081/api/v1/newsletter/subscribe -H "Content-Type: application/json" -d '{\"email\":\"test@example.com\",\"source\":\"homepage\"}'

# Footer
curl -X POST http://localhost:8081/api/v1/footer/add -H "Content-Type: application/json" -d '{\"sectionTitle\":\"Company\",\"linkText\":\"About\",\"linkUrl\":\"/about\",\"displayOrder\":1,\"category\":\"company\",\"description\":\"About us\",\"isActive\":true}'

Write-Host "✅ All sample data added!"
```

---

## 📊 Verify All Data

```powershell
Write-Host "Features:" -ForegroundColor Green
curl http://localhost:8081/api/v1/features/active

Write-Host "`nTestimonials:" -ForegroundColor Green
curl http://localhost:8081/api/v1/testimonials/approved

Write-Host "`nPricing Plans:" -ForegroundColor Green
curl http://localhost:8081/api/v1/pricing/active

Write-Host "`nFAQs:" -ForegroundColor Green
curl http://localhost:8081/api/v1/faq/active

Write-Host "`nNewsletter:" -ForegroundColor Green
curl http://localhost:8081/api/v1/newsletter/active

Write-Host "`nFooter:" -ForegroundColor Green
curl http://localhost:8081/api/v1/footer/active
```

---

## 🎯 Base URL

All endpoints use: `http://localhost:8081/api/v1`

---

## 💡 Tips

- Use Postman for easier testing (import `ECET_Postman_Collection.json`)
- Check Spring Boot console for SQL queries
- Verify MySQL database for saved data
- Use GET endpoints to verify POST operations worked
