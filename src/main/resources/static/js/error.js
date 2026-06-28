export function SetError(message) {
    if (typeof message !== 'string')
        return;
    
    const span = document.getElementById("error-msg");
    if (!span) {
        console.error("No existe la etiqua en el html para mostrar el error");
    }
    
    span.textContent = message;
    span.style.color = "#F00";
}