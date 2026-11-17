# AgriSmart — Smart Agriculture & Crop Prediction System

Starter full-stack Java 21 application for Tomcat 9 (WAR), Spring MVC 5.3 (`javax.servlet`), Spring Security 5.8, Thymeleaf, MySQL 8 and Bootstrap 5.

## Included modules
- Login and dashboard (demo in-memory accounts)
- Farm CRUD: create and list farms
- Crop registration and listing
- Soil readings: pH, moisture, NPK
- Irrigation schedule creation and listing
- Harvest-yield analytics view (reads `harvest_records`)
- Live weather endpoint backed by Open-Meteo
- Initial transparent soil recommendation heuristic service
- Dockerfile and Docker Compose deployment skeleton

## Prerequisites
- JDK 21 (`java -version`)
- Maven 3.9+
- MySQL 8
- Tomcat 9.0.x with Java 21

## Configure MySQL
Run `src/main/resources/db/schema.sql` in MySQL. Set environment variables before starting Tomcat:

```bash
export DB_URL='jdbc:mysql://localhost:3306/smart_agriculture?useSSL=false&serverTimezone=UTC'
export DB_USER='agri_user'
export DB_PASSWORD='replace-with-a-secret'
```

Windows PowerShell:
```powershell
$env:DB_URL='jdbc:mysql://localhost:3306/smart_agriculture?useSSL=false&serverTimezone=UTC'
$env:DB_USER='agri_user'
$env:DB_PASSWORD='replace-with-a-secret'
```

## Build and deploy to Tomcat 9
```bash
mvn clean package
```
Copy `target/smart-agriculture.war` to `$CATALINA_HOME/webapps/` and start Tomcat. Open `http://localhost:8080/smart-agriculture/` (or root context if renamed to ROOT.war).

Demo login: `farmer` / `Farm@123` or `admin` / `Admin@123`. These are development-only in-memory accounts. Replace with database-backed user registration, password reset, role/tenant isolation and secure session configuration before production.

## Weather endpoint
`GET /smart-agriculture/weather?lat=17.385&lon=78.4867` returns current conditions and daily forecast JSON from Open-Meteo. Coordinates default to Hyderabad; pass the actual farm coordinates. External API availability and terms apply.

## Soil recommendation endpoint
`GET /smart-agriculture/prediction/soil-advice?ph=6.5&moisture=20&nitrogen=35&phosphorus=18&potassium=30` returns transparent starter rules. It is not a validated crop recommendation or yield-prediction model.

## Docker Compose
Build the WAR first, then:
```bash
mvn clean package
docker compose up --build
```
Change the example database password before use. For production, use managed MySQL (e.g. AWS RDS), secrets management, TLS, backups and private networking.

## Important next development increments
1. Add database-backed users, farmer/consultant/admin roles, authorization by farm ownership and CSRF protection.
2. Add edit/delete operations, pagination, server-side validation and audit logs.
3. Implement crop suitability and yield prediction using region/crop/season training data; evaluate and version the model. Current recommendation helper is only a rule-based starter, not a validated ML predictor.
4. Add calibrated IoT sensor ingestion (MQTT/HTTP), device identity, timestamp validation and alert thresholds.
5. Add irrigation calculation using crop stage, evapotranspiration, rainfall forecast, soil texture and field capacity; do not automatically control pumps without safety interlocks and user approval.
6. Add disease-image model integration and human-reviewed recommendations.
7. Add market prices, expenses, harvest entry, profitability charts, notifications and Telugu localization.
8. Add automated tests, CI/CD pipeline, observability, rate limiting and security review.

## Architecture
Browser (Bootstrap + Thymeleaf) → Spring MVC controllers → services → JdbcTemplate/MySQL. Weather data is fetched server-side from Open-Meteo. Keep sensor and prediction integrations behind service interfaces as the project grows.
