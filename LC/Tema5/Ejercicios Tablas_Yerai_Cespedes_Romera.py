#Ejercicio 1

asignaturas=["Matemáticas", "Fisica", "Quimica", "Historia", "Lengua"]
print(asignaturas)

#Ejercicio 2
asignaturas=["Matemáticas", "Fisica", "Quimica", "Historia", "Lengua"]
for asignatura in asignaturas:
    print(f"Yo estudio {asignatura}")


#Ejercicio 3
asignaturas=["Matemáticas", "Fisica", "Quimica", "Historia", "Lengua"]
notas=[]
for asignatura in asignaturas:
    notasAsignaturas=int(input(f"Introduzca la nota de la asignatura de {asignatura}: "))
    notas.append(notasAsignaturas)

for i in range(len (asignaturas)):
    print(f"En la asignatura de {asignaturas[i]} has sacado {notas[i]}")
   



#Ejercicio 4

loteria=[]
num=5
for i in range (num):
    numeros=int(input("Introduzca los numeros ganadores: "))
    loteria.append(numeros)
    loteria.sort()
print(loteria)

#Ejercicio 5

numeros=[1,2,3,4,5,6,7,8,9,10]
numeros.reverse()
print(numeros,end=",")
#Ejercicio 6
asignaturas=["Matemáticas", "Fisica", "Quimica", "Historia", "Lengua"]
notas=[]

for i in range(len(asignaturas)):
    notasAsignaturas=int(input(f"Introduzca la nota de la asignatura de {asignaturas[i]}: "))
    notas.append(notasAsignaturas)
    
for i in range(len(asignaturas)-1, -1, -1):  
    if notas[i] >= 5:
        asignaturas.remove(asignaturas[i])
     
print(asignaturas)

#Ejercicio 7
abecedario= ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
for i in range(len(abecedario) - 1, -1, -1):
    if (i + 1) % 3 == 0:
        del abecedario[i]

print(abecedario)

#Ejercicio 8

numeros=[49, 73, 64, 20, 88, 66, 38]
min=min(numeros)
max=max(numeros)
print(f"El numero minimo es {min}")
print(f"El numero maximo es {max}")

#Ejercicio 9
contandor=0
palabra=str(input("Introduzca una palabra: "))
letras=['a','e','i','o','u']
contador=[0,0,0,0,0]

for letra in palabra:
    if letra in letras:
        indice = letras.index(letra)
        contador[indice] += 1
for i in range(len(letras)):
    print(f"La vocal '{letras[i]}' aparece {contador[i]} veces.")
    

#Ejercicio 10

num=[1,2,3]
num2=[-1,0,2]
producto_escalar = 0

for i in range(len(num)):
    producto_escalar += num[i] * num2[i]

print(f"El producto escalar es {producto_escalar}")


#Ejercicio 11

num=5
numeros=[]

for i in range(num):
    numero=int(input("Introduzca un numero: "))
    numeros.append(numero)

media=sum(numeros)/len(numeros)
print(f"La media es {media:.2f}")

suma_cuadrados = sum((x - media) ** 2 for x in numeros)
desviacion_tipica = (suma_cuadrados / len(numeros)) ** 0.5

print(f"La desviacion tipica es {desviacion_tipica:.2f}")




