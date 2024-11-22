#Ejercicio 1

#Creamos una lista para asignaturas
asignaturas=["Matemáticas", "Fisica", "Quimica", "Historia", "Lengua"]

#Iteramos sobre la lista y la sacamos por consola
for asignatura in asignaturas:
    print(asignatura)
print()

#Ejercicio 2

#Creamos una lista para asignaturas
asignaturas=["Matemáticas", "Fisica", "Quimica", "Historia", "Lengua"]

#Iteramos sobre la lista y la sacamos por consola
for asignatura in asignaturas:
    print(f"Yo estudio {asignatura}")

print()
#Ejercicio 3

#Creamos una lista para asignaturas
asignaturas=["Matemáticas", "Fisica", "Quimica", "Historia", "Lengua"]

#Creamos una lista para notas
notas=[]

#Iteramos sobre la lista y creamos un bucle while por si alguna nota no es valida que la siga pidiendo
for asignatura in asignaturas:
    notasValidas=False
    while not notasValidas:
        notasAsignaturas=int(input(f"Introduzca la nota de la asignatura de {asignatura}: "))
        if 0<= notasAsignaturas <=10:
            #Nos añadira las notas a la lista si se cumplen las condiciones
            notas.append(notasAsignaturas)
            notasValidas=True
        else:
         print(f"La nota de la asignatura {asignatura} no es valida la nota tiene un valor de 0 a 10 ")
       
print()
#Sacamos por consola las notas
for i in range(len (asignaturas)):
        print(f"En la asignatura de {asignaturas[i]} has sacado {notas[i]}")
       

print()

#Ejercicio 4

#Creamos una lista para loterias
loteria=[]
num=5

#Iteramos sobre la lista y creamos un bucle while por si algun numero no es valido que lo siga pidiendo
for i in range (num):
    numerosValidos=False
    while not numerosValidos:
        numeros=int(input("Introduzca los 5 numeros ganadores de la primitiva: "))
        if 0<=numeros<100:
            #Nos añadira los numeros a la lista si se cumplen las condiciones
            loteria.append(numeros)
            numerosValidos=True
        else:
            print("Los numeros tiene un valor de 0 a 99")
        #Ordenamos la lista 
        loteria.sort()
#Sacamos la lista por consola
print(loteria)
print()


#Ejercicio 5

#Creamos una lista para numeros
numeros=[1,2,3,4,5,6,7,8,9,10]
#Los ordenamos en orden inverso
numeros.reverse()

#Sacamos por consola separado por comas
print(",".join(str(i)for i in numeros))

print()


#Ejercicio 6

#Creamos una lista para numeros
asignaturas=["Matemáticas", "Fisica", "Quimica", "Historia", "Lengua"]

#Creamos una lista para notas
notas=[]

#Iteramos sobre la lista y creamos un bucle while por si alguna nota no es valida que la siga pidiendo
for i in range(len(asignaturas)):
    notasValidas=False
    while not notasValidas:
        notasAsignaturas=int(input(f"Introduzca la nota de la asignatura de {asignaturas[i]}: "))
        if 0<= notasAsignaturas<=10:
            #Nos añadira las notas a la lista si se cumplen las condiciones
            notas.append(notasAsignaturas)
            notasValidas=True
        else:
             print(f"La nota de la asignatura {asignatura} no es valida la nota tiene un valor de 0 a 10 ")

#Eliminaremos las asignaturas que esten aprobados de la lista  
for i in range(len(asignaturas)-1, -1, -1):  
    if notas[i] >= 5:
        asignaturas.remove(asignaturas[i])

#Iteramos sobre la lista y la sacamos por consola
for asignatura in asignaturas:    
    print(f"Has suspendido {asignatura}")
print()
#Ejercicio 7

#Creamos una lista de abecedario
abecedario= ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']

#Eliminamos las letras que sean multiplo de 3
for i in range(len(abecedario) -1,-1,-1):
    
    #La posicion de z no es multiplo de 3, ya que z esta en la posicion 26
    if i % 3 == 0 or i==26:
        abecedario.pop(i)

#Sacamos por consola
print(abecedario)
print()
#Ejercicio 8

#Creamos una lista de numeros
numeros=[49, 73, 64, 20, 88, 66, 38]

#Con esta funcion cogera el numero mas pequeño
min=min(numeros)

#Con esta funcion cogera el numero mas grande
max=max(numeros)

#Sacamos por consola
print(f"El numero minimo es {min}")
print(f"El numero maximo es {max}")
print()
#Ejercicio 9
contandor=0
palabra=str(input("Introduzca una palabra: "))
#Creamos dos listas para letras y contador
letras=['a','e','i','o','u']
contador=[0,0,0,0,0]

#Iteramos sobre la lista y si se cumplen las condiciones se sumara uno
for letra in palabra:
    if letra in letras:
        indice = letras.index(letra)
        contador[indice] += 1

#Iteramos sobre la lista y la sacamos por consola
for i in range(len(letras)):
    print(f"La vocal '{letras[i]}' aparece {contador[i]} veces.")
print()    

#Ejercicio 10

#Creamos dos listas para num y num2
num=[1,2,3]
num2=[-1,0,2]
producto_escalar = 0

#Iteramos sobre la lista num para calcular su producto escalar
for i in range(len(num)):
    producto_escalar += num[i] * num2[i]

#Sacamos por consola
print(f"El producto escalar es {producto_escalar}")
print()

#Ejercicio 11

num=5
#Creamos una lista para numeros
numeros=[]

#Iteramos sobre la lista num para introducir numeros 
for i in range(num):
    numero=int(input("Introduzca un numero: "))
    #Nos añadira los numeros a la lista 
    numeros.append(numero)

#Calculamos su media 
media=sum(numeros)/len(numeros)

#Sacamos por consola
print(f"La media es {media:.2f}")

#Calculamos su desviacion tipica
suma_cuadrados = sum((x - media) ** 2 for x in numeros)
desviacion_tipica = (suma_cuadrados / len(numeros)) ** 0.5

#Sacamos por consola
print(f"La desviacion tipica es {desviacion_tipica:.2f}")




