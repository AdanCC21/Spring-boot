const Modal = (() => {
    const CLOSE_DURATION = 250;

    function open(id) {
        const overlay = document.getElementById(id);
        if (!overlay) return;

        overlay.classList.remove('is-closing');
        overlay.classList.add('is-open');

        // Foco al primer elemento interactivo dentro del modal
        const focusable = overlay.querySelector(
            'button, [href], input, select, textarea, [tabindex]:not([tabindex="-1"])'
        );
        if (focusable) focusable.focus();

        // Cerrar al hacer clic fuera del contenedor
        overlay.addEventListener('click', _handleOverlayClick);

        // Cerrar con Escape
        document.addEventListener('keydown', _handleKeydown);
    }

    function close(id) {
        const overlay = document.getElementById(id);
        if (!overlay) return;

        overlay.classList.add('is-closing');

        setTimeout(() => {
            overlay.classList.remove('is-open', 'is-closing');
            overlay.removeEventListener('click', _handleOverlayClick);
            document.removeEventListener('keydown', _handleKeydown);
        }, CLOSE_DURATION);
    }

    function _handleOverlayClick(e) {
        // Solo cierra si el clic fue directo sobre el overlay (no en el contenedor)
        if (e.target === e.currentTarget) {
            close(e.currentTarget.id);
        }
    }

    function _handleKeydown(e) {
        if (e.key === 'Escape') {
            const openModal = document.querySelector('.modal-overlay.is-open');
            if (openModal) close(openModal.id);
        }
    }

    return { open, close };

})();