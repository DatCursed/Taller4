# Taller4

# AcademiCore - Sistema de Gestión de Certificaciones Académicas

## Descripción del Proyecto
AcademiCore es un sistema académico integral desarrollado en Java diseñado para la "Universidad Católica del Mish". Su objetivo principal es digitalizar y automatizar la gestión de Certificaciones Profesionales (Sistemas Inteligentes, Ciberseguridad y Desarrollo de Software), permitiendo a los estudiantes visualizar su progreso en tiempo real y a los coordinadores gestionar métricas y emisiones de certificados de manera eficiente.

El sistema resuelve la problemática de la gestión manual, que provocaba pérdida de oportunidades para los estudiantes y lentitud en los procesos administrativos [cite: 24-28].

## Integrantes del Grupo
 Integrante 1: David Rodríguez Sebastían Guevara - 21.806.579-1 - DatCursed

## Estructura del Proyecto
El proyecto sigue una Arquitectura en 3 Capas para asegurar la separación de responsabilidades y la mantenibilidad del código:

# 1. Capa de Presentación (Paquete `GUI`)
Contiene todas las clases relacionadas con la interfaz gráfica de usuario construida con Java Swing.
* `GUI.java`: Ventana de inicio de sesión.
* `GUIAdmin.java`: Panel de administración de usuarios.
* `GUIEstudiante.java`: Dashboard del estudiante (Malla, Certificaciones).
* `GUICoordinador.java`: Panel de métricas y gestión.

# 2. Capa de Lógica de Negocio (Paquetes `Logica`, `Singleton`, `Factory`)
Gestiona las reglas del negocio, la carga de datos y la manipulación de objetos.
* `App.java`: Punto de entrada (`main`) que orquesta la carga de archivos y el inicio de la GUI.
* `SistemaImpl.java`: Clase principal que centraliza la lógica del sistema.
* `UsuariosFactory.java`: Encargada de la creación compleja de objetos de usuario.

# 3. Capa de Dominio/Modelo (Paquete `Logica`)
Define las entidades principales del sistema.
* `Usuario`, `Estudiante`, `Coordinador`, `Administrador`.
* `Curso`, `Nota`.
* `Certificacion`, `RegistroCertificacion`.

## Patrones de Diseño Implementados
El sistema implementa cuatro patrones de diseño fundamentales para cumplir con los requisitos técnicos:

1.  Singleton (`SistemaImpl`):**
    * **Uso:** Garantiza que exista una única instancia del sistema (`Sistema`) cargada en memoria durante toda la ejecución.
    * **Beneficio:** Permite un acceso centralizado a las listas de usuarios, cursos y certificaciones desde cualquier ventana de la interfaz gráfica sin duplicar datos.

2.  Factory Method (`UsuariosFactory`):**
    * **Uso:** Centraliza la lógica de creación de usuarios al leer los archivos de texto (`usuarios.txt` vs `estudiantes.txt`).
    * **Beneficio:** Abstrae la complejidad de diferenciar entre un Administrador, Coordinador o Estudiante basándose en la cantidad de columnas y el formato del archivo fuente.

3.  Strategy (Validación de Inscripciones):**
    * **Uso:** Implementa diferentes algoritmos de validación para inscribir certificaciones (ej. validar créditos mínimos, prerrequisitos aprobados).
    * **Beneficio:** Permite cambiar o agregar nuevas reglas de inscripción sin modificar la clase `Estudiante`.

4.  Visitor (Reportes y Dashboard):**
    * **Uso:** Permite recorrer la estructura de certificaciones y cursos de un estudiante para generar reportes de progreso o calcular estadísticas sin modificar las clases de los elementos visitados.
    * **Beneficio:** Facilita la generación de métricas complejas requeridas en el menú del Coordinador y el Estudiante.

## Instrucciones de Ejecución
Para ejecutar el proyecto correctamente, siga estos pasos:

1.  **Ejecución:**
    * Abra el archivo `src/Logica/App.java`.
    * Ejecute el archivo como **Java Application**.
2.  **Credenciales de Prueba:**
    * **Administrador:** Usuario: `admin` | Clave: `admin123`
    * **Estudiante:** Usuario: `12345678-9` | Clave: `contraseña123`
    * **Coordinador:** Usuario: `coord.si` | Clave: `coord123`

## Librerías Externas
El proyecto utiliza únicamente las librerías estándar de Java (Java Swing, AWT, IO, Util), por lo que no requiere la importación de `.jar` externos.
