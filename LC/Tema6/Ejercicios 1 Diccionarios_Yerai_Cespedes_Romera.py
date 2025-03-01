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
edad=int(input("Introduce tu edad "))
direccion=str(input("Introduce tu direccion "))
telefono=str(input("Introduce tu telefono "))

d1=dict(nombre=nombre ,edad = edad , direccion=direccion,telefono=telefono)

print(f"{d1['nombre']} tiene {d1['edad']} años, vive en {d1['direccion']} y su número de teléfono es {d1['telefono']}.")

# Ejercicio 3

fruta={'Platano':1.35,'Manzana':0.80,'Pera':0.85,'Naranja':0.70}
nFruta=str(input("\nIntroduzca la fruta que desee "))
nKilos=float(input("Introduzca el numero de kilos que desee "))
if nFruta in fruta:
    precioKilo = fruta[nFruta]
    precioTotal = precioKilo * nKilos
    print("\nFruta      Kilos      Precio ")
    print("-" * 30)
    print(f"{nFruta}    {nKilos}        {precioTotal: <10.2f}")
else:
    print("La fruta no ha sido encontrada")
print(f"\n{fruta}")

# Ejercicio 4
meses = {
    "01": "enero", "02": "febrero", "03": "marzo", "04": "abril",
    "05": "mayo", "06": "junio", "07": "julio", "08": "agosto",
    "09": "septiembre", "10": "octubre", "11": "noviembre", "12": "diciembre"
}

fecha=input("\nIntroduce una fecha en formato dd/mm/aaaa ")
dia, mes, anio = fecha.split("/")
if mes in meses:
    print(f"{dia} de {meses[mes]} de {anio}")

# Ejercicio 5

asignaturas={'Matematicas':6,'Fisica':4,'Quimica':5}

for asignatura, creditos in asignaturas.items():
    print(f"\n{asignatura} tiene {creditos} créditos")
total_creditos = sum(asignaturas.values())
print(f"\nEl total de créditos del curso es: {total_creditos}")

# Ejercicio 6

persona={}

nombre=str(input("\nIntroduzca su nombre "))
persona["nombre"]=nombre
print(persona)
edad=int(input("Introduzca su edad "))
persona["edad"]=edad
print(persona)
sexo=str(input("Introduzca su sexo "))
persona["sexo"]=sexo
print(persona)
telefono=str(input("Introduzca su numero de telefono "))
persona["telefono"]=telefono
print(persona)
correoElectronico=str(input("Introduzca su correo electronico "))
persona["correoElectronico"]=correoElectronico
print(persona)

# Ejercicio 7
cesta={}
num=int(input("\nIntroduzca cuantos productos desea añadir " ))
for i in range(num):
    articulo=str(input("Introduzca el articulo "))
    precio=float(input("Introduzca el precio del articulo "))
    cesta[articulo]=precio

for articulo,precio in cesta.items():
    print(f"Lista de la compra {articulo}: {precio}$")
print("\nLista de la compra")
print("-" * 30)
for articulo, precio in cesta.items():
    print(f"{articulo}: {precio:.2f}€")

# Calcular y mostrar el coste total
total = sum(cesta.values())
print("-" * 30)
print(f"Total: {total:.2f}€")


# Ejercicio 8

frases={}
frase=str(input("\nIntroduce palabras y traducciones en formato 'palabra:traducción' separadas por comas: "))
for par in frase.split(','):
    palabra,traduccion=par.split(':')
    frases[palabra.strip()]=traduccion.strip()

fraseEspanol=str(input("Introduce una frase en español "))

palabras=fraseEspanol.split()
traduccion=[]
for palabra in palabras:
    traduccion.append(frases.get(palabra,palabra))
    
print(' '.join(traduccion))