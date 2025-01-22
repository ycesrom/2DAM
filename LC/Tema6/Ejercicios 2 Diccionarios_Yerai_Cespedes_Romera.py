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

# Ejercicio 4