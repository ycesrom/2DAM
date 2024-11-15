# Ejercicio 1

for i in range(1,11,1):
    print(f"{i}\t",end="")
print()

for i in range(2,21,2):
    print(f"{i}\t",end="")
print()

for i in range(20,48,3):
    print(f"{i}\t",end="")
print()

for i in range(10,31,4):
    print(f"{i}\t",end="")
print()

for i in range(40,-1,-5):
    print(f"{i}\t",end="")
print()
print()


# Ejercicio 2

for i in range(1,11):
    print(f"{i}\t",end="")
print()

for i in range(2,21):
    if i%2==0:
        print(f"{i}\t",end="")
print()


for i in range(20,48):
    if (i - 20) % 3 == 0:
        print(f"{i}\t",end="")    
print()

for i in range(10,31):
    if(i-10)%4==0:
         print(f"{i}\t",end="")    
print()

for i in range(40, -1,-1):
   if(40-i)%5==0: 
    print(f"{i}\t", end="")
print()


# Ejercicio 3
print("Tabla de multiplicar del 1")
for i in range(11):
   
    print(f"{i} x 1 = {i}")   
print()


# Ejercicio 4

for i in range(1,11):
       print(f"{i**2}\t",end="")
print()

num=2
incremento=3
for i in range(10):
      print(f"{num}\t",end="")
      num+=incremento
      incremento+=2
print()


for i in range(2,8):
    print(f"{i**3}\t",end="")
    
print()

num=2
incremento=4
for i in range(7):
    print(f"{num}\t",end="")
    num+=incremento
    incremento+=2
print()

for i in range(0,5):
    print(f"{10**i}\t",end="")
print()

for i in range(0,5):
    print(f"{10**-i}\t",end="")
print()

for i in range(4):
    print("1    -1      ",end="")
print()


# Ejercicio 5

num=int(input("Escribe un numero Entero:  "))
num2=int(input(" Escribe un numero Entero:  "))

while num2<=num:
    print(f"¡Te he pedido un numero entero mayor que {num}!")
    num2=int(input("Escribe un numero Entero: "))
            
for i in range(num,num2+1):

    if i%2==0:
        print(f"El numero {i} es par")
    else:
        print(f"El numero {i} es impar")

# Ejercicio 6 

num=int(input("Escribe un numero Entero: "))
num2=int(input(f"Escribe un numero Entero mayor que {num}: "))
expresion = []
sum=0

while num2<=num:
        print(f"¡Te he pedido un numero entero mayor que {num}!")
        num2=int(input(f"Escribe un numero Entero mayor que {num}: "))
for i in range(num,num2+1):
   
    if i<=num2:
        sum+=i
        expresion.append(str(i))
print(f"La suma desde {num} hasta {num2} es {sum}")
print(" + ".join(expresion) + f" = {sum}")
print()


# Ejercicio 7

factorial=1
num=int(input("Escribe un numero mayor que cero: "))
while num<=0:
    num=int(input("Escribe un numero mayor que cero: "))
for i in range(1,num+1):
    factorial=factorial*i
print(f"El factorial de {num} es {factorial}")


# Ejercicio 8

nVeces=int(input(" ¿Cuantos valores vas a introducir?"))
while nVeces<0:
    print("Imposible")
    nVeces=int(input(" ¿Cuantos valores vas a introducir? "))

suma=0

for i in range(nVeces):
            num=float(input(f"Escribe el numero {i+1}: "))
            suma+=num

print(f"La suma de los numeros que has escrito es {suma}")


# Ejercicio 9

nVeces=int(input(" ¿Cuantos valores vas a introducir? "))
count=0
while nVeces<0:
    print("Imposible")
    nVeces=int(input(" ¿Cuantos valores vas a introducir? "))

for i in range(nVeces):
        num=float(input(f"Escribe el numero {i+1}: "))
        if num<=-1:
            count+=1

print(f"Has escrito {count} numeros negativos ")

    


# Ejercicio 10

nVeces=int(input("¿Cuantos valores vas a introducir?"))
suma=0
numeros=[]
media=0
while nVeces<0:
    print("Imposible")
    nVeces=int(input("¿Cuantos valores vas a introducir? "))


for i in range(nVeces):
    num=float(input(f"Escribe el numero {i+1}: "))
    numeros.append(num)
    suma+=num
    media=suma/nVeces
    minimo=min(numeros)
    maximo=max(numeros)
     
print(f"La media de los valores seleccionados {media}")
print(f"El minimos es {minimo}")
print(f"El maximo es {maximo}")


# Ejercicio 11
num=int(input("Escribe un número entero mayor que cero:  "))

numeros=[]
count=0

while num<=0:
    print("Imposible ")
    num=int(input("Escribe un número entero mayor que cero: "))


for i in range(num):
    i+=1
        
    if num%i==0:
        numeros.append(i)
        count+=1
if num>0:
    print(f"Los {count} divisores de {i} son {numeros}")

   
# Ejercicio 12

num=int(input("Escribe un número entero mayor que cero:  "))
numeros=[]
count=0

while num<=0:
    print("¡El número introducido debe ser un entero mayor de cero! ")       
    num=int(input("Escribe un número entero mayor que cero: "))

for i in range(1,num+1):  
    if num%i==0:
        numeros.append(i)
        count+=1
    

if count==2:
    print(f"Los {count} divisores de {i} son {numeros}")
    print(f"{num} es un numero primo")
else:
    print(f"{num} no es un numero primo")
    print(f"Los {count} divisores de {i} son {numeros}")

