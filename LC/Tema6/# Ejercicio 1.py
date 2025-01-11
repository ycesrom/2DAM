# Ejercicio 1

divisas={'Euro':'€', 
'Dollar':'$', 'Yen':'¥'}
divisa = str(input("Introduzca una divisa "))
if divisa in divisas:
    print(f"El símbolo de {divisa} es: {divisas[divisa]}")
else:
    print("La divisa no está en el diccionario.")
    
# Ejercicio 2

nombre=str(input("Introduce tu nombre "))
edad=str(input("Introduce tu edad "))
direccion=str(input("Introduce tu direccion"))
telefono=str(input("Introduce tu telefono"))

d1=dict(nombre=nombre ,edad = edad , direccion=direccion,telefono=telefono)

print(f"{d1['nombre']} tiene {d1['edad']} años, vive en {d1['direccion']} y su número de teléfono es {d1['telefono']}.")

# Ejercicio 3

fruta={'Platano':1.35,'Manzana':0.80,'Pera':0.85,'Naranja':0.70}
nFruta=str(input("Introduzca la fruta que desee "))
nKilos=float(input("Introduzca el numero de kilos que desee "))
if nFruta in fruta:
    precioKilo = fruta[nFruta]
    precioTotal = precioKilo * nKilos
    print(f"El precio de {nFruta} es: {precioTotal}")
print(fruta)