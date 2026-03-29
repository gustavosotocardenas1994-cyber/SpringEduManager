Sistema de Gestión de Cursos y Estudiantes

Proyecto desarrollado en Spring Boot que permite la gestión de cursos y estudiantes, integrando funcionalidades web (MVC) y servicios REST, junto con seguridad mediante autenticación.

📌 Descripción

Esta aplicación permite:

- Administrar cursos (crear, editar, eliminar, listar)

- Administrar estudiantes

- Asignar cursos a estudiantes (relación muchos a muchos)

- Autenticación de usuarios con roles

- Consumo de API REST

----------------------------------------------------------------------------------------------------------------------------------------------

🛠️ Tecnologías utilizadas

- Java 17

- Spring Boot 3

- Spring MVC

- Spring Data JPA

- Spring Security

- Thymeleaf

- Base de datos H2

- Maven

-----------------------------------------------------------------------------------------------------------------------------------------------

🏗️ Estructura del Proyecto

El proyecto está organizado en capas:

com.SistemaCursos
│
├── controller        → Controladores MVC y REST
├── service           → Lógica de negocio
├── repository        → Acceso a datos (JPA)
├── model             → Entidades (Curso, Estudiante)
├── config            → Configuración de seguridad

-----------------------------------------------------------------------------------------------------------------------------------------------

🔐 Seguridad

Se implementó autenticación con Spring Security:

Usuario ADMIN:

username: admin



password: 1234

Usuario USER:

username: user

password: 1234

Roles:
ADMIN: acceso completo (CRUD cursos y estudiantes)

USER: acceso limitado

🌐 Funcionalidades Web (MVC)

Página de inicio con menú de navegación

Login personalizado

Listado de cursos y estudiantes

Formularios para crear y editar

Eliminación de registros

🔗 API REST

-----------------------------------------------------------------------------------------------------------------------------------------------

📚 Cursos

GET → /api/cursos → Listar cursos

POST → /api/cursos → Crear curso

PUT → /api/cursos/{id} → Actualizar curso

DELETE → /api/cursos/{id} → Eliminar curso

👨‍🎓 Estudiantes

GET → /api/estudiantes

POST → /api/estudiantes

PUT → /api/estudiantes/{id}

DELETE → /api/estudiantes/{id}

-----------------------------------------------------------------------------------------------------------------------------------------------

🧪 Evidencias funcionales


Se incluyen:

✅ Capturas de pantalla del sistema funcionando
✅ Pruebas de API REST (GET, POST, PUT, DELETE)
✅ Flujo completo: login → navegación → CRUD

(Agregar aquí imágenes o links si tu profe lo pide)

-----------------------------------------------------------------------------------------------------------------------------------------------

▶️ Ejecución del Proyecto

<img width="1397" height="1272" alt="Captura de pantalla 2026-03-28 215237" src="https://github.com/user-attachments/assets/455bcb2b-2ae1-4359-8fd6-c4f90245778a" />

<img width="1658" height="743" alt="Captura de pantalla 2026-03-28 215301" src="https://github.com/user-attachments/assets/db96acea-5d12-49f3-a4d5-c53ea978f510" />

<img width="922" height="481" alt="Captura de pantalla 2026-03-28 215221" src="https://github.com/user-attachments/assets/c6cbe4f0-65c7-4610-a680-7122e20a3b27" />



-----------------------------------------------------------------------------------------------------------------------------------------------

⚠️ Notas
La base de datos H2 es en memoria, por lo que se reinicia al apagar la aplicación.

Se utilizó Thymeleaf para la capa de vista.

Se implementó separación entre MVC y REST.

-----------------------------------------------------------------------------------------------------------------------------------------------

👨‍💻 Autor

Desarrollado por Gustavo Soto
