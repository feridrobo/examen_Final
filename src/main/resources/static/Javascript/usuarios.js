// URL base de la API de usuarios
const apiUrl = 'http://localhost:8080/api/usuarios';

// Función para obtener todos los usuarios
async function getUsuarios(token) {
  try {
    const response = await fetch(apiUrl, {
      headers: {
        'Authorization': token
      }
    });
    const usuarios = await response.json();
    console.log(usuarios);
  } catch (error) {
    console.error(error);
  }
}

// Función para registrar un nuevo usuario
async function registrarUsuario(usuario) {
  try {
    const response = await fetch(apiUrl, {
      method: 'POST',
      body: JSON.stringify(usuario),
      headers: {
        'Content-Type': 'application/json'
      }
    });
  } catch (error) {
    console.error(error);
  }
}

// Función para eliminar un usuario por su ID
async function eliminarUsuario(token, id) {
  try {
    const response = await fetch(`${apiUrl}/${id}`, {
      method: 'DELETE',
      headers: {
        'Authorization': token
      }
    });
  } catch (error) {
    console.error(error);
  }
}
