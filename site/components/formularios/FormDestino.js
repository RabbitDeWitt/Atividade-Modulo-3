export const FormDestino = () => {
  return `
  <form class="d-flex gap-3 flex-column">
    <div class="mb-3">
      <label for="nome" class="form-label">Nome:</label>
      <input type="text" id="nome" class="form-control">
    </div>
    <div class="mb-3">
      <label for="valor" class="form-label">Valor:</label>
      <input type="text" id="valor" class="form-control">
    </div>
    <div class="mb-3">
      <label for="estado" class="form-label">Estado:</label>
      <input type="text" id="estado" class="form-control" maxlength="2">
    </div>
    <div class="mb-3">
      <label for="pais" class="form-label">País:</label>
      <input type="text" id="pais" class="form-control">
    </div>
    <button class="btn btn-primary me-auto">Cadastrar</button>
  </form>
  `
}
