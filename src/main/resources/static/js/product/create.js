import { SetError } from '../error.js';

async function CreateProduct(dto) {
    try {
        const response = await fetch("http://localhost:8080/api/product", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(dto)
        })

        if (!response.ok) throw new Error("Error, no pudimos conectarnos con el servidor");

        const data = await response.json();
        if (!data) throw new Error("No pudimos publicar el nuevo articulo, intente de nuevo mas tarde");

        console.log("Se envio chido ", data);
        window.location.href = "/product";
    } catch (e) {
        console.error(e);
        SetError("a");
    }
}

document.getElementById('public-product-form').addEventListener('submit', async (e) => {
    e.preventDefault();

    const dto = {
        title: document.getElementById('title').value,
        brand: document.getElementById('brand').value,
        price: parseFloat(document.getElementById('price').value),
        image: document.getElementById('image').value || null
    };

    CreateProduct(dto);
});