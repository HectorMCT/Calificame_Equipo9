# Kotlin Avanzado : Equipo 9
 Aquí se encontraran todo lo relacionado al proyecto del modulo de Kotlin Intermedio Santander 2021
 ### Integrantes 🧑🏻‍💻
 - [Esiel Kevin Arizmendi Ramírez](https://github.com/Esiel15)
 - [Héctor Manuel Chávez Troncoso](https://github.com/HectorMCT)
 - [Mayra Jimenez Maldonado](https://github.com/MayraJM)
 
### Requisitos ⚙️
- Android Studio 4.2 o superior

### Instrucciones 🔧
- Descargar el repositorio
- Abrir proyecto existente en Android Studio, seleccinando la carpeta CalificameApp del repositorio


## Proyecto 🚀
 Califícame! es una aplicación nativa de Android en la que cualquier usuario podrá realizar y/o ver las reviews y las estadísticas de los profesores que laboran en su institución de nivel superior. De esta manera los usuarios estarán más informados para elegir con quienes tomar sus cursos mientras contribuyen con el contenido de la aplicación. 
 
 Con la realización de una aplicación móvil, donde cualquier estudiante interesado en la búsqueda de información objetiva y subjetiva de los profesores que imparten cursos en su institución, se vería beneficiado en cuestión de eficiencia, comodidad y seguridad, debido a que podría encontrar suficiente información para tomar una decisión desde algún dispositivo Android, así como privacidad, garantizando que cualquier información que proporcione a la plataforma sea de forma anónima. El proyecto toma como base lo que implementa la pagina de [MisProfesores](https://www.misprofesores.com/).

### Objetivo 🏹
El objetivo a alcanzar es crear una aplicación para los dispositivos Android. En donde cualquier usuario que posea la aplicación podrá ver las opiniones de otros usuarios hacia los profesores, así como sus estadísticas generales. Además, podrá aportar opiniones y evaluar a los profesores en los distintos cursos que han impartido contribuyendo al repositorio de la aplicación.

### Alcance 🔥
Contener un amplio repositorio de instituciones de nivel superior, profesores y opiniones inicialmente a nivel nacional y posteriormente en otros países sistemas educativos similares.

### Limitaciones ⛓
Debido a que los estudiantes generalmente son autónomos en la toma de decisiones de profesores hasta alcanzar el nivel superior de estudios, la aplicación se limitará únicamente a tener información de universidades y posiblemente posgrados.

No todas las instituciones que ofrecen educación superior cuentan con una gran oferta de profesores para impartir sus cursos, generalmente son las instituciones públicas y algunas pocas privadas, por lo que la aplicación sería de más utilidad para dichas universidades y carecería de utilidad en instituciones con baja densidad de alumnos y profesores.
 
## Roadmap 📦

Tarea | Descripción
------------ | -------------
Implementar UI | La implementación de una interfaz gráfica, no es algo que se deba discutir, sino que ya es una necesidad, es por ello que lo primordial es su implementación de la mejor manera posible para el agrado de los usuarios. La interfaz gráfica debe ser acorde a los componentes característicos de [Material Desing](https://material.io/design)
Mejorar UX | El mejoramiento de la experiencia de usuario va de la mano con la implementación de la interfaz gráfica. Pretendemos tomar en cuenta todo lo visto en el módulo de UI Fundamentals y tomar en cuenta siempre al usuario en la implementación de la interfaz gráfica.
Integración de APIs con redes sociales | La integración de APIs con redes sociales va de la mano con la expansión de nuestros usuarios, ya que de hacerlo, la aplicación se haría más popular entre los estudiantes. Por otra parte, mejoraría la experiencia de usuario.

## Mockups 🏞

Se tienen generado el Mockup de la App, el cual nos servirá de guía para el desarrollo de la interfaz grafica.

![Gif de Mockups](https://github.com/HectorMCT/Kotlin_Intermedio_Equipo1/blob/main/Media/UI%20GIF.gif)

### Vistas 🌁

- [x] Inicio de sesión. [Esiel15](https://github.com/Esiel15)
- [x] Registro. [Esiel15](https://github.com/Esiel15)
- [x] Recuperar contraseña. [HectorMCT](https://github.com/HectorMCT)
- [x] Menú principal (Drawer). [Esiel15](https://github.com/Esiel15)
- [x] Perfil de usuario. [Esiel15](https://github.com/Esiel15)
- [x] Universidades. [Esiel15](https://github.com/Esiel15)
- [x] Facultades. [MayraJM](https://github.com/MayraJM)
- [x] Profesores. [deividshido](https://github.com/deividshido)
- [x] Estadisticas Generales.[Esiel15](https://github.com/Esiel15)
- [x] Añadir reviews. [HectorMCT](https://github.com/HectorMCT), [MayraJM](https://github.com/MayraJM)
- [x] Reviews. [Esiel15](https://github.com/Esiel15)

### Animaciones y Transiciones
Con el objetivo de que el usuario tenga una mejor experiencia, se añadieron transiciones entre fragments y entre activities. Para su implementación, se tomaron en cuenta los temas vistos recientemente en el curso. Se hace uso de un navigation component, donde se implementaron de una manera más sencilla las transiciones debido a la forma con la que se ha trabajado la aplicación. Por otro lado, algunas animaciones se implementaron cuando se hace uso del menú que aparece en la vista de Profesores.

### API
Con el objetivo de implementar una API util para la aplicación, se creo una API utilizando Amazon AWS, donde se guarda información unicamente relacionada con las Universidades, en ella se podra encontrar su nombre y una imagen la cual es utilizada en la aplicación. [Link de la API](https://f1yi66cpk3.execute-api.us-east-1.amazonaws.com/production/prueba-images-bedu?tenant_id=sprmx)

### Cámara
Ahora los usuarios podrán cambiar la foto de su perfil utilizando la cámara de su dispositivo android, se implemento de manera muy similar a lo visto en la sesión 3.

### Shared Preferences y Persistencia de datos
Se implemento SharedPreferences para saber si el usuario ya esta loggeado en la aplicación, y en ese caso no tener que iniciar sesión o registrase cada vez que abra la aplicación. Sin embargo, el mecanismo utilizado no es el recomendable, por lo que en futuras sesiones avanzadas, se pretende cambiar por un mecanismo seguro. Para el caso del uso de las bases de datos vista en la sesión 4, se opto por implementar unicamente una pequeña base de datos con solamente la tabla Users, teniendo el registro de todos los usuarios, sin embargo, esta base de datos es embebida, por lo que carece de utilidad. En sesiones posteriores se pretende utilizar los módulos Firebase Authentication y Cloud Firestore.

### Patrones de Arquitectura
Se implemento el patrón de arquitectura MVVM unicamente para manejar los cambios de los usuarios mediante el ViewModel de los usuarios, además de implementar DataBinding y ViewBinding.

### Validaciones 
Se generaron validaciones dentro tanto para el ingreso de un usuario a la aplicación, como para el registro de un nuevo usuario. Por el momento no se tiene conexión a ninguna base de datos remota, la cual se encargara tanto de alojar a nuestros usuarios, como las estadísticas y comentarios que generen sobre los profesores. Toda esta información sera moldeada con el [proyecto](https://github.com/HectorMCT/Kotlin_Intermedio_Equipo19/tree/main/CalificameApp/app/src/main/java/com/esielkar/calificame/model) que creamos en el módulo anterior.

### Tests 
Se generarion test para corroborar el correcto funcionamiento del LogIn de la aplicación datos de los usuarios, así como los datos dentro de la base de datos. Con testValidUsername() y testAssertValidUsername(), ponemos a prueba el nombre del usuario; Por otro lado, con testValidUser(), testAssertValidUser() y testFalseValidUser(), validamos todos los datos del usuarios. (ID, username, correo, contraseña)

### Notificaciones
Se creo una notificación dentro de la aplicación, la cual se activa cada vez que este registra una nueva reseña hacia algun profesor/a. Esta solo se despliega con un mensaje siemple, que contiene el nombre de a quien acaba hacerle la reseña.

Se han creado 4 usuarios para la validación del inicio de sesión como para el registro de usuarios.

Nombre de usuario | Correo electrónico | Contraseña
------------ | ------------- | -------------
Invitado |  | 
Hector | hector@calificame.com | 12345678
Mayra | mayra@calificame.com | 12345678
Esiel | esiel_kar@hotmail.com | 12345678


Por otra parte, también se tienen los botones de Skip Sign In y Skip Sign Up, con el propósito de que al probar la app, no se tengan que realizar estas actividades que se pueden hacer tediosas.

## More...
coming soon. (Maybe, next module! We hope)
