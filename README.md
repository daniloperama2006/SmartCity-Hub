# 🌤️ SmartCity Hub – Weather Service

Una aplicación de clima **Full-Stack** de alto rendimiento construida con **Java Spring Boot (Reactive)** y **Angular**, completamente containerizada con **Docker** y servida mediante **NGINX**.

Este proyecto consume la API de OpenWeather y está diseñado siguiendo principios de arquitectura limpia, escalabilidad y preparación para entornos de producción.

---

## 📌 Descripción General

**SmartCity Hub – Weather Service** es parte de un ecosistema modular de Ciudad Inteligente. Proporciona información meteorológica en tiempo real mediante una interfaz moderna y una API REST robusta.

### Objetivos Clave
* **Backend Reactivo:** Uso de Spring WebFlux para manejo eficiente de hilos y escalabilidad.
* **Arquitectura Limpia:** Separación clara de responsabilidades (Client, Service, Config, Exceptions).
* **Seguridad:** Manejo de llaves de API mediante variables de entorno para evitar filtraciones.
* **Despliegue Moderno:** Uso de Docker Compose y NGINX para un entorno listo para producción.

---

## 🧱 Tech Stack

### **Backend**
* **Java 21** & **Spring Boot 3**
* **Spring WebFlux** (Programación Reactiva)
* **WebClient** (Cliente HTTP no bloqueante)
* **Maven** (Gestión de dependencias)

### **Frontend**
* **Angular** (Standalone Components)
* **TypeScript** & **RxJS**
* **Bootstrap / CSS** (UI Moderna)

### **Infraestructura**
* **Docker & Docker Compose**
* **NGINX** (Servidor web y Proxy inverso)
* **OpenWeather API** (Fuente de datos externa)

---
# 🌐 Flujo de la Aplicación
Entrada: El usuario ingresa el nombre de una ciudad en la UI de Angular.Petición: Angular realiza una petición al backend: GET /api/weather/{city}.Procesamiento: El backend consulta la API de OpenWeather de forma reactiva.Respuesta: Los datos se mapean a un DTO y se envían de vuelta al cliente.Visualización: Angular muestra la información climática actualizada.🔐 Manejo de API Keys (Seguridad)[!IMPORTANT]Se requiere una API Key de OpenWeather para que la aplicación funcione.Para garantizar la seguridad y evitar subir credenciales al repositorio:La API Key nunca se incluye en el código fuente.Se inyecta a través de variables de entorno en el contenedor.Configuración en Spring Boot:Propertiesopenweather.api.key=${OPENWEATHER_API_KEY}
# ▶️ Cómo ejecutar el proyecto
### Prerrequisitos: Docker y Docker Compose instalados.
### Una cuenta en OpenWeather para obtener tu llave.

1. Clonar el repositorioBashgit clone [https://github.com/daniloperama2006/SmartCity-Hub.git](https://github.com/daniloperama2006/SmartCity-Hub.git)
2. cd SmartCity-Hub
3. Configurar la API KeyDebes definir la variable de entorno en tu terminal antes de ejecutar Docker:Windows (PowerShell):PowerShell $env:OPENWEATHER_API_KEY="tu_api_key_aqui"
Linux / macOS:Bashexport OPENWEATHER_API_KEY=tu_api_key_aqui (encontrarás una por defecto utilizada durante el desarrollo, puedes modificarla)
4. Levantar con Docker ComposeBashdocker-compose up --build
5. Acceder a la aplicaciónServicioURLFrontend (Interfaz) http://localhostBackend API http://localhost/api/weather/Bogota


# 🧪 Decisiones de DiseñoStack Reactivo: 
* Optimizado para manejar múltiples peticiones concurrentes con baja latencia.
* NGINX para Frontend: Se utiliza NGINX para servir los archivos compilados de Angular, lo cual es más eficiente que usar el servidor de desarrollo en producción.Multi-stage Builds: Los Dockerfiles están optimizados para generar imágenes ligeras y seguras.


## 📂 Estructura del Proyecto

```text
SmartCity-Hub/
│
├── weather-service/           # Backend Spring Boot
│   ├── src/main/java          # Lógica de negocio reactiva
│   ├── Dockerfile             # Multi-stage build (Maven + JRE)
│   └── pom.xml
│
├── weather-frontend/          # Frontend Angular
│   ├── src/                   # Componentes Standalone
│   ├── Dockerfile             # Build de Angular + NGINX
│   └── angular.json
│
├── docker-compose.yml         # Orquestación de contenedores
├── .gitignore
└── README.md


