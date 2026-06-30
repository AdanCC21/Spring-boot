async function getBrandDetails(id) {
    try {
        const response = await fetch('http://localhost:8080/api/brand/' + id);
        if (!response.ok) throw new Error("El servidor no respondio");
        const data = await response.json();
        return data;
    } catch (e) {
        console.error(e);
    }
}

async function setModalBrandDetails(id) {
    console.log("Fetch a los detalles de brand " + id);
    const data = await getBrandDetails(id);
    if (!data) return;
    console.log(data);
    document.getElementById('modal-id-brand').textContent = `ID : ${data.id}`;
    document.getElementById('modal-name-brand').textContent = `Nombre : ${data.name}`;

    const ul = document.getElementById('modal-products-brand');
    if (data.products && data.products.length > 0) {
        ul.innerHTML = '';
        ul.style.display = 'block';

        const fragment = document.createDocumentFragment();

        data.products.forEach(prod => {
            const li = document.createElement('li');
            li.textContent = prod.title
            fragment.appendChild(li);
        })

        ul.appendChild(fragment);

    } else {
        ul.innerHTML = '';
        ul.style.display = 'none';
    }
}