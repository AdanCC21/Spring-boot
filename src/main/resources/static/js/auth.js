import { SetError } from './error.js'

export async function RegUser() {
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const confirm_password = document.getElementById('confirm-password').value;

    if (password !== confirm_password) {
        const msg = "Las contraseñas no son iguales."
        document.getElementById('error').textContent = msg
        console.error(msg);
        return;
    }

    SetError("Error de prueba");

    try {
        const response = await fetch('http://localhost:8080/api/user', {
            method: 'POST', headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                name,
                email,
                password
            })
        })

        if (!response.ok) {
            throw new Error("El servidor no respondio");
        }

        const data = await response.json();
        if (!data) {
            throw new Error("El servidor no respondio correctamente");
        }

        localStorage.setItem("user", JSON.stringify(data));
        // window.location.href = "/";
    } catch (e) {
        console.error(e);
        SetError("Error del servidor");
    }
}

document.getElementById('send-form').addEventListener("click", async (e) => {
    e.preventDefault();
    console.log("Subiendo form");

    RegUser();
})