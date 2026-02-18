Dispones de un fichero binario inicial alumnos.dat que contiene objetos serializados de 
tipo Alumno.
Cada objeto Alumno representa un registro con esta información:
• nombre (cadena, String)
• nota (número real, double)
La aplicación Java debe:
1. Leer desde el fichero binario alumnos.dat todos los objetos Alumno.
2. Almacenar todos los alumnos leídos en una colección adecuada.
3. Mostrar en consola:
o Para cada alumno, su nota media.
o Listado de alumnos ordenados por nota media.
o Listado de alumnos aprobados.
o Nombre del alumno con mejor nota media.
Recomendaciones
• Usar FileInputStream y ObjectInputStream.
• Usar colecciones
• Controlar posibles errores de lectura
