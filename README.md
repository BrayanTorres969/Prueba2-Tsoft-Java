# Prueba 2 Tsoft Java
Esta prueba es evaluación nro 2 del curso de Java
##  Diagrama de clases
Se pide implementar la siguiente jerarquía la cual representa a una empresa de turismo:

<img src="https://github.com/BrayanTorres969/Prueba2-Tsoft-Java/assets/142279812/f38dc397-c105-4e20-b188-bf845b56b0cd" width="50%" height="50%">

## Requerimientos
La información que se tiene es:
- DatosCliente tiene nombre y rut del cliente.
- Carpa tiene valorBaseNoche, cantidad de noches, DatosCliente y tipoTemporada (alta, media o baja) y
cantidadPersonas.
- Cabagna tiene capacidad, tipoTemporada (alta, media o baja), DatosCliente, valorBaseNoche, esFumador
(boolean), cantidad de noches y chimenea (boolean).
- Hotel tiene conDesayuno (boolean), DatosCliente, capacidad, cantidad de noches, tipoTemporada (alta,
media o baja), esFumador (boolean) y valorBaseNoche.

Además, se necesita contar con los siguientes métodos:

- subtotal: devolverá el subtotal a cancelar el cual será cantidad de noches por el valorBaseNoche.
- adicional: devolverá el valor adicional, que corresponde al 30% del subtotal si es Fumador y con desayuno.
- bonoDescuento: devolverá el valor a descontar sabiendo que es un 25% del subTotal si el tipo de temporada es baja o es de un 12.5% si el tipo Temporada es media.
- valorACancelar: devolverá el valor a cancelar, el cual al subtotal se le debe descontar el bono y sumar el adicional, donde corresponda.
- incrementaValorBase: aumenta el valor base en un 18% si la capacidad de la cabaña es superior a 5.

Usando una colección, implementar una aplicación que permita:

1. Ingresar Medio de Alojamiento (almacena un objeto de tipo Carpa/Cabaña/Hotel en la colección, siempre que no exista, es decir solo se puede asociar un cliente por medio de alojamiento.)
2. Mostrar medios de alojamiento (muestra datos de todos los objetos almacenados)
3. Datos de un cliente X (si existe, muestra donde está alojado y todos los datos asociados)
4. Total adicional.
5. Total bono descueto.
6. Cantidad de medios de alojamientos X.
7. Valor a cancelar por un cliente X (el cliente debe existir).
8. Aplicar incremento de valor base (donde corresponda).
9. Salir.

Nota: Implemente una controladora


