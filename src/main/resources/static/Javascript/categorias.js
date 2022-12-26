
const apiUrl = 'http://localhost:8080/categorias';

async function getAllCategorias() {
  try {
    const response = await fetch(apiUrl);
    const categorias = await response.json();
    console.log(categorias);
  } catch (error) {
    console.error(error);
  }
}


async function getCategoriaById(id) {
  try {
    const response = await fetch(`${apiUrl}/${id}`);
    const categoria = await response.json();
    console.log(categoria);
  } catch (error) {
    console.error(error);
  }
}

async function updateCategoria(id, categoria) {
    try {
      const response = await fetch(`${apiUrl}/${id}`, {
        method: 'PUT',
        body: JSON.stringify(categoria),
        headers: {
          'Content-Type': 'application/json'
        }
      });
      const updatedCategoria = await response.json();
      console.log(updatedCategoria);
    } catch (error) {
      console.error(error);
    }
  }
  



async function createCategoria(categoria) {
  try {
    const response = await fetch(apiUrl, {
      method: 'POST',
      body: JSON.stringify(categoria),
      headers: {
        'Content-Type': 'application/json'
      }
    });
    const newCategoria = await response.json();
    console.log(newCategoria);
  } catch (error) {
    console.error(error);
  }
}


async function deleteCategoria(id) {
try {
  const response = await fetch(`${apiUrl}/${id}`, {
    method: 'DELETE'
  });
  const deletedCategoria = await response.json();
  console.log(deletedCategoria);
} catch (error) {
  console.error(error);
}
}
