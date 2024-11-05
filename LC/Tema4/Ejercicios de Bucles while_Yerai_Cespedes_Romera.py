# Ejercicio 1

palabra =str(input("Introduzca una palabra: "))
contador=0
while contador<10:
    print(palabra)
    contador+=1

# Ejercicio 2


edad=int(input("Introduzca su edad: "))
contador=1
while contador<=edad:
    print(contador)
    contador+=1

# Ejercicio 3

num=int(input("Introduzca un numero: "))
contador=1
while contador<num:
    if contador % 2 != 0:
        print(contador,end=",")
        contador+=1
    else:
        contador+=1
   
       
        
    
    
# Ejercicio 4

num=int(input("\nIntroduzca un numero: "))
posicion=num
while posicion>=0:  
    print(posicion,end=",")
    posicion-=1
  
    
    

# Ejercicio 5 

inversion=float(input("\n¿Que cantidad desea invertir? "))
interesAnual=int(input("¿Cual es el interes anual? "))/100
años=int(input("¿Cuantos años desea? "))
contador=1
while años>= contador:
    capitalObtenido=inversion * (1 + interesAnual) ** contador
    print(f"Año { contador}: {capitalObtenido:.2f}")
    contador+=1
   

# Ejercicio 6

num=int(input("Introduzca un numero: "))
contador=0
while num>contador:
    contador+=1
    print("*"*contador)

# Ejercicio 7

num=1

while num<=10:
    multiplicador=1
    print(f"Tabla del numero {num}")
    while multiplicador<=10:
        print(f"{num} x {multiplicador} = {num*multiplicador}")
        multiplicador+=1
    print()
    num+=1


# Ejercicio 8

palabra=str(input("Introduzca una palabra "))
posicion=len(palabra)-1
while posicion>=0:
    print(palabra[posicion])
    posicion-=1

# Ejercicio 9


contraseña = "soyProgramador"
contraseñaAcertada = False  
contador = 0  

while not contraseñaAcertada:
    contraseñaInsertada = input("Introduzca su contraseña: ")  
    contador += 1 
    
    if contraseña.lower() == contraseñaInsertada.lower():
        contraseñaAcertada = True  
        print(f"La contraseña es correcta, has necesitado {contador} intentos.")
    else:
        print("La contraseña es incorrecta.")

# Ejercicio 10
num = int(input("Introduzca un número: "))

esPrimo = True

if num <= 1:
    esPrimo = False 
else:
    i = 2
    while i * i <= num: 
        if num % i == 0:
            esPrimo = False
          
        i += 1  
if esPrimo:
    print(f"El número {num} es primo.")
else:
    print(f"El número {num} no es primo.")

# Ejercicio 11

frase=str(input("Introduzca una frase: "))
letra=str(input("Introduzca una letra: "))
if len(letra) != 1:
    print("Por favor, introduce solo una letra.")
else:
    contador = 0
    posicion = 0

    while posicion < len(frase):
        if frase[posicion].lower() == letra.lower():
            contador += 1
        posicion+= 1

    print(f"La letra '{letra}' aparece {contador} veces en la frase.")

# Ejercicio 12

objetivo=float(input("¿Cuanto euros quieres ahorrar? :"))
dineroAhorrado=0
while dineroAhorrado<objetivo:
    cantidad=float(input("¿Cuántos euros quiere meter en la hucha?: "))
    dineroAhorrado+=cantidad


print(f"¡Objetivo conseguido! Ha ahorrado usted {dineroAhorrado} euros.")


 


   