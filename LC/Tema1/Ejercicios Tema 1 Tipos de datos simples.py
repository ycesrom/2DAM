# Ejercicio 1

print("Hola Mundo")

# Ejercicio 2

instituto="¡IES Murgi!"
print(instituto)

# Ejercicio 3

nombre=input(("Ingrese su nombre: "))
print(" ¡Hola "+nombre+"!")

# Ejercicio 4

operacion=(3+2)/(2*5)
final=operacion**2
print(final)

# Ejercicio 5

horas=int(input("Introduzca el numero de horas trabajadas "))
coste=float(input("Introduzca el coste por hora "))
pago=horas*coste
print("Su salario es de ",pago)

# Ejercicio 6

num=int(input("Introduzca un numero "))
suma = num* (num + 1) / 2
print(f" La suma de 1 hasta {num} es {suma}")

# Ejercicio 7

peso=float(input("Introduzca su peso en kilogramos (kg) "))
metros=float(input("Introduzca su altura en metros "))

imc=peso/pow(metros,2)
print(f" Su indice de IMC es {imc} ")

# Ejercicio 8

n=int(input("Introduzca un numero "))
m=int(input("Introduzca un numero "))

c= n//m
print(f"El cociente es {c}")
r=n%m
print(f"El resto es {r}")

# Ejercicio 9 

inversion= int(input("Introduzca la cantidad a invertir "))
interes=float(input("Introduzca el tipo de interes"))
años=int(input("Introduzca el numero de años de la inversion "))
n=interes/100
capital=inversion*(1+n)**años
print(f" Su capital ahora es de {capital:.2f}")

# Ejercicio 10


nPayasos=int (input("Introduzca el numero de payasos vendidos"))
nMuñecas=int (input("Introduzca el numero de muñecas vendidos"))
pesoPayasos=112*nPayasos
pesoMuñecas=75*nMuñecas
pesoTotal=pesoPayasos+pesoMuñecas
print(f"El peso total de todos los paquetes es {pesoTotal} gramos")

# Ejercicio 11


inversion= int(input("Introduzca la cantidad a invertir "))
interes=4
n=interes/100
capitalPrimerAño=inversion*(1+n)**1
capitalSegundoAño=inversion*(1+n)**2
capitalTercerAño=inversion*(1+n)**3

print(f" Su capital del 1ºAño es de {capitalPrimerAño:.2f}")
print(f" Su capital del 2ºAño es de {capitalSegundoAño:.2f}")
print(f" Su capital del 3ºAño es de {capitalTercerAño:.2f}")

# Ejercicio 12

barrasPan=3.49

barrasAyer=int (input("Introduzca el numero de barras que no se hayan vendido"))
descuentoPan=3.49*(60/100)
precioFinal=(barrasPan-descuentoPan)*barrasAyer
print(f"Precio Normal {barrasPan}")
print(f"Descuento al no ser fresca {descuentoPan:.2f}")
print(f"Precio Total {precioFinal:.2f}")