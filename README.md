
---

## 🧱 Framework Design Explanation

### 1️⃣ BaseTest (Framework Setup)

- Initializes Rest Assured configuration
- Sets:
    - Base URI
    - Authorization token
    - Content type
- Executes before any test class~~~~

This ensures **centralized and reusable configuration**.

---

### 2️⃣ ConfigReader (Configuration Management)

- Reads values from `config.properties`
- Makes framework **configuration-driven**

```properties
base.url=https://gorest.co.in/public/v2
auth.token=YOUR_GOREST_TOKEN
