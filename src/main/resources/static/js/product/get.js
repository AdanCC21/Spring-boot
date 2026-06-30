async function GetById(id) {
    try {
        const response = await fetch(`http://localhost:8080/api/product/${id}`);

        if (!response.ok) {
            throw new Error("El servidor no responde correctamente")
        }

        const data = await response.json();
        return data;
    } catch (e) {
        console.error(e);
    }
}

async function OpenProductDetails(id) {
    console.log("Obtieniendo info");
    console.log(id);
    const product = await GetById(id);
    if (!product) return;

    console.log(product);

    if (product.image) {
        const image = document.getElementById("modal-imagen-producto");
        image.setAttribute('src', product.image);
        image.style.display = 'block';
    }

    document.getElementById("modal-titulo-producto").textContent = product.title;
    document.getElementById("modal-precio-producto").textContent = product.price;
}