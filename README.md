# Guia-10

Objetivo:

Desarrollar una aplicación JAVA con OO, componentes GUI, modelo de eventos y MVC,
para el ingreso, consulta y actualización de una entidad seleccionada a su preferencia,
que no haya sido desarrollada en clase o en otro trabajo práctico.

Alcance general:

La aplicación debe incluir un menú desplegable con cuatro opciones principales:
Operaciones, Estadísticas, Sistema y Salir.

• Operaciones. Con al menos, tres de las siguientes sub-opciones:

- Ingreso.
- Consulta y actualización.
- Consulta masiva.

• Estadísticas. Con la nómina de consultas mencionadas en el apartado Alcance
detallado.

• Sistemas. Con la sub-opción:

- Acerca de. Para mostrar información del aplicativo: nombre, versión, año, autores.

• Salir. Para finalizar el uso del aplicativo, previa confirmación con el usuario.

# Alcance detallado:

Ingreso de Operaciones.

Permite el ingreso y registración en uno o más archivos TXT
plano separado por “;” (punto y coma), de toda la información relacionada con la entidad
principal y sus derivadas elegidas.

La pantalla gráfica para el ingreso de la misma debe incluir:

- Título para la ventana activa
- Cuadro de texto (dos como mínimo)
- Etiquetas
- Leyenda o comentario extenso no editable, con longitud mayor a 3 renglones
- Dos listas desplegables, donde la segunda sea dependiente de la primera
- Listas estática y dinámica con selección múltiple en ambas
- Botones de dos opciones, dentro de un panel específico
- Botones de opciones dentro de otro panel específico
- Casillas de verificación, con una de ellas activa por defecto
- Botones de acciones: Aceptar y Cancelar

Al “Aceptar” el ingreso, el sistema deberá validar que, al menos, 3 componentes de
distinto tipo estén informados, fácilmente identificables por el usuario en la pantalla.
Validar, también, que el dato ingresado no haya sido registrado previamente,
implementando excepciones propias. La información ingresada, junto con la fecha del
sistema (dd/mm/yyyy) se agregará en el archivo TXT y se blanquearán todos los campos
esperando el próximo ingreso.

Los datos orígenes de todas las listas deberán residir en distintos archivos TXT, de 3
columnas como mínimo cada una. Para el caso de la lista desplegable dependiente, el
archivo TXT tiene al menos cuatro columnas formateadas con ancho fijo, siendo la
segunda columna, la que participa en la lista, respetando el orden natural.

Al “Cancelar” el ingreso, luego que el usuario dé confirmación a tal operación, el sistema
blanqueará los campos ingresados.

Consulta y Actualización. 

El sistema deberá incluir una pantalla donde el usuario ingresará el mejor criterio de búsqueda para la información a modificar, a eliminar y/o a consultar. Al presionar el botón “Buscar”, el sistema buscará y mostrará el resto de la información existente en formato no editable. O bien, un mensaje de error indicando que
la misma no pudo ser encontrada. Al visualizar la información completa de la entidad, el usuario puede seleccionar: Editar o Anular.
Para el primer caso, “Editar”, los componentes de la pantalla pasarán a modo editable de forma tal que el usuario realice las modificaciones que desea. Y luego, seleccionará Aceptar o Cancelar, de acuerdo a lo deseado.
Para el segundo caso, “Anular”, el sistema confirmará tal operación y si es avalada por el
usuario, se eliminará la información del archivo TXT donde reside. 

Consulta Masiva. 

Esta pantalla contará con dos cuadros de texto, donde el usuario podrá
completar la información a consultar. 
El sistema mostrará en una grilla de consulta de registros, con no menos de 6 columnas,
todos aquellos que coincidan total o parcialmente con el o los criterios de búsquedas
ingresados. En caso, que el usuario no ingrese ningún filtro, se mostrarán la totalidad de
los registros.
Mostrar dichos registros ordenados en forma ascendente, según algún criterio que
considere oportuno. La pantalla deberá incluir la cantidad total de registros visualizados
y la cantidad total de registros existentes.

Estadísticas. 

En una o varias pantallas gráficas mostrar:
- Tres datos relevantes correspondiente a una o varias entidades donde uno de sus
datos miembros coincida con uno de otra entidad.
- Valor total de algún atributo numérico de alguna entidad hija donde todas sus
casillas de verificación estén activas y haya sido ingresada durante los últimos 6
meses.
- Cuatro datos de aquellas entidades, donde ningún objeto asociado por
cardinalidad múltiple coincida con el dato ingresado como argumento de la
aplicación. Guardar esta información en un archivo con formato JSON aplicando
modelo de Streamming.

Modelo de Datos a implementar:

El modelo de objetos debe incluir una entidad principal y dos o más derivadas con
diversidad de tipos de datos miembros. En las pantallas, solo estarán visibles los
componentes gráficos correspondientes a la entidad a actualizar, ya sea principal o
derivada.

Debe incluir, al menos, dos clases secundarias asociadas, que se relacionen por
agregación en un caso y por composición, en otro. Alguna de ellos, implementando
cardinalidad múltiple.
Presentar el diagrama de clases correspondiente en formato jpg y los archivos utilizados.

Aclaraciones:
✓ Solo se aceptan trabajos prácticos completos y correspondientes a la versión actual.
