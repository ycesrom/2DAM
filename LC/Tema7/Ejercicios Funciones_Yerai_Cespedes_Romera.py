# Ejercicio 1
def saludo():
    print("¡Hola amiga!")

# Ejercicio 2

def saludoNombre(nombre):
    print(f"¡hola {nombre}!")

# Ejercicio 3

def factorial(numero):
    if numero < 0:
        return "El número debe ser un entero positivo."
    elif numero == 0 or numero == 1:
        return 1
    else:
        resultado = 1
        for i in range(2, numero + 1):
            resultado *= i
        return resultado     
    
# Ejercicio 4
def calcular_factura(cantidad, porcentaje_iva=21):
    
    total = cantidad + (cantidad * porcentaje_iva / 100)
    return total

# Ejercicio 5

import math

def area_circulo(radio):
    return math.pi * radio**2

def volumen_cilindro(radio, altura):
    return area_circulo(radio) * altura

# Ejercicio 6

def calcular_media(numeros):
    return sum(numeros) / len(numeros) if numeros else 0

# Ejercicio 7

def cuadrados_lista(numeros):
    return [n**2 for n in numeros]

# Ejercicio 8

import math

def estadisticas(numeros):
    media = calcular_media(numeros)
    varianza = sum((x - media) ** 2 for x in numeros) / len(numeros)
    desviacion_tipica = math.sqrt(varianza)
    return {
        'media': media,
        'varianza': varianza,
        'desviacion_tipica': desviacion_tipica
    }

# Ejercicio 9

def es_primo(numero):
    if numero < 2:
        return False
    for i in range(2, int(numero**0.5) + 1):
        if numero % i == 0:
            return False
    return True

# Ejercicio 10

def decimal_a_binario(numero):
    return bin(numero)[2:]

# Llamando a todas las funciones juntas
saludo()
saludoNombre("Ana")
saludoNombre("Carlos")
print(factorial(5))
print(factorial(0))
print(factorial(-3))
print(calcular_factura(100))
print(calcular_factura(200, 10))
print(area_circulo(3))
print(volumen_cilindro(3, 5))
print(calcular_media([10, 20, 30]))
print(calcular_media([]))
print(cuadrados_lista([1, 2, 3, 4]))
numeros = [1, 2, 3, 4, 5]
print(estadisticas(numeros))
print(es_primo(7))
print(es_primo(10))
print(es_primo(1))
print(decimal_a_binario(10))
print(decimal_a_binario(255))
