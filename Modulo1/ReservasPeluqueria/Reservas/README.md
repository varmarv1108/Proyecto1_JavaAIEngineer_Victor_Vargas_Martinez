🚀 **Gestor de Reservas - Salón de Belleza**
Sistema de gestión de reservas para un salón de belleza desarrollado en Java. Permite agendar, listar, cancelar y generar reportes de citas.

📋 Características
✅ Agendar reservas con validación de:
Nombre del cliente (no vacío)
Hora disponible (8:00 - 17:00)
Servicios disponibles (Corte, Tinte, Manicure)
Cupo máximo de 10 reservas

📋 Listar todas las reservas agendadas
❌ Cancelar reservas por número
📊 Reporte del día con:
Total de citas
Dinero facturado
Desglose por servicio

🛠️ **Tecnologías**
Java (JDK 11 o superior)
Consola/terminal

📁 **Estructura del Proyecto**
proyecto-reservas/
├── App.java          # Clase principal - Punto de entrada
├── Menu.java         # Manejo del menú principal
├── Operaciones.java  # Lógica de negocio
├── Validador.java    # Validaciones y utilidades
└── README.md         # Este archivo

🔧 **Instalación y Ejecución**
Prerrequisitos
Java JDK 11 o superior instalado

Git (opcional, para clonar el repositorio)

**Pasos para ejecutar**
1. Clonar el repositorio (si usas Git):
git clone https://github.com/tu-usuario/proyecto-reservas.git
cd proyecto-reservas

2. Compilar todos los archivos Java:
javac *.java

3. Ejecutar la aplicación:
java App