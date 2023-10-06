export const FormCliente = () => {
  return `
  <form class="d-flex gap-3 flex-column">
    <div class="mb-3">
      <label for="nome" class="form-label">Nome:</label>
      <input type="text" id="nome" class="form-control">
    </div>
    <div class="mb-3">
      <label for="data" class="form-label">Data de nascimento:</label>
      <input type="date" id="data" class="form-control">
    </div>
    <div class="mb-3">
      <label for="telefone" class="form-label">Telefone:</label>
      <input type="text" id="telefone" class="form-control">
    </div>
    <div class="mb-3">
      <label for="numPassaporte" class="form-label">Número do passaporte:</label>
      <input type="text" id="numPassaporte" class="form-control">
    </div>
    <button class="btn btn-primary me-auto">Cadastrar</button>
  </form>
  `
}
