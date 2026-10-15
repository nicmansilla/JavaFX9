package cl.duoc.table;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ProductoController {

    // ObservableList: lista que JavaFX puede observar.
    // Cuando agregamos un alumno, la tabla se actualiza sola.
    private final ObservableList<Producto> productos = FXCollections.observableArrayList();

    public VBox crearVista() {

        // Creamos la tabla que mostrará objetos de tipo Producto.
        TableView<Producto> tabla = new TableView<>();

        // Creamos la columna Nombre.
        TableColumn<Producto, String> colProducto = new TableColumn<>("Producto");

        // Indicamos que esta columna mostrará el nombre del Producto.
        colProducto.setCellValueFactory(dato ->
                new SimpleStringProperty(dato.getValue().nombre())
        );

        // Creamos la columna Categoría.
        TableColumn<Producto, String> colCategoria = new TableColumn<>("Categoría");

        // Indicamos que esta columna mostrará la Categoria del Producto.
        colCategoria.setCellValueFactory(dato ->
                new SimpleStringProperty(dato.getValue().categoria())
        );

        // Creamos la columna Precio.
        TableColumn<Producto, Number> colPrecio = new TableColumn<>("Precio");

        // Indicamos que esta columna mostrará la nota del alumno.
        colPrecio.setCellValueFactory(dato ->
                new SimpleDoubleProperty(dato.getValue().precio())
        );

        // Agregamos las columnas a la tabla.
        tabla.getColumns().addAll(colProducto, colCategoria, colPrecio);

        // Conectamos la tabla con la lista observable.
        tabla.setItems(productos);

        // Agregamos datos iniciales.
        productos.add(new Producto("Teclado", "Periféricos", 15000));
        productos.add(new Producto("Mouse", "Periféricos", 8000));
        productos.add(new Producto("Monitor", "Pantallas", 95000));

        // Campo para ingresar el nombre.
        TextField txtProducto = new TextField();
        txtProducto.setPromptText("Nombre");

        // Campo para ingresar la carrera.
        TextField txtCategoria = new TextField();
        txtCategoria.setPromptText("Categoría");

        // Campo para ingresar la nota.
        TextField txtPrecio = new TextField();
        txtPrecio.setPromptText("Precio");

        // Botón para agregar un nuevo alumno.
        Button btnAgregar = new Button("Agregar Producto");

        // Acción del botón.
        btnAgregar.setOnAction(evento -> {
            String producto = txtProducto.getText();
            String categoria = txtCategoria.getText();
            double precio = Double.parseDouble(txtPrecio.getText());

            // Agregamos el producto a la lista observable.
            productos.add(new Producto(producto, categoria, precio));

            // Limpiamos los campos.
            txtProducto.clear();
            txtCategoria.clear();
            txtPrecio.clear();
        });

        // VBox ordena los elementos de arriba hacia abajo.
        return new VBox(10, tabla, txtProducto, txtCategoria, txtPrecio, btnAgregar);
    }
}
