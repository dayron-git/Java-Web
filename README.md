# Gestión de Activos TI
 
## Descripción
 
Proyecto académico. Es una aplicación web para la **gestión de activos tecnológicos** de una organización (equipos, licencias, etc.), con control de acceso mediante usuarios registrados.
 
Permite iniciar sesión, visualizar un dashboard, y administrar activos y usuarios del sistema.
 
##  Tecnologías utilizadas
 
- **Java** (release 24)
- **Jakarta Servlets** (6.0.0) — lógica del backend
- **JSP** — vistas del lado del servidor
- **SQL Server** (driver `mssql-jdbc`) — base de datos
- **Maven** — gestión de dependencias y build
- **Apache Tomcat** (servidor de aplicaciones)
 
## Funcionalidades
 
- Inicio y cierre de sesión con validación de usuario/contraseña
- Dashboard con acceso a los módulos del sistema
- CRUD de activos tecnológicos
- CRUD de usuarios
  
## Configuración e instalación
 
1. Clona el repositorio.
2. Importa el proyecto como **Maven Project** en Eclipse (o tu IDE preferido).
3. Crea la base de datos `itam` en SQL Server.
4. Configura las credenciales de conexión en:
```
   src/main/java/pe/isil/itam/util/ConnectionFactory.java
```
   >  Reemplaza el usuario y contraseña por los de tu propio entorno antes de ejecutar el proyecto.
5. Ejecuta el proyecto en un servidor **Apache Tomcat**.
