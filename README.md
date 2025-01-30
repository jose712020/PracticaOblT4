# PracticaObligatoriaT4

![image](https://github.com/user-attachments/assets/95a43da4-e42b-4033-ba4d-8802ba36a671)


# **Indíce**
  

0.  **Instalación.**

-  **MENÚ PRINCIPAL.**

1. **QUIENES SOMOS**

2. **FUNCIONAMIENTO DEL MENÚ PRINCIPAL.**

3. **MENÚ CLIENTE.**

- **CONSULTAR EL CATÁLOGO DE PRODUCTOS**

- **REALIZAR UN PEDIDO**
  
- **VER MIS PEDIDOS REALIZADOS**

- **VER MIS DATOS PERSONALES**

- **MODIFICAR MIS DATOS PERSONALES**

- **CERRAR SESIÓN**

4. **MENÚ TRABAJADOR.**

- **CONSULTAR LOS PEDIDOS QUE TENGO ASIGNADOS**

- **MODIFICAR EL ESTADO DE UN PEDIDO**

- **CONSULTAR EL CATÁLOGO DE PRODUCTOS**

- **MODIFICAR UN PRODUCTO DEL CATÁLOGO**

- **VER MI PERFIL**

- **MODIFICAR MIS DATOS PERSONALES**

- **CERRAR SESIÓN**

5. **MENÚ DE ADMINISTRADOR.**

- **ASIGNAR UN PEDIDO A UN TRABAJADOR**

- **MODIFICAR EL ESTADO DE UN PEDIDO**

- **DAR DE ALTA UN TRABAJADOR**

- **VER TODOS LOS PEDIDOS**
  
- **VER TODOS LOS TRABAJADORES**
  
- **APAGAR EL SOFTWARE**

6. **CAMBIOS Y FUNCIONALIDADES NUEVAS**




## **0. INSTALACIÓN**

-Para poder ejecutar nuestro programa debemos el instalar la version más reciente del jkd [ jdk 23.0.1 ] (https://download.oracle.com/java/23/latest/jdk-23_windows-x64_bin.exe), debemos empezar la instalación, debemos 
asegurarnos que lo instalamos en **"C:\Program Files\Java"**, después tenemos que entrar en el **"Panel de Control"** (para entrar podemos meternos en "Configuración" y buscamos panel del control)

![image](https://github.com/user-attachments/assets/f6193364-6f7c-443d-b7f9-b6a01bf6d5cb)

(O podemos darle a la tecla Windows y escribir "Panel de Control")
![image](https://github.com/user-attachments/assets/7eb54ca4-a38f-48dc-b25b-54ec6efacbb9)

Al abrir el Panel de Control le daremos al botón de buscar donde escribiremos **"Variables"**
![image](https://github.com/user-attachments/assets/1cb424e3-51e2-4a2c-8118-95ff2a897d60)

-Pincharemos en el **"Editar las variables de entorno del sistema"**

![image](https://github.com/user-attachments/assets/327f9bd8-2033-42b6-ae07-0cdc5c24a018)

Se nos abrirá la siguiente pestaña y le daremos a **"Variables de entorno..."**

![image](https://github.com/user-attachments/assets/45a4f94e-5035-42a8-ba7b-67b8031e67b7)


-En la sección Variables del sistema busque la variable de entorno **PATH** y selecciónela. Haga clic en Editar. Si no existe la variable de entorno PATH haga clic en Nuevo.

-En la ventana **Editar la variable del sistema** (o **Nueva variable del sistema**), debe especificar el valor de la variable de entorno PATH. Haga clic en **Aceptar**. Cierre todas las demás ventanas haciendo clic en **Aceptar**.

-Para la comprobación le daremos a la letra Windows + R y se nos abrirá la pestaña **Ejecutar** y escribiremos el comando **cmd** y le daremos al botón de **Aceptar.**

![image](https://github.com/user-attachments/assets/6a6f6ac9-57ee-4f29-bdd5-757a992775b8)

-Para ver que todo es correcto escribimos el comando **"javac -version"**, si todo sale bien nos saldrá la versión 23.0.1
![image](https://github.com/user-attachments/assets/f6cf704f-6ec5-4ac4-ba5e-2264612b31c5)

-Para ejecutar nuestro programa nos iremos al enlace de GitHub ([https://github.com/jose712020/PracticaObligatoriaT2/tree/main](https://github.com/ManuelJesus2006/Practicaobligatoriatema3)) y le daremos al botón **"<> Code"** donde se desplegará varias opciones, y la 
daremos a **"Download ZIP"**

![image](https://github.com/user-attachments/assets/3a61ba32-6fcb-46ac-8a99-440abf3e57a4)

-Al descargarlo, extraemos la carpeta en la ubicación donde más te convenga, al tenerla extraida nos meteros en la carpeta extraida y nos saldrá lo siguiente, donde ejecutaremos el **"PracticaOT3.bat"** haciendo doble click o dandole click derecho
al ratón y dandole a la opción **"Abrir"**:

![image](https://github.com/user-attachments/assets/321fe0ed-b481-4d98-8578-f18dd15d38c9)


(En caso de que nos salga un pantallazo azul de Windows le daremos a donde ponga más información y le daremos a ejectucar de todas maneras)

![image](https://github.com/user-attachments/assets/7add125c-68b6-417e-899a-45b60eb6a69c)

![image](https://github.com/user-attachments/assets/b305e37c-0cec-4d8e-b70e-a38edcade4d2)


### **MENÚ PRINCIPAL**

-Finalmente tendremos nuestro programa en funcionamiento:

![image](https://github.com/user-attachments/assets/b157f2b3-5f1f-4416-b7d0-2f50b2f36372)



## 1. **QUIENES SOMOS**

Somos un programa que gestionará una tienda online.

-Gestionaremos **tres perfiles** donde tendremos el perfil usuario **"Cliente"**, un perfil **"Trabajador"**, y un perfil **"Administrador"**.


## 2. **FUNCIONAMIENTO DEL MENÚ PRINCIPAL.**

Está es la entrada del programa donde tendremos 2 opciones en nuestro menú principal, donde la **opción 1** será el **Inicio sesión**, donde se podrá meter cualquiera de los 3 perfiles si introduce sus datos correctos.

![image](https://github.com/user-attachments/assets/a19cfaf3-4657-4638-8c83-f47d67775634)

-La **opción 2** será el **Registro**, donde se registrarán los clientes

![image](https://github.com/user-attachments/assets/f55847df-7216-446f-884e-fc4d367fc385)


## 3. **MENÚ CLIENTE.**

- Para acceder tendremos que registrarnos primero en el menú principal en **"Registro"**, una vez hecho eso habremos registrado un cliente.

![image](https://github.com/user-attachments/assets/10609091-59bc-4f89-b09b-4802e115ecfe)

- Ahora que tenemos al Cliente "Jl" registrado podremos iniciar sesión.

![image](https://github.com/user-attachments/assets/d57e969d-e50e-4c4a-bcae-699dc1f49c4e)

![image](https://github.com/user-attachments/assets/93ee66be-f696-427c-b797-70a052836b92)


## **CONSULTAR EL CATÁLOGO DE PRODUCTOS**

- Esta opción nos permitirá ver todos los productos de nuestra tienda.

![image](https://github.com/user-attachments/assets/1fc80949-994d-475e-abea-ec8bbdb0ebfe)


## **REALIZAR UN PEDIDO**

- Realizaremos un pedido con los productos de la tienda, meteremos el producto del catálogo para añadirlo a la cesta (El máximo de productos que podemos añadir a la cesta son 3)

![image](https://github.com/user-attachments/assets/c393febd-c792-491a-a132-faf8b6897b2e)

(He pedido 1 producto)

![image](https://github.com/user-attachments/assets/c2d97c5b-7269-42a6-acdd-ef66c18385f0)

(He pedido 3 productos)

-Como podemos ver a la hora de meter el máximo de productos en la cesta nos dirá que no podemos añadir más productos y el precio a pagar


## **VER MIS PEDIDOS REALIZADOS**

- Podremos ver los pedidos que hayamos realizado.

![image](https://github.com/user-attachments/assets/dc81e7b8-60a7-469b-b37d-62224a1fe9fe)

(En caso de que no hayamos pedido nada)

![image](https://github.com/user-attachments/assets/948bbcf1-7565-4b99-b11c-0e0c8a1e609d)

(Aquí tenemos el ejemplo de los pedidos realizados con "Jl")


## **VER MI DATOS PERSONALES**

- Podremos ver los datos que hayamos introducido en el registro

![image](https://github.com/user-attachments/assets/490df0ac-6016-438f-a25b-a9b8a81244be)

(En mi caso estoy viendo los datos del Cliente "Jl")


## **MODIFICAR MIS DATOS PERSONALES**

- Actualizaremos los datos volviendo a pedir que el cliente introduzca los datos correspondientes

![image](https://github.com/user-attachments/assets/3384a6d3-93e5-43e7-b3e8-6c319ab5b751)

(Actualizaré el perfil "Jl")

- Una vez hayamos introducido los datos pedidos comprobaremos que los datos se han actualizado correctamente, nos meteremos en **"Ver mis datos personales"**

![image](https://github.com/user-attachments/assets/96a24ff7-166d-4b42-bf6c-3e3814e03336)

(Efectivamente todo se ha actualizado tal y como queriamos)


## **CERRAR SESIÓN**

- Aquí dijaremos la sesión cerrada, para **volver a meternos** deberemos a volver a **iniciar sesión en el menú principal.**

![image](https://github.com/user-attachments/assets/8561fd8c-ab80-4480-a0d0-a44b0940d36a)

![image](https://github.com/user-attachments/assets/023f2005-cdd2-46bb-9d35-b33c3a61666d)


## 4. **MENÚ TRABAJADOR.**

El software tiene un cliente ya creado con el nombre de "Carlos" con contraseña "1234", pero los trabajadores solo serán registrados por el administrador, del cual después hablaremos.

- Primero iniciaremos sesión desde el mismo menu principal que los clientes:

![image](https://github.com/user-attachments/assets/b562bd53-f118-4aef-9a56-325b105a0a09)

- Aquí tenemos nuestro menú de trabajador

![image](https://github.com/user-attachments/assets/8764a070-518d-4851-a544-992c94e1b18a)


## **CONSULTAR LOS PEDIDOS QUE TENGO ASIGNADOS**

Aquí el trabajador mira los pedidos que le han asignado desde administración, para demostrar su funcionamiento, haremos que nuestro cliente "Jl" haga un pedido (como ejemplo el ejemplo anteriormente mostrado) y haremos que al administrador se lo asigne a nuestro trabajador (en el apartado de administrador se verá como se asigna)

![image](https://github.com/user-attachments/assets/87a28b0c-0e9a-4b1a-9eb2-9d36d269e5d3)

Una vez asignado volveremos a iniciar sesión en el trabajador cuyo pedido ha sido asignado y le daremos a la opción 1, nos saldrán todos los pedidos asignados, aunque en este caso solo haya uno:

![image](https://github.com/user-attachments/assets/6ab37e44-b0a2-4434-a077-0c56edbdf5ad)
(En el caso de que hayan pedidos)

![image](https://github.com/user-attachments/assets/5401d26b-f8a2-4ddd-b31b-c3e91a5e3d78)
(En el caso de no exista ningún pedido)


## **MODIFICAR EL ESTADO DE UN PEDIDO**

El trabajador también podrá modificar el estado de un pedido, el cual tenga asignado.

- Lo primero será seleccionar la opción 2 en el menú de trabajador:
  
![image](https://github.com/user-attachments/assets/8dc9ecfa-2d0f-486d-9f1a-ae3526150b59)

- Seleccionaremos el pedido a modificar:

![image](https://github.com/user-attachments/assets/e7b4366b-e0ac-4c37-ac1e-32f92f01894c)

- Acto seguido podemos ver que nos sale un menú para poder modificar el estado, al modificarlo nos saldrá una pregunta para ver si queremos agregar una nueva fecha de entrega:

![image](https://github.com/user-attachments/assets/5c66901a-04ad-4ae6-ac01-c51977b66e41)

Si ponemos "N" pasará a una nueva pregunta automáticamente:

![image](https://github.com/user-attachments/assets/550e5491-1c9c-4f78-ae0c-200d506b9eb2)

Si ponemos "S" nos dirá de poner una nueva fecha de entrega en el formato indicado en el software:

![image](https://github.com/user-attachments/assets/a192123f-b31d-4a31-a295-ed4612d77844)

- La siguiente pregunta nos dirá si queremos añadir un comentario:

![image](https://github.com/user-attachments/assets/550e5491-1c9c-4f78-ae0c-200d506b9eb2)

Si ponemos "N" finaliza la modificación:

![image](https://github.com/user-attachments/assets/92fa2251-ebbf-4636-95ca-2598c3b068b7)

Si ponemos "S" nos pedirá un comentario introducido por teclado sobre el pedido en concreto:

![image](https://github.com/user-attachments/assets/9745e6f3-1c9c-4dee-a483-aca8abc5af87)


## **CONSULTAR EL CATÁLOGO DE PRODUCTOS**

Esta opción muestra el catálogo de productos existentes:

![image](https://github.com/user-attachments/assets/ff861a5d-92f7-4d91-8aa5-f2060e75a5db)


## **MODIFICAR UN PRODUCTO DEL CATÁLOGO**

El trabajador puede modificar un producto del catálogo, ya sea su nombre y precio

- Al introducir la opción 4, no pedirá el número del producto en el catálogo:

![image](https://github.com/user-attachments/assets/bd901796-dac8-4912-b171-ee445e52edca)

- Introducidos un producto de prueba (el número 8) y automáticamente nos pide un nombre nuevo o la opción "no" para dejar el mismo nombre:

![image](https://github.com/user-attachments/assets/8fd21672-42df-4c4a-8d3d-82182ad81d9c)

- Después de realizar la operación del cambio de nombre, nos aparece si deseamos cambiar el precio del producto o "-1" para dejar el mismo precio

![image](https://github.com/user-attachments/assets/8069b827-8e89-41e4-8e39-39c82a1f3c88)

Una vez finalizada la modificación revisamos si se han cambiado los datos en el producto 8, consultando el catálogo y vemos que funciona:

![image](https://github.com/user-attachments/assets/ff861a5d-92f7-4d91-8aa5-f2060e75a5db)(antes)

![image](https://github.com/user-attachments/assets/19c26a45-0a5f-411c-8b42-c1cf58ff5d8c)
(después)


## **VER MI PERFIL**

El trabajador puede ver su perfil con su usuario y contraseña:

![image](https://github.com/user-attachments/assets/e3468580-43d8-4a61-ae6a-1f7c88e13982)


## **MODIFICAR MIS DATOS PERSONALES**

En esta opción el trabajador cambiar sus datos personales, en este caso su nombre de usuario y contraseña

- Seleccionamos la opción 6 y nos pedirá un nombre nuevo:

![image](https://github.com/user-attachments/assets/9866909b-8492-4310-b695-67570a6309a4)

- Después de ello nos pide una nueva contraseña:

![image](https://github.com/user-attachments/assets/821b8d20-7c72-4cb5-b3d7-0cf5e63ee243)

Comprobamos que ha funcionado solicitando ver el perfil y vemos que también se han cambiado los datos incluso al iniciar sesión

![image](https://github.com/user-attachments/assets/461d7000-c53d-4e88-aa21-6c6c6aee19a9)
(Viendo el perfil)

![image](https://github.com/user-attachments/assets/8f4edb3a-f070-45d0-a992-c1ed6a2b7e9a)
(Iniciando sesión)


## **CERRAR SESIÓN**

- Aquí dijaremos la sesión cerrada en el trabajador, para **volver a meternos** deberemos a volver a **iniciar sesión en el menú principal.**

![image](https://github.com/user-attachments/assets/ccb371a5-1b40-4957-adca-c04a5c1f406f)


## 5. **MENÚ ADMINISTRADOR.**

El software tiene un Administrador ya creado con el nombre de **"Admin"** con contraseña "root".

![image](https://github.com/user-attachments/assets/2ec8b01a-e355-4eb1-91e2-72e47104405f)


## **ASIGNAR UN PEDIDO A UN TRABAJADOR**

En esta opción le asignaremos un pedido a los trabajadores que haya disponibles

![image](https://github.com/user-attachments/assets/1d88f69e-9ef5-49db-8186-35d2b31f9984)

(Como podemos observar tenemos 3 pedidos ahora vamos a elegir uno)

![image](https://github.com/user-attachments/assets/6e386a1c-5698-4175-a906-cec6fee9250e)

Una vez hecho eso Manule ya tendrá el pedido asignado

![image](https://github.com/user-attachments/assets/eb8f6417-970c-4cd2-81fa-eb4ba0687bec)


- **MODIFICAR EL ESTADO DE UN PEDIDO**

Aquí podremos actualizar el estado de un pedido

![image](https://github.com/user-attachments/assets/70e218e4-1eb9-4a5e-8fed-db178b3cf50b)

- Hemos elegido 1 de los 3 pedidos que habñia, el pedido de primeras saldrá "Sin Estado", así que le asignaremos un estado

![image](https://github.com/user-attachments/assets/f7e1dbe3-450c-4b3b-b97d-ed539bf12a37)

Como podemos observar aparte de añadir un estado. también podremos modificarle la fecha, la dirección y añadir un comentario

Veamos si se ha actualizado todo:

![image](https://github.com/user-attachments/assets/43637e19-cfe3-4187-a55b-5bc17258f315)

(Efectivamnte funciona)
  
## **DAR DE ALTA UN TRABAJADOR**

Podremos dar de alta a los trabajadores con esta opción, veamos como funciona.

![image](https://github.com/user-attachments/assets/0ef148c0-2031-4931-9144-105146d6749c)

- Añadimos un trabajador asignandole un nombre y una clave

Pero este programa tiene un límite de trabajadores (unos 3)

![image](https://github.com/user-attachments/assets/7720a2d6-5991-405d-ba61-0414f59a57a4)

- Una vez creado los 3 trabajadores veamos si podemos añadirle un cuarto trabajador

 ![image](https://github.com/user-attachments/assets/98a3f77c-9944-4499-8965-8ccafaabb164)

- Efectivamente hemos llegado al límite de trabajadores


## **VER TODOS LOS PEDIDOS**

-Aquí podremos ver todos los pedidos que han hecho los clientes

![image](https://github.com/user-attachments/assets/ef57fade-5e5b-41a9-b9e8-2fbe1037c0f7)

(Aquí un ejemplo de si un primer cliente se registra y no ha realizado pedidos)

![image](https://github.com/user-attachments/assets/90e593ff-90b5-473a-95fc-0c5985c0692d)

(Aquí un ejemplo con el cliente "Jose" y sin cliente 2)

- Ahora vamos a registrar a un cliente nuevo.

![image](https://github.com/user-attachments/assets/9c6bf995-1ca7-44ed-ab4a-314841cd0d66)

- Vamos a realizar un pedido con "Edu"

![image](https://github.com/user-attachments/assets/0f0f666f-3a0f-4489-a79b-3958573564d3)

![image](https://github.com/user-attachments/assets/f99159d1-a98d-44e1-a913-77de052e7be3)


(Funciona correctamente) 


## **VER TODOS LOS CLIENTES**

- Aquí podremos ver a todos los clientes registrados.

![image](https://github.com/user-attachments/assets/5634cafc-61df-423c-ab67-a8aced52217b)

(Aquí podemos ver al cliente "Jose")

![image](https://github.com/user-attachments/assets/baae247b-5b2a-446d-92c8-2f34b8d273e6)

(Como podemos observar ha funcionado correctamente)


## **VER TODOS LOS TRABAJADORES**

- Aquí podremos ver a todos los trabajadores dado de alta.

Veamos con 1 trabajador lo que muestra

![image](https://github.com/user-attachments/assets/6a4c8bb6-ff2e-4f76-a5b3-8ead9297bfd1)

Y ahora veamos con 3 trabajadores

![image](https://github.com/user-attachments/assets/4bde3961-8e68-4631-9eb8-3eaa2c6310e3)

Efectivamente muestra a sus trabajadores con sus respectivos datos.


## **CERRAR SESIÓN**

- Aquí dijaremos la sesión cerrada en el administrador, para **volver a meternos** deberemos a volver a **iniciar sesión en el menú principal.**

![image](https://github.com/user-attachments/assets/4f3d36f3-6019-45d0-852d-cf0def41efe4)



## 6. **CAMBIOS Y FUNCIONALIDADES NUEVAS**

## **PORTADA**

Una de las cosas que hemos decidido mejorar es que no teniamos una presentación decente, ahora este es nuestra nueva portada:

![image](https://github.com/user-attachments/assets/a5341e7e-acd8-4a27-b27c-9aaa7040932e)

## **CATÁLOGO**

Hemos decidido cambiar nuestra idología y ahora tenemos un nuevo catálogo que esperemos que os guste:
![image](https://github.com/user-attachments/assets/50e4102b-3789-4da5-b9f2-4aa148e335f5)


## **IMPLANTACIÓN DE CORREOS ELECTRÓNICOS**

Una de las funcionalidades más importantes es la implantación de correos electrónicos en el software, ocurrira en diferentes casos:
- **Durante el registro para generar un token para activar la cuenta registrada**
- **Cuando un trabajador o administrador modifique un pedido realizado**
- **Cuando el administrador asigna a un trabajador un pedido, este lo recibirán solo los trabajadores**

## **SEGURIDAD AL REGISTRARTE**

Nos hemos fijado que cualquier cosa que metieras en el correo funcionaba, así que hemos mejorado la implementación de correos:

![image](https://github.com/user-attachments/assets/c1168e46-937b-4a4c-b54c-797cba3fe36a)

Lo mismo hemos aplicado con los números de teléfono, etc...

![image](https://github.com/user-attachments/assets/0bbec500-5662-4629-9414-96f32a8e7ce5)


- ## **CORREO DE REGISTRO (TOKEN) Y SEGURIDAD**

Una vez nos hayamos registrado, miraremos nuestra bandeja del correo y veremos que nos ha llegado un correo:
  
![image](https://github.com/user-attachments/assets/888905c5-42ba-4936-abbd-6c52f1af21c2)


Esta vez en vez de poder acceder a nuestra cuenta directamente, se necesitará una validación del token que nos ha llegado a nuestro correo electrónico para poder iniciar sesión:

![image](https://github.com/user-attachments/assets/16e85e2e-475f-4419-b1f7-43dad198ee2d)


Si introducimos un token incorrecto, nos lo hará saber y nos llevará de vuelta al inicio de nuestro software:

![image](https://github.com/user-attachments/assets/2d0ecabd-03be-45fc-b923-c2bc0fcc11da)

![image](https://github.com/user-attachments/assets/52761444-37e5-49f4-a08c-7173e527037a)


Sin embargo si ponemos el token que nos aparece en el correo ya nos dejará acceder:

![image](https://github.com/user-attachments/assets/4de765fc-7e45-4fd1-ada7-0acf6c853f4e)

![image](https://github.com/user-attachments/assets/f993473a-21ad-4733-b959-e4edcd92dfa7)


**MODIFICACIÓN DE DATOS**

Por seguridad cuando modifiquemos nuestros datos, se nos enviará un nuevo token al correo:
![image](https://github.com/user-attachments/assets/56fd21f2-0da6-473d-b3bf-160d5b12a382)

![image](https://github.com/user-attachments/assets/45dcaf84-d72c-455f-b8ab-3bf7d1dc432b)


Y volveremos a tener la petición del token, en caso de introducirlo mal, se nos cerrará la sesión y volveremos al programa principal:

![image](https://github.com/user-attachments/assets/3938bc35-3a19-410f-9078-21aac58b54ae)

![image](https://github.com/user-attachments/assets/9c3e65c6-ff6c-40df-a4f4-598f9178f214)

Al introducir el token válido nos llevará al programa con nuestros datos modificados:

![image](https://github.com/user-attachments/assets/7047764a-1e88-44cc-8034-f9be2a9283ee)

![image](https://github.com/user-attachments/assets/53c6fe1e-e384-4d29-a956-01b6752afd99)

Y ahora todos nuestros datos se han modificado:

![image](https://github.com/user-attachments/assets/80bec104-aef6-4a1b-81fb-8c916020beb9)


Lo mismo con el perfil de Trabajadores: 

![image](https://github.com/user-attachments/assets/69634f7b-fff2-4834-854e-85a9bcc7ef3e)

Miraremos el correo:

![image](https://github.com/user-attachments/assets/e1608056-a936-44bd-b2ed-d4b732cc9867)

![image](https://github.com/user-attachments/assets/5b833120-8f97-496f-b4dd-163dd3ef8788)

Y una vez introducido el token válido entraremos al menú con nuestro perfil actualizado:

![image](https://github.com/user-attachments/assets/ef604681-ab6c-4ea3-a912-e4961be5185f)


