# 📚 Guía Completa de Referencia: JavaFX (FXML y Kotlin MainController)

Guía unificada de consulta rápida para el desarrollo de interfaces gráficas en JavaFX utilizando **FXML** para la vista y **Kotlin** para el controlador.

---

# 🎨 PARTE 1: Vista Gráfica (`main.fxml`)

## 🏗️ 1. Estructura y Contenedores Principales

### `<VBox/>`
Contenedor de maquetación vertical. Organiza sus elementos uno debajo de otro. Ideal para listas, formularios verticales y centrado global de ventanas.

* **`xmlns:fx="http://javafx.com/fxml"`**: Espacio de nombres obligatorio para las funciones avanzadas de FXML (como `fx:id` o `fx:controller`).
* **`fx:controller="MainController"`**: Asocia el archivo FXML con su clase controladora en Kotlin (debe coincidir exactamente en mayúsculas/minúsculas).
* **`alignment="CENTER"`**: Alineación interna de los elementos (`TOP_LEFT`, `CENTER`, `BOTTOM_RIGHT`, etc.).
* **`spacing="15.0"`**: Espacio vertical en píxeles entre cada elemento hijo.
* **`prefWidth="400.0"` / `prefHeight="300.0"`**: Ancho y alto preferidos del contenedor raíz.
* **`style="-fx-background-color: #f0f0f0;"`**: Cambia el color de fondo mediante CSS en línea.

---

### `<HBox/>`
Contenedor de maquetación horizontal. Organiza sus elementos uno al lado del otro. Ideal para grupos de botones alineados horizontalmente.

* **`alignment="CENTER"`**: Alinea los elementos en el centro del eje horizontal/vertical.
* **`spacing="10.0"`**: Espacio horizontal en píxeles entre cada elemento hijo.

---

### `<Insets/>`
Elemento de configuración para definir márgenes internos (*padding*) alrededor de un contenedor (como `VBox` o `HBox`).

* **`top="20.0"` / `right="20.0"` / `bottom="20.0"` / `left="20.0"`**: Márgenes en píxeles.

---

## 🔤 2. Textos y Captura de Datos

### `<Label/>`
Componente para mostrar texto de solo lectura en la interfaz gráfica (títulos, avisos, resultados).

* **`fx:id="lblMensaje"`**: Identificador único para vincularlo con el controlador Kotlin (`@FXML lateinit var lblMensaje: Label`).
* **`text="¡Hola, mundo!"`**: Texto visible dentro de la etiqueta.
* **`alignment="CENTER"`**: Alineación del texto dentro del espacio del `Label`.
* **`wrapText="true"`**: Hace que el texto salte automáticamente de línea si supera el ancho.
* **`style="-fx-font-size: 16px; -fx-text-fill: red;"`**: Ajusta tamaño, color y fuente en CSS.

---

### `<TextField/>`
Campo de texto editable de una sola línea para la entrada de datos por parte del usuario.

* **`fx:id="txtNombre"`**: Identificador para leer/escribir su valor desde Kotlin (`txtNombre.text`).
* **`promptText="Introduce tu nombre..."`**: Texto en gris que sugiere al usuario qué escribir (desaparece al escribir o enfocar).
* **`prefWidth="150.0"`**: Ancho preferido del campo en píxeles.
* **`maxWidth="150.0"`**: Ancho máximo permitido (útil dentro de un `VBox` que estira los elementos por defecto).
* **`alignment="CENTER_RIGHT"`**: Alinea el texto a la derecha (ideal para entrada de datos numéricos).
* **`editable="false"`**: Deshabilita la edición por parte del usuario (para campos de solo lectura).
* **`focusTraversable="false"`**: Evita que reciba el foco inicial automático al abrir la ventana.

---

### `<PasswordField/>`
Variante del `TextField` que oculta los caracteres introducidos mediante puntos o asteriscos (para contraseñas).

* **`fx:id="pwdClave"`**: Identificador para acceder a la contraseña en texto plano desde Kotlin.
* **`promptText="Escribe tu contraseña"`**: Texto de sugerencia inicial.

---

## 🔘 3. Botones e Interacción

### `<Button/>`
Botón interactivo que ejecuta una acción cuando el usuario hace clic sobre él.

* **`fx:id="btnEnviar"`**: Identificador si necesitas modificar el botón desde Kotlin (ej. cambiar texto o deshabilitarlo).
* **`text="Aceptar"`**: Texto que se muestra dentro del botón.
* **`onAction="#onSaludarClick"`**: Asocia el clic del botón a una función anotada con `@FXML` en el controlador Kotlin.
* **`disable="true"`**: Deshabilita el botón visualmente e impide la interacción.
* **`defaultButton="true"`**: Ejecuta la acción automáticamente al pulsar la tecla `Enter`.
* **`cancelButton="true"`**: Asocia el botón a la tecla `ESC`.

---

## 🔘 4. Opciones de Selección y Desplegables

### `<RadioButton/>`
Botón de opción única dentro de un conjunto. Al seleccionar uno, se desmarcan automáticamente los demás del mismo grupo.

* **`fx:id="rbMasculino"`**: Identificador único.
* **`text="Masculino"`**: Etiqueta descriptiva de la opción.
* **`toggleGroup="$grupoGenero"`**: Asocia el botón a un grupo lógico (`ToggleGroup`) definido en `<fx:define>`.
* **`selected="true"`**: Marca la opción por defecto al cargar la pantalla.

---

### `<ToggleGroup/>`
Objeto invisible que agrupa lógicamente varios `RadioButton` para hacerlos mutuamente exclusivos. Se define dentro de `<fx:define>`.

* **`fx:id="grupoGenero"`**: Identificador que luego se asigna en `toggleGroup="$grupoGenero"` de cada `RadioButton`.

---

### `<CheckBox/>`
Casilla de verificación para selecciones múltiples independientes (se pueden marcar o desmarcar varios a la vez).

* **`fx:id="chkDeportes"`**: Identificador para comprobar en Kotlin si está marcado (`chkDeportes.isSelected`).
* **`text="Música"`**: Etiqueta que acompaña a la casilla.
* **`selected="true"`**: Casilla marcada por defecto.

---

### `<ComboBox/>`
Menú o lista desplegable para seleccionar una única opción de un listado de elementos.

* **`fx:id="cmbPaises"`**: Identificador para gestionar/leer los elementos en Kotlin.
* **`promptText="Selecciona un país"`**: Texto de ayuda visible cuando no hay ninguna opción seleccionada.

---

## 📋 5. Menús de Aplicación

### `<MenuBar/>`
Barra contenedora horizontal superior que aloja los menús desplegables de la aplicación.

* **`MenuBar`**: Contenedor principal que se coloca normalmente en la parte superior del contenedor raíz.

---

### `<Menu/>`
Cada una de las secciones principales de la barra de menú (ej. "Archivo", "Editar", "Ayuda").

* **`text="Opciones"`**: Texto visible en la barra de menú.

---

### `<MenuItem/>`
Acción o elemento individual ejecutable dentro de un menú desplegable.

* **`fx:id="itemLogin"`**: Identificador único.
* **`text="Iniciar Sesión"`**: Texto de la opción.
* **`onAction="#onAbrirLogin"`**: Función que se ejecuta al seleccionar la opción.

---

## 🛠️ 6. Secciones Especiales y Plantilla FXML

### `<fx:define/>`
Bloque especial de FXML utilizado para instanciar elementos lógicos que no forman parte de la jerarquía visual de componentes (como el `ToggleGroup`).

```xml
<fx:define>
    <ToggleGroup fx:id="grupoGenero"/>
</fx:define>
