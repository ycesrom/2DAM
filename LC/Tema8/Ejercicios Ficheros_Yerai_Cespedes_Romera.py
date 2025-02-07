#Ejercicio 1

def tablaMultiplicar():
    while True:
        try:
            num = int(input("Introduzca un número de 1 a 10: "))
            if 1 <= num <= 10:
                nombre_fichero = f"tabla_del_{num}.txt"
                with open(nombre_fichero, "w") as f:
                    for i in range(1, 11):
                        f.write(f"{num} x {i} = {num * i}\n")
                print(f"Tabla de multiplicar del {num} guardada en {nombre_fichero}.")
                break  # Salir del bucle si la entrada es válida
            else:
                print("El número debe estar entre 1 y 10.")
        except ValueError:
            print("Por favor, introduzca un número entero válido.")

tablaMultiplicar()

#Ejercicio 2

import os

def leer_tabla_multiplicar():
    # Solicitar número válido entre 1 y 10
    while True:
        try:
            n = int(input("Introduce un número entero entre 1 y 10: "))
            if 1 <= n <= 10:
                break
            else:
                print("El número debe estar entre 1 y 10. Inténtalo de nuevo.")
        except ValueError:
            print("Error: Debes introducir un número entero.")

    # Construir nombre del archivo
    nombre_archivo = f"tabla_del_{n}.txt"

    # Verificar si el archivo existe y mostrar contenido
    if not os.path.exists(nombre_archivo):
        print(f"El archivo {nombre_archivo} no existe.")
        return

    # Leer y mostrar el contenido del archivo
    try:
        with open(nombre_archivo, 'r') as archivo:
            contenido = archivo.read()
            print(f"\nTabla del {n}:\n{contenido}")
    except Exception as e:
        print(f"Error al leer el archivo: {str(e)}")

leer_tabla_multiplicar()


#Ejercicio 3

n = int(input('Introduce un número entero entre 1 y 10: '))
m = int(input('Introduce otro número entero entre 1 y 10: '))
nombre_fichero = f"tabla_del_{n}.txt"
try: 
    with open(nombre_fichero, 'r') as f:
        lineas = f.readlines()
    print(lineas[m - 1])
except FileNotFoundError:
    print('No existe el fichero con la tabla del ', n)

#Ejercicio 4

def contar_palabras(url):
    '''
    Función que recibe recibe la url de un fichero de texto y devuelve el número de palabras que contiene.
    Parámetros:
        url: Es una cadena con la url del fichero de texto.
    Devuelve:
        El número de palabras que contiene el fichero de texto daro por la url.
    '''
    from urllib import request
    from urllib.error import URLError
    try:
        f = request.urlopen(url)
    except URLError:
        return('¡La url ' + url + ' no existe!')
    else:
        contenido = f.read()
        return len(contenido.split())

print(contar_palabras('https://www.gutenberg.org/files/2000/2000-0.txt'))


#Ejercicio 5

def pib_pais(url, pais = "ES"):
    '''
    Función que muestra por pantalla el pib per cápita un país dado de los años disponibles en un fichero dado.
    Parámetros:
        url: Es una cadena con la url del fichero de texto que contiene el pib per cápita.
        pais: Es una cadena con el código del país. 
    Devuelve:
        Un diccionario con pares año:pib del país dado que hay en el fichero con la url dada.
    '''
    from urllib import request
    from urllib.error import URLError
    try:
        with request.urlopen(url) as f:
            datos = f.read().decode('utf-8').split('\n') # Leer los datos y guardar cada línea en una lista
    except URLError:
        return('¡La url ' + url + ' no existe!')
    else:
        datos = [i.split('\t') for i in datos] # Dividir cada línea por el tabulador
        datos = [list(map(str.strip, i)) for i in datos] # Eliminar espacios en blanco
        for i in datos:
            i[0] = i[0][-2:] # Obtener el código del país de los dos últimos caracteres del primer elemento de la lista
        datos[0][0] = 'años'
        # Creamos un diccionario con claves los códiogos de los países y valores la lista de sus pibs (a excepción del primer par que contiene los años).
        datos = {i[0]:i[1:] for i in datos}
        # Creamos y devolvemos el diccionario con los pibs del país
        return {datos['años'][i]:datos[pais][i] for i in range(len(datos['años']))}

pais = input('Introduce el código de un país: ')
print('Producto Interior Bruto per cápita de', pais)
print("Año\tPIB")
for i, j in pib_pais("https://ec.europa.eu/eurostat/estat-navtree-portlet-prod/BulkDownloadListing?file=data/sdg_08_10.tsv.gz&unzip=true", pais).items():
    print(i, '\t', j)
    
#Ejercicio 6

def get_phone(file, client):
    '''
    Función que devuelve el teléfono de un cliente de un fichero dado.
    Parámetros:
        file: Es un fichero con los nombres y teléfonos de clientes.
        client: Es una cadena con el nombre del cliente.
    Devuelve:
        El teléfono del cliente guardado en el fichero o un mensaje de error si el teléfono o el fichero no existe.
    '''
    try: 
        f = open(file, 'r')
    except FileNotFoundError:
        return('¡El fichero ' + file + ' no existe!\n')
    else:
        directory = f.readlines()
        f.close()
        directory = dict([tuple(line.split(',')) for line in directory])
        if client in directory:
            return directory[client]
        else:
            return('¡El cliente ' + client + ' no existe!\n')


def add_phone(file, client, telf):
    '''
    Función que añade el teléfono de un cliente de un fichero dado.
    Parámetros:
        file: Es un fichero con los nombres y teléfonos de clientes.
        client: Es una cadena con el nombre del cliente.
        telf: Es una cadena con el teléfono del cliente.
    Devuelve:
        Un mesaje informando sobre si el teléfono se ha añadido o ha habido algún problema.
    '''
    try: 
        f = open(file, 'a')
    except FileNotFoundError:
        return('¡El fichero ' + file + ' no existe!\n')
    else:
        f.write(client + ',' + telf + '\n')
        f.close()
        return('El teléfono se ha añadido.\n')

def remove_phone(file, client):
    '''
    Función que elimina el teléfono de un cliente de un fichero dado.
    Parámetros:
        file: Es un fichero con los nombres y teléfonos de clientes.
        client: Es una cadena con el nombre del cliente.
    Devuelve:
        Un mesaje informando sobre si el teléfono se ha borrado o ha habido algún problema.
    '''
    try: 
        f = open(file, 'r')
    except FileNotFoundError:
        return('¡El fichero ' + file + ' no existe!\n')
    else:
        directory = f.readlines()
        f.close()
        directory = dict([tuple(line.split(',')) for line in directory])
        if client in directory:
            del directory[client]
            f = open(file, 'w')
            for name, telf in directory.items():
                f.write(name + ',' + telf)
            f.close()
            return ('¡El cliente se ha borrado!\n')
        else:
            return('¡El cliente ' + client + ' no existe!\n')


def create_directory(file):
    '''
    Función que crea un fichero vacío para guardar un listín telefónico.
    Parámetros:
        file: Es un fichero.
    Devuelve:
        Un mesaje informando sobre si el fichero se ha creado correctamente o no.
    '''
    import os
    if os.path.isfile(file):
        answer = input('El fichero ' + file + ' ya existe. ¿Desea vaciarlo (S/N)? ')
        if answer == 'N': 
            return 'No se ha creado el fichero porque ya existe.\n'
    f = open(file, 'w')
    f.close()
    return 'Se ha creado el fichero.\n'
     

def menu():
    '''
    Función que presenta un menú con las operaciones disponibles sobre un listín telefónico y devuelve la opción seleccionada por el usuario.
    Devuelve:
        La opción seleccionada por el usuario.
    '''
    print('Gesión del listín telefónico')
    print('============================')
    print('1 - Consultar un teléfono')
    print('2 - Añadir un teléfono')
    print('3 - Eliminar un teléfono')
    print('4 - Crear el listín')
    print('0 - Terminar')
    option = input('Introduzca el número de la opción deseada: ')
    return option


def directory():
    '''
    Función que lanza la aplicación para la gestión del listín telefónico.
    '''
    file = 'listin.txt' 
    while True:
        option = menu()
        if option == '1':
            name = input('Introduce el nombre del cliente: ')
            print(get_phone(file, name))
        elif option == '2':
            name = input('Introduce el nombre del cliente: ')
            telf = input('Introduce el teléfono del cliente: ')
            print(add_phone(file, name, telf))
        elif option == '3':
            name = input('Introduce el nombre del cliente: ')
            print(remove_phone(file, name))
        elif option == '4':
            print(create_directory(file))
        else:
            break
    return

directory()

#Ejercicio 7

def limpiar(cifra):
    """
    Función que elimina los puntos de separación de miles y cambia las comas de separación de decimales por puntos.
    Parámetros:
        - cifra: Es una cadena con una cifra
    Devuelve:
        Un real con la cifra de la cadena después de eliminar el separador de miles y cambiar el separador de decimales por punto.
    """
    cifra = cifra.replace('.', '')
    cifra = cifra.replace(',','.')
    return float(cifra) 

def preprocesado(ruta):
    """
    Función que preprocesa los datos contenidos en un fichero con formato csv y devuelve un diccionario con los nombres de las columnas como claves y las listas de valores asociados a ellas.
    Parámetros:
        - ruta: Es una cadena con la ruta del fichero.
    Devuelve:
        Un diccionario con pares formados por los nombres de las columnas y las listas de valores en las columnas.
    """
    try:
        # Abrimos el fichero en modo lectura
        with open(ruta, 'r') as f:
            # Leemos el fichero por líneas en una lista
            lineas = f.read().split('\n')
    except FileNotFoundError:
        print('El fichero no existe.')
        return
    
    # Leemos las claves del primer elemento de la lista y creamos una lista dividiendo la línea por el punto y coma.
    claves = lineas.pop(0).split(";")
    # Creamos el diccionario para guardar las cotizaciones
    cotizaciones = {}
    # Inicializamos el diccionario con listas vacías
    for i in claves:
        cotizaciones[i] = []
    # Bucle iterativo para recorrer la lista de lineas
    for linea in lineas:
        # Creamos una lista con los campos dividiendo la línea por el punto y coma
        campos = linea.split(';')
        # Añadimos el primer campo (el nombre de la empresa) a la lista del diccionario
        cotizaciones[claves[0]].append(campos[0])
        # Bucle iterativo para añadir el resto de los campos a las listas correspondientes del diccionario. 
        # Previamente los campos se limpian del carácter de separación de miles y se sustituye la coma por el punto para el separador de decimales.
        for i in range(1, len(campos)):
            cotizaciones[claves[i]].append(limpiar(campos[i]))
    return cotizaciones


def resumen_cotizacion(cotizaciones, ruta):
    """
    Función que recibe un diccionario con los valores de cotización y crear un fichero con un resumen con el mínimo, el máximo y la media.
    Parámetros:
        - cotizaciones: Es un diccionario con pares cuyas claves son los nombres de la variables medidas y cuyos valores son las listas de valores de cada variable.
        - ruta: Es una cadena con la ruta del fichero.
    """
    # Eliminamos el primer par del diccionario que contiene los nombres de las empresas.
    del(cotizaciones['Nombre'])
    # Inicializamos una cadena con el contenido que después se escribirá en el fichero.
    contenido = ""
    # Escribimos en la primera línea los nombres de las columnas.
    contenido += 'Nombre'
    # Bucle iterativo para crear los encabezados de las cotizaciones.
    for i in cotizaciones:
        contenido += ";" + i
    # Calculamos los mínimos de cada lista y los escribimos en las columnas correspondientes
    contenido += '\nMínimo'
    for i in cotizaciones.values():
        contenido += ';' + str(min(i))
    # Calculamos los máximos de cada lista y los escribimos en las columnas correspondientes
    contenido += '\nMáximo'
    for i in cotizaciones.values():
        contenido += ';' + str(max(i))
    # Calculamos las medias de cada lista y las escribimos en las columnas correspondientes
    contenido += '\nMedia'
    for i in cotizaciones.values():
        contenido += ';' + str(sum(i)/len(i))
    # Abrimos el fichero en modo escritura.
    with open(ruta, 'w') as f:
        # Escribimos el contenido en el fichero
        f.write(contenido)
    return


# Llamada a las funciones de prueba
cotizaciones = preprocesado('cotizacion.csv')
print(cotizaciones)
resumen_cotizacion(cotizaciones, 'resumen-cotizacion.csv')


#Ejercicio 8