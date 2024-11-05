#Ejercicio 1
nombre=(input("Introduce tu nombre: "))
edad=int(input("Introduce tu edad: "))
print(f"Hola {nombre} ")
if edad>=18:
 print(f"\nBuenos dias, {nombre}. tiene {edad} y es mayor de edad")

else: print(f"\nBuenos dias, {nombre}. tiene {edad} y es menor de edad")

# Ejercicio 2
contraseñaGuardada="21Malas"
contraseñaUsuario=input("Introduce la contraseña: ")
if contraseñaGuardada.lower()==contraseñaUsuario.lower():
    print("La contraseña es correcta")
else:print("La contraseña no es correcta")

# Ejercicio 3
num=float(input("Introduzca un dividiendo: "))
num2=float(input("Introduzca un divisor: "))
if num2==0:
    print("Error No se puede dividir entre cero")
else:
    division=num/num2
    print(f"La division es {division}")

# Ejercicio 4
num=int(input("Introduzca un numero: "))
if num%2==0:
    print(f"El numero {num} es par")
else:print(f"El numero {num} es impar")

# Ejercicio 5

edad=int(input("Introduzca su edad: "))
ingresosMensuales=float(input("Introduzca sus ingresos mensuales: "))
if edad>16 and ingresosMensuales >=1000:
    print("Lo siento tienes que tributar")
else:print("Enhorabuena no tienes que tributar")

# Ejercicio 6
rentaAnual=float(input("Introduzca su renta anual: "))


if rentaAnual < 10000:
    tipo_impositivo = 5
elif 10000 <= rentaAnual < 20000:
    tipo_impositivo = 15
elif 20000 <= rentaAnual < 35000:
    tipo_impositivo = 20
elif 35000 <= rentaAnual < 60000:
    tipo_impositivo = 30
else:  # renta >= 60000
    tipo_impositivo = 45

print(f"Tu tipo impositivo correspondiente es del {tipo_impositivo}%.")

# Ejercicio 7
puntuacion = float(input("Introduce tu puntuación (0.0, 0.4 o 0.6 o más): "))

cantidad_base = 2400

if puntuacion < 0:
    print("Error: La puntuación no puede ser negativa.")
elif puntuacion == 0.0:
    nivel = "Inaceptable"
    print({nivel})
    cantidad_recibir = cantidad_base * puntuacion
elif puntuacion == 0.4:   
    nivel = "Aceptable"
    print({nivel})
 
    cantidad_recibir = cantidad_base * puntuacion
elif puntuacion >= 0.6:
    nivel = "Meritorio"
    print({nivel})
    cantidad_recibir = cantidad_base * puntuacion
else:
    nivel = None  #
    cantidad_recibir = 0


if puntuacion>=0 and nivel:
    print(f"Tu nivel de rendimiento es: {nivel}.")
    print(f"Cantidad de dinero que recibirás: {cantidad_recibir}€.")
else:
    print("Puntuación no válida. Debe ser 0.0, 0.4 o 0.6 o más.")


# Ejercicio 8
num=int(input("Introduzca un numero:"))
num2=int(input("Introduzca un numero:"))
if(num>num2):
    print(f"{num} es mayor que {num2}")
elif num==num2:
    print(f"{num} y {num2} Son iguales")
else:print(f"{num2} es mayor que {num}")

# Ejercicio 9
edad=int(input("Introduzca su edad: "))
if edad<0:
    print("Error introduzca una edad valida ")
elif 0>=edad <4:
    precio=0
    print("Entrada gratis")
elif 4<=edad<=18  :
    precio=5
    print(f"Entrada {precio}€")
elif edad>18:
    precio=10
    print(f"Entrada {precio}€")


