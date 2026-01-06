# ECET Platform - Backend API Documentation

## Base URL
```
http://localhost:8081/api/v1
```

## API Endpoints

### 1. Features API
**Base Path:** `/features`

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/add` | Add a new feature |
| GET | `/all` | Get all features |
| GET | `/active` | Get active features (ordered by display order) |
| GET | `/{id}` | Get feature by ID |
| PUT | `/update/{id}` | Update feature |
| DELETE | `/delete/{id}` | Delete feature |

**Feature Model:**
```json
{
  "id": 1,
  "title": "Expert Faculty",
  "description": "Learn from industry experts with years of experience",
  "iconUrl": "https://example.com/icon.png",
  "isActive": true,
  "displayOrder": 1
}
```

---

### 2. Testimonials API
**Base Path:** `/testimonials`

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/add` | Add a new testimonial |
| GET | `/all` | Get all testimonials |
| GET | `/approved` | Get approved testimonials only |
| GET | `/year/{year}` | Get testimonials by exam year |
| GET | `/{id}` | Get testimonial by ID |
| PUT | `/update/{id}` | Update testimonial |
| PATCH | `/approve/{id}` | Approve a testimonial |
| DELETE | `/delete/{id}` | Delete testimonial |

**Testimonial Model:**
```json
{
  "id": 1,
  "studentName": "John Doe",
  "studentImage": "https://example.com/student.jpg",
  "designation": "ECET Rank 15",
  "review": "Excellent platform for ECET preparation!",
  "rating": 5,
  "isApproved": true,
  "examYear": "2024"
}
```

---

### 3. Pricing Plans API
**Base Path:** `/pricing`

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/add` | Add a new pricing plan |
| GET | `/all` | Get all pricing plans |
| GET | `/active` | Get active pricing plans |
| GET | `/popular` | Get popular pricing plans |
| GET | `/{id}` | Get pricing plan by ID |
| PUT | `/update/{id}` | Update pricing plan |
| DELETE | `/delete/{id}` | Delete pricing plan |

**PricingPlan Model:**
```json
{
  "id": 1,
  "planName": "Premium Plan",
  "price": 999.99,
  "duration": "6 months",
  "features": "All courses,Live classes,Mock tests,Doubt clearing",
  "isPopular": true,
  "isActive": true,
  "buttonText": "Get Started",
  "buttonLink": "/checkout/premium"
}
```

---

### 4. FAQ API
**Base Path:** `/faq`

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/add` | Add a new FAQ |
| GET | `/all` | Get all FAQs |
| GET | `/active` | Get active FAQs (ordered by display order) |
| GET | `/category/{category}` | Get FAQs by category |
| GET | `/{id}` | Get FAQ by ID |
| PUT | `/update/{id}` | Update FAQ |
| DELETE | `/delete/{id}` | Delete FAQ |

**FAQ Model:**
```json
{
  "id": 1,
  "question": "What is ECET?",
  "answer": "ECET stands for Engineering Common Entrance Test...",
  "category": "General",
  "displayOrder": 1,
  "isActive": true
}
```

---

### 5. Contact API
**Base Path:** `/contact`

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/submit` | Submit a contact form |
| GET | `/all` | Get all contact submissions |
| GET | `/unread` | Get unread contacts |
| GET | `/unreplied` | Get unreplied contacts |
| GET | `/email/{email}` | Get contacts by email |
| GET | `/{id}` | Get contact by ID |
| PATCH | `/mark-read/{id}` | Mark contact as read |
| PATCH | `/mark-replied/{id}` | Mark contact as replied |
| DELETE | `/delete/{id}` | Delete contact |

**Contact Model:**
```json
{
  "id": 1,
  "name": "Jane Smith",
  "email": "jane@example.com",
  "phone": "+91-9876543210",
  "subject": "Course Inquiry",
  "message": "I would like to know more about your courses...",
  "submittedAt": "2024-12-25T11:59:49",
  "isRead": false,
  "isReplied": false
}
```

---

### 6. Newsletter API
**Base Path:** `/newsletter`

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/subscribe` | Subscribe to newsletter |
| GET | `/all` | Get all subscriptions |
| GET | `/active` | Get active subscriptions |
| GET | `/{id}` | Get subscription by ID |
| GET | `/email/{email}` | Get subscription by email |
| PATCH | `/unsubscribe/{email}` | Unsubscribe from newsletter |
| DELETE | `/delete/{id}` | Delete subscription |

**Newsletter Model:**
```json
{
  "id": 1,
  "email": "user@example.com",
  "subscribedAt": "2024-12-25T11:59:49",
  "isActive": true,
  "source": "homepage"
}
```

---

### 7. Footer API
**Base Path:** `/footer`

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/add` | Add a new footer item |
| GET | `/all` | Get all footer items |
| GET | `/active` | Get active footer items (ordered by display order) |
| GET | `/category/{category}` | Get footer items by category |
| GET | `/{id}` | Get footer item by ID |
| PUT | `/update/{id}` | Update footer item |
| DELETE | `/delete/{id}` | Delete footer item |

**Footer Model:**
```json
{
  "id": 1,
  "sectionTitle": "Quick Links",
  "linkText": "About Us",
  "linkUrl": "/about",
  "displayOrder": 1,
  "category": "company",
  "description": "Learn more about our mission",
  "isActive": true
}
```

---

### 8. Banner API (Existing)
**Base Path:** `/api/v1`

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/add1` | Add a new banner |
| GET | `/fetch` | Get all banners |

---

### 9. Navbar API (Existing)
**Base Path:** `/api/v1/navbar`

*(Check existing controller for endpoints)*

---

## Database Configuration

Update `application.properties`:
```properties
spring.application.name=ecet
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.url=jdbc:mysql://localhost:3306/ecet
server.port=8081
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## Testing the API

### Using cURL:

**Add a Feature:**
```bash
curl -X POST http://localhost:8081/api/v1/features/add \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Expert Faculty",
    "description": "Learn from industry experts",
    "iconUrl": "https://example.com/icon.png",
    "isActive": true,
    "displayOrder": 1
  }'
```

**Get Active Features:**
```bash
curl http://localhost:8081/api/v1/features/active
```

**Subscribe to Newsletter:**
```bash
curl -X POST http://localhost:8081/api/v1/newsletter/subscribe \
  -H "Content-Type: application/json" \
  -d '{
    "email": "user@example.com",
    "source": "homepage"
  }'
```

---

## Notes

- All endpoints support CORS from any origin
- Timestamps are automatically set for Contact and Newsletter entities
- Boolean flags (isActive, isApproved, etc.) default to appropriate values
- Use display order fields to control the sequence of items on the frontend
