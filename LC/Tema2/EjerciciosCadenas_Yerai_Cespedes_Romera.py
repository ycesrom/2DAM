#Ejercicio 1
nombre=str( input("Introduzca su nombre "))
nVeces=int(input("Introduzca un numero "))

for _ in range(nVeces):
    print(nombre)

#Ejercicio 2

nombreCompleto=str(input("Introduzca su nombre completo "))
print(nombreCompleto.lower())
print(nombreCompleto.upper())
print(nombreCompleto.title())

#Ejercicio 3

nombre=str(input("Introduzca su nombre "))
print(nombre.upper())
letras=len(nombre)
print(f"Tu nombre es {nombre} y tiene {letras}  letras")

#Ejercicio 4

telefono=str(input("Introduzca su telefono como en este ejemplo (+34-913724710-56) "))
partes=telefono.split("-")
telefonoSinPrefijo=partes[1]
print(telefonoSinPrefijo)

#Ejercicio 5

frase=str(input("Introduzca una frase "))
fraseInvertida=frase[::-1]
print(fraseInvertida)

#Ejercicio 6
frase=str(input("Introduzca una frase con vocal "))
vocal=str(input("Introduzca la vocal que quieres que sea mayuscula "))
frase_modificada = frase.replace(vocal, vocal.upper())
print(frase_modificada)
#Ejercicio 7

correo=str(input("Introduzca su email"))
nuevoCorreo = correo.replace(correo.split('@')[1], 'murgi.org')
print(nuevoCorreo)

#Ejercicio 8
producto=str(input("Introduzca el precio el precio de la PS5 con dos decimales"))
euros,centimos=producto.split(".")
euros_str=int(euros)
centimos_str=int(centimos)
print(f"{euros_str} euros y {centimos_str} centimos")



#Ejercicio 9

fechaNacimiento=str(input("Introduce la fecha de tu nacimiento en formato dd/mm/aaaa: 16/09/2023 "))
fecha=fechaNacimiento.split("/")
print("Dia Introducido: "+fecha[0])
print("Mes introducido: "+fecha[1])
print("Año introducido: "+fecha[2])


#Ejercicio 10

cesta=str(input("Introduce los productos de la cesta de la compra separados por comas: "))
productos=cesta.split(",")
print("La lista de la compra está formada por: ")
for i in productos:
    print(i)

#Ejercicio 11

nombreProducto=str(input("Cual es el nombre del producto "))
precioUnidad=float(input("Cual es el precio por unidad "))
numeroUnidades=int(input("Cual es el numero de unidades "))
costeTotal=precioUnidad*numeroUnidades
print(f"{nombreProducto}: {precioUnidad:6.2f} € por unidad, {numeroUnidades:3d} unidades, coste total: {costeTotal:8.2f} €")
