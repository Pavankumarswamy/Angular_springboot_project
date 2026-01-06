# Postman Setup Guide - ECET Platform

## 📋 Prerequisites

1. **MySQL Database** must be running on `localhost:3306`
2. **Database** named `ecet` must exist
3. **Postman** application installed
4. **Spring Boot application** running on port `8081`

---

## 🚀 Quick Start

### Step 1: Start MySQL Database

Make sure MySQL is running and create the database:

```sql
CREATE DATABASE IF NOT EXISTS ecet;
```

### Step 2: Start Spring Boot Application

```bash
cd "c:\Users\shese\Desktop\spring projects\demo"
./mvnw spring-boot:run
```

Wait for the message: `Started DemoApplication in X seconds`

### Step 3: Import Postman Collection

1. Open Postman
2. Click **Import** button
3. Select the file: `ECET_Postman_Collection.json`
4. The collection will appear in your Collections sidebar

---

## 📤 Sending Data to Backend

### Method 1: Using Postman Collection (Recommended)

The collection is organized into folders for each section:

1. **Features** (4 sample requests)
2. **Testimonials** (3 sample requests)
3. **Pricing Plans** (3 sample requests)
4. **FAQ** (4 sample requests)
5. **Newsletter** (1 sample request)
6. **Footer** (4 sample requests)

**To send data:**
1. Expand a folder (e.g., "Features")
2. Click on a request (e.g., "Add Feature 1 - Expert Faculty")
3. Click the blue **Send** button
4. Check the response in the bottom panel

**Run all requests in a folder:**
1. Right-click on the folder name
2. Select **Run folder**
3. Click **Run ECET Platform API**
4. All requests will execute sequentially

---

### Method 2: Using cURL Commands

If you prefer command line, here are sample cURL commands:

**Add a Feature:**
```bash
curl -X POST http://localhost:8081/api/v1/features/add \
  -H "Content-Type: application/json" \
  -d "{\"title\":\"Expert Faculty\",\"description\":\"Learn from experienced faculty\",\"iconUrl\":\"https://example.com/icon.png\",\"isActive\":true,\"displayOrder\":1}"
```

**Add a Testimonial:**
```bash
curl -X POST http://localhost:8081/api/v1/testimonials/add \
  -H "Content-Type: application/json" \
  -d "{\"studentName\":\"Rajesh Kumar\",\"studentImage\":\"https://randomuser.me/api/portraits/men/1.jpg\",\"designation\":\"ECET Rank 12\",\"review\":\"Excellent platform!\",\"rating\":5,\"isApproved\":true,\"examYear\":\"2024\"}"
```

**Add a Pricing Plan:**
```bash
curl -X POST http://localhost:8081/api/v1/pricing/add \
  -H "Content-Type: application/json" \
  -d "{\"planName\":\"Premium Plan\",\"price\":5999.00,\"duration\":\"6 Months\",\"features\":\"All features included\",\"isPopular\":true,\"isActive\":true,\"buttonText\":\"Get Started\",\"buttonLink\":\"/checkout\"}"
```

---

## 🎨 Extracting Data from Figma-to-HTML

### To extract actual content from your frontend:

1. **Copy the figma-to-html folder** to the project directory:
   ```bash
   Copy-Item "C:\Users\shese\Downloads\figma-to-html" -Destination "c:\Users\shese\Desktop\spring projects\demo\" -Recurse
   ```

2. **Open the HTML files** and extract:
   - Feature titles and descriptions
   - Testimonial content
   - Pricing plan details
   - FAQ questions and answers
   - Footer links

3. **Update the Postman requests** with actual content from your design

---

## 📊 Verifying Data

After sending POST requests, verify the data was saved:

**Get All Features:**
```
GET http://localhost:8081/api/v1/features/all
```

**Get Active Features:**
```
GET http://localhost:8081/api/v1/features/active
```

**Get Approved Testimonials:**
```
GET http://localhost:8081/api/v1/testimonials/approved
```

**Get Active Pricing Plans:**
```
GET http://localhost:8081/api/v1/pricing/active
```

**Get Active FAQs:**
```
GET http://localhost:8081/api/v1/faq/active
```

---

## 🔍 Sample Request/Response

### Request:
```json
POST http://localhost:8081/api/v1/features/add
Content-Type: application/json

{
  "title": "Expert Faculty",
  "description": "Learn from industry experts",
  "iconUrl": "https://example.com/icon.png",
  "isActive": true,
  "displayOrder": 1
}
```

### Response:
```json
"Feature added successfully"
```

### Verify:
```json
GET http://localhost:8081/api/v1/features/all

Response:
[
  {
    "id": 1,
    "title": "Expert Faculty",
    "description": "Learn from industry experts",
    "iconUrl": "https://example.com/icon.png",
    "isActive": true,
    "displayOrder": 1
  }
]
```

---

## 🛠️ Troubleshooting

### Application won't start
- Check if MySQL is running
- Verify database `ecet` exists
- Check port 8081 is not in use

### POST request fails
- Verify Content-Type header is `application/json`
- Check JSON syntax is valid
- Ensure all required fields are present

### Data not appearing
- Check if `isActive` is set to `true`
- Verify the GET endpoint URL is correct
- Check Spring Boot console for SQL queries

---

## 📝 Next Steps

1. **Populate all sections** using the Postman collection
2. **Extract actual content** from your figma-to-html files
3. **Update Postman requests** with real content
4. **Test GET endpoints** to verify data
5. **Integrate with frontend** using the API endpoints

---

## 💡 Tips

- Use **Postman Environment Variables** for the base URL
- Save responses to verify data structure
- Use **Postman Tests** to automate verification
- Export updated collection after adding real data
- Keep the collection organized by section

---

## 📞 API Endpoints Summary

| Section | POST Endpoint | GET Endpoint |
|---------|--------------|--------------|
| Features | `/api/v1/features/add` | `/api/v1/features/active` |
| Testimonials | `/api/v1/testimonials/add` | `/api/v1/testimonials/approved` |
| Pricing | `/api/v1/pricing/add` | `/api/v1/pricing/active` |
| FAQ | `/api/v1/faq/add` | `/api/v1/faq/active` |
| Newsletter | `/api/v1/newsletter/subscribe` | `/api/v1/newsletter/active` |
| Footer | `/api/v1/footer/add` | `/api/v1/footer/active` |
| Contact | `/api/v1/contact/submit` | `/api/v1/contact/all` |

All endpoints are prefixed with: `http://localhost:8081`
