# Training Project — Microservices

A Spring Boot microservices application built as a training project using **IntelliJ IDEA**. The system manages core HR operations — employees, attendance, and payslips — across independently deployable services coordinated by a Eureka discovery server.

---

## Architecture Overview

```
                        ┌─────────────────────┐
                        │    Eureka Server     │
                        │  (Service Registry)  │
                        └──────────┬──────────┘
                                   │  registers / discovers
           ┌───────────────────────┼───────────────────────┐
           │                       │                       │
  ┌────────▼────────┐   ┌──────────▼──────────┐  ┌────────▼────────┐
  │ Employee Service│   │ Attendance Service  │  │ Payslip Service │
  └─────────────────┘   └─────────────────────┘  └─────────────────┘
```

---

## Services

### 🟢 Eureka Server
Central service registry. All microservices register themselves here and discover each other through it at runtime.

### 👤 Employee Service
Manages employee master data — creation, retrieval, and management of employee records.

### 📅 Attendance Service
Handles attendance tracking for employees. Communicates with the Employee Service via service discovery.

### 💰 Payslip Service
Generates and manages payslips. Integrates with employee and attendance data to compute payroll information.

---

## Tech Stack

| Technology | Purpose |
|---|---|
| Java | Primary language |
| Spring Boot | Microservice framework |
| Spring Cloud Netflix Eureka | Service discovery & registry |
| Spring Cloud OpenFeign / RestTemplate | Inter-service communication |
| Maven | Build tool |
| HTML | Frontend views |

---

## Project Structure

```
Training-Project-Microservices/
├── EurekaServer/           # Service registry
├── employee-service/       # Employee management microservice
├── attendance-service/     # Attendance tracking microservice
└── payslip-service/        # Payslip generation microservice
```

---

## Getting Started with IntelliJ IDEA

### Prerequisites

- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) (Community or Ultimate)
- Java 17+ (configure via **File → Project Structure → SDKs**)
- Maven (bundled with IntelliJ or install separately)

### Importing the Project

1. Open IntelliJ IDEA.
2. Click **File → Open** and select the root `Training-Project-Microservices` folder.
3. IntelliJ will detect the Maven modules automatically. If prompted, click **Trust Project**.
4. Wait for Maven to finish downloading dependencies (progress shown in the bottom status bar).
5. Verify all 4 modules appear in the **Project** panel on the left.

### Configuring Run Configurations

Each service needs its own run configuration. For each module:

1. Open the module folder and navigate to the main application class (e.g., `EurekaServerApplication.java`).
2. Click the **green play ▶ button** next to the `main` method, or right-click the file and select **Run**.
3. IntelliJ will auto-create a run configuration for it.

Alternatively, set them up manually:
- Go to **Run → Edit Configurations → + → Spring Boot**
- Set the **Main class** to the respective `*Application.java` class
- Set the **Module** to the corresponding Maven module

### Running the Application

> ⚠️ Services must be started in this order:

**1. EurekaServer** — Start this first.

Navigate to `EurekaServer/src/main/java/.../EurekaServerApplication.java` and run it.

Eureka dashboard → [http://localhost:8761](http://localhost:8761)

**2. employee-service** — Run `EmployeeServiceApplication.java`

**3. attendance-service** — Run `AttendanceServiceApplication.java`

**4. payslip-service** — Run `PayslipServiceApplication.java`

Once all services are running, open the Eureka dashboard and verify all three services appear as registered instances.

### Running All Services Together (IntelliJ Ultimate)

If you're on **IntelliJ IDEA Ultimate**, you can use the **Services** panel to manage all run configurations at once:

- Go to **View → Tool Windows → Services**
- All Spring Boot run configs will appear here
- You can start/stop each service individually from one place

### Using the Maven Tool Window

To build or reload dependencies for any module:

1. Open **View → Tool Windows → Maven**
2. Expand the desired module
3. Run **Lifecycle → install** or click the **Reload** button to sync dependencies

---

## Key Concepts Demonstrated

- **Service Registration & Discovery** — Services register with Eureka and locate each other dynamically without hardcoded URLs.
- **Loose Coupling** — Each service is independently deployable and owns its own data.
- **Inter-Service Communication** — Services communicate over HTTP using service names resolved through Eureka.
- **Single Responsibility** — Each microservice handles one bounded domain (employees, attendance, payslips).

---

## Troubleshooting

| Issue | Fix |
|---|---|
| Services not showing on Eureka dashboard | Ensure EurekaServer is running first; check `application.properties` for correct `eureka.client.serviceUrl` |
| Maven dependencies not resolved | Open Maven panel → click **Reload All Maven Projects** |
| Port already in use | Check `server.port` in each service's `application.properties` and ensure no conflicts |
| Java SDK not found | Go to **File → Project Structure → Project SDK** and point to your JDK installation |

---

## Contributing

This is a training project. Feel free to fork, experiment, and extend it with features like an API Gateway, Docker support, or a centralized config server.
