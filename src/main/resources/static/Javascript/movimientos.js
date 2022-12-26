// URL base de la API de movimientos
const apiUrl = 'http://localhost:8080/movimientos';

// Función para obtener todos los movimientos
async function getMovimientos() {
  try {
    const response = await fetch(apiUrl);
    const movimientos = await response.json();
    console.log(movimientos);
  } catch (error) {
    console.error(error);
  }
}

// Función para obtener un movimiento por su ID
async function getMovimientoById(id) {
  try {
    const response = await fetch(`${apiUrl}/${id}`);
    const movimiento = await response.json();
    console.log(movimiento);
  } catch (error) {
    console.error(error);
  }
}

// Función para crear un nuevo movimiento
async function createMovimiento(movimiento) {
  try {
    const response = await fetch(apiUrl, {
      method: 'POST',
      body: JSON.stringify(movimiento),
      headers: {
        'Content-Type': 'application/json'
      }
    });
    const newMovimiento = await response.json();
    console.log(newMovimiento);
  } catch (error) {
    console.error(error);
  }
}

// Función para eliminar un movimiento por su ID
async function deleteMovimiento(id) {
  try {
    const response = await fetch(`${apiUrl}/${id}`, {
      method: 'DELETE'
    });
    const deletedMovimiento = await response.json();
    console.log(deletedMovimiento);
  } catch (error) {
    console.error(error);
  }
}