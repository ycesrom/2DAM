# Ejercicio 1
num=int(input("Introduzca un numero "))
diccionario_cuadrados = {i: i**2 for i in range(1, num+ 1)}
print(diccionario_cuadrados)

# Ejercicio 2
frase=str(input("Introduzca una frase "))
contador_caracteres = {}

# Recorrer cada carácter de la cadena
for caracter in frase:
    # Si el carácter ya está en el diccionario, incrementar su contador
    if caracter in contador_caracteres:
        contador_caracteres[caracter] += 1
    # Si no, inicializar su contador en 1
    else:
        contador_caracteres[caracter] = 1

# Mostrar el diccionario con los resultados
print("El diccionario de apariciones es:", contador_caracteres)

# Ejercicio 3
alumnos = {}
num_alumnos = int(input("Introduce el número de alumnos que vas a registrar: "))

for _ in range(num_alumnos):
        nombre = input("Introduce el nombre del alumno: ")
        if nombre in alumnos:
            print("Error: El nombre ya existe. Intenta con otro nombre.")
            continue

        notas = []
        print(f"Introduce las notas de {nombre} (escribe un número negativo para finalizar):")
        while True:
            nota = float(input("Nota: "))
            if nota < 0 or nota > 10:
                break
            notas.append(nota)
        
        alumnos[nombre] = notas

print("\nLista de alumnos y sus notas medias:")
for nombre, notas in alumnos.items():
        media = sum(notas) / len(notas) if notas else 0
        print(f"{nombre}: Nota media = {media:.2f}")

# Ejercicio 4

contactos = {}

while True:
        print("\nMenú de la agenda:")
        print("1. Añadir/Modificar contacto")
        print("2. Buscar contacto")
        print("3. Borrar contacto")
        print("4. Listar contactos")
        print("5. Salir")

        opcion = input("Elige una opción (1-5): ")

        if opcion == "1":
            nombre = input("Introduce el nombre del contacto: ")
            if nombre in contactos:
                print(f"El contacto ya existe. Teléfono actual: {contactos[nombre]}")
                modificar = input("¿Quieres modificar el teléfono? (s/n): ").lower()
                if modificar == "s":
                    telefono = input("Introduce el nuevo teléfono: ")
                    contactos[nombre] = telefono
                    print("Teléfono actualizado.")
            else:
                telefono = input("Introduce el teléfono: ")
                contactos[nombre] = telefono
                print("Contacto añadido.")

        elif opcion == "2":
            cadena = input("Introduce el inicio del nombre a buscar: ")
            encontrados = {nombre: tel for nombre, tel in contactos.items() if nombre.startswith(cadena)}
            if encontrados:
                print("Contactos encontrados:")
                for nombre, tel in encontrados.items():
                    print(f"{nombre}: {tel}")
            else:
                print("No se encontraron contactos con ese inicio.")

        elif opcion == "3":
            nombre = input("Introduce el nombre del contacto a borrar: ")
            if nombre in contactos:
                confirmar = input(f"¿Seguro que quieres borrar a {nombre}? (s/n): ").lower()
                if confirmar == "s":
                    del contactos[nombre]
                    print("Contacto borrado.")
            else:
                print("El contacto no existe.")

        elif opcion == "4":
            if contactos:
                print("Lista de contactos:")
                for nombre, tel in contactos.items():
                    print(f"{nombre}: {tel}")
            else:
                print("La agenda está vacía.")

        elif opcion == "5":
            print("Saliendo del programa. ¡Adiós!")
            break

        else:
            print("Opción no válida. Intenta de nuevo.")
