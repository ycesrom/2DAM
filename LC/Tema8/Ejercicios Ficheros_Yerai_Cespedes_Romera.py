#Ejercicio 1

def tabla_multiplicar():
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

tabla_multiplicar()

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

def parsear_pib(url):
    '''
    Función que parsea un fichero con pibs de países.
    Parámetros:
        url: Es una cadena con la url del fichero de texto que contiene el pib per cápita.
    Devuelve:
        Un diccionario con pares pais:pibs donde pibs es, a su vez, un diccionario con los años y los pibs del país.
    '''
    from urllib import request
    from urllib.error import URLError
    try:
        with request.urlopen(url) as f:
            datos = f.read().decode('utf-8').split('\n') # Leer los datos y guardar cada línea en una lista.
    except URLError:
        return('¡La url ' + url + ' no existe!')
    else:
        # Obtenemos los años de la primera linea del fichero.
        años = datos.pop(0).split('\t')[1:]
        # Creamos el diccionario prinpipal para guardar los pibs de todos los países.
        dict_pibs = {}
        # Bucle iterativo para recorrer las líneas del fichero.
        for pais in datos:
            datos_pais = pais.split('\t')
            # Obtenemos el código del país de los dos últimos caracteres del primer campo de la linea.
            codigo_pais = datos_pais.pop(0)[-2:]
            # Construimos un diccionario con los años y el pib del pais.
            dict_pais = {}
            # Bucle iterativo para recorrer los pibs del país.
            for i in range(len(datos_pais)):
                dict_pais[años[i].strip()] = datos_pais[i].strip()
            # Añadimos el diccionario con los pib del país al diccionario principal
            dict_pibs[codigo_pais] = dict_pais
        return dict_pibs

def pib(pibs, pais = "ES"):
    '''
    Función que recibe un diccionario con los pibs de los países y muestra por pantalla los pibs de un país dado.

    Parámetros:
        - pibs: Es un diccionario con los pibs de los países como el que devuelve la función parsear_pibs.
        - pais: Es una cadena con el código del país.

    Salida:
        Muestra por pantalla los pibs del país indicado.
    '''

    print("Año\tPIB")
    for i, j in pibs[pais].items():
        print(i, '\t', j)

pais = input('Introduce el código de un país: ')
print('Producto Interior Bruto per cápita de', pais)
pib(parsear_pib("https://ec.europa.eu/eurostat/estat-navtree-portlet-prod/BulkDownloadListing?file=data/sdg_08_10.tsv.gz&unzip=true"), pais)


    
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
        return("¡El fichero ' + file + ' no existe!\n")
    else:
        directory = f.readlines()
        f.close()
        directory = dict([tuple(line.split(',')) for line in directory])
        if client in directory:
            return directory[client]
        else:
            return("¡El cliente " + client + " no existe!\n")


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
        return("¡El fichero " + file + " no existe!\n")
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
    file = "C:\\Users\\yerai\\Downloads\\listin.txt" 
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
cotizaciones = preprocesado('C:\\Users\\yerai\\Downloads\\cotizacion.csv')
print(cotizaciones)
resumen_cotizacion(cotizaciones, 'resumen-cotizacion.csv')


#Ejercicio 8

import csv

def leer_calificaciones(fichero):
    with open(fichero, newline='', encoding='utf-8-sig') as f:
        lector = csv.DictReader(f, delimiter=';')  # Usar delimitador correcto
        print("Columnas en el archivo CSV:", lector.fieldnames)  # Verificar nombres de columnas

        lista_alumnos = []
        for fila in lector:
            fila = {clave.strip(): valor.strip() for clave, valor in fila.items()}  # Limpiar espacios

            def convertir_numerico(valor):
                """ Convierte valores numéricos, manejando vacíos y reemplazando comas """
                return float(valor.replace(',', '.')) if valor else None  # None para valores vacíos

            alumno = {
                'Apellidos': fila.get('Apellidos', 'Desconocido'),
                'Nombre': fila.get('Nombre', 'Desconocido'),
                'Asistencia': convertir_numerico(fila.get('Asistencia', '0').replace('%', '')),  # Eliminar '%'
                'Parcial1': convertir_numerico(fila.get('Parcial1', '0')),
                'Parcial2': convertir_numerico(fila.get('Parcial2', '0')),
                'Ordinario1': convertir_numerico(fila.get('Ordinario1', '')),
                'Ordinario2': convertir_numerico(fila.get('Ordinario2', '')),
                'Practicas': convertir_numerico(fila.get('Practicas', '0')),
                'OrdinarioPracticas': convertir_numerico(fila.get('OrdinarioPracticas', ''))
            }

            lista_alumnos.append(alumno)

    return lista_alumnos

# Prueba el código
archivo_csv = "C:\\Users\\yerai\\Downloads\\calificaciones.csv"
alumnos = leer_calificaciones(archivo_csv)
for alumno in alumnos:
    print(alumno)  # Verifica que los datos sean correctos

def calcular_nota_final(lista_alumnos):
    for alumno in lista_alumnos:
        p1 = alumno['Ordinario1'] if alumno['Parcial1'] < 4 and alumno['Ordinario1'] is not None else alumno['Parcial1']
        p2 = alumno['Ordinario2'] if alumno['Parcial2'] < 4 and alumno['Ordinario2'] is not None else alumno['Parcial2']
        practicas = alumno['OrdinarioPracticas'] if alumno['Practicas'] < 4 and alumno['OrdinarioPracticas'] is not None else alumno['Practicas']
        
        nota_final = (p1 * 0.3) + (p2 * 0.3) + (practicas * 0.4)
        alumno['NotaFinal'] = round(nota_final, 2)

def clasificar_alumnos(lista_alumnos):
    aprobados = []
    suspensos = []
    
    for alumno in lista_alumnos:
        if (alumno['Asistencia'] >= 75 and 
            alumno['Parcial1'] >= 4 and 
            alumno['Parcial2'] >= 4 and 
            alumno['Practicas'] >= 4 and 
            alumno['NotaFinal'] >= 5):
            aprobados.append(alumno)
        else:
            suspensos.append(alumno)
    
    return aprobados, suspensos
