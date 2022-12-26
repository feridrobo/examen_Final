
const apiUrl = 'http://localhost:8080/noticias';

async function getAllNews() {
  try {
    const response = await fetch(apiUrl);
    const noticias = await response.json();
    console.log(noticias);
  } catch (error) {
    console.error(error);
  }
}


async function getNewsById(id) {
  try {
    const response = await fetch(`${apiUrl}/${id}`);
    const noticia = await response.json();
    console.log(noticia);
  } catch (error) {
    console.error(error);
  }
}


async function createNews(detalle) {
  try {
    const response = await fetch(apiUrl, {
      method: 'POST',
      body: JSON.stringify(detalle),
      headers: {
        'Content-Type': 'application/json'
      }
    });
    const newNews = await response.json();
    console.log(newNews);
  } catch (error) {
    console.error(error);
  }
}


async function deleteNews(id) {
    try {
        const response = await fetch(`${apiUrl}/${id}`, {
          method: 'DELETE'
        });
        const deletedNews = await response.json();
        console.log(deletedNews);
      } catch (error) {
        console.error(error);
      }}